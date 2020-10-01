#include "treemap.h"
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void treemap_init(treemap_t *tree)
{
  tree->root = NULL;  //setting root to null
  tree->size = 0;   //setting size of tree to 0
}

int treemap_add(treemap_t *tree, char key[], char val[]){
  if(tree->root == NULL){
    node_t *n = malloc(sizeof(node_t));
    strcpy(n->key,key); //copying input key into tree
    strcpy(n->val,val); //copying input val into tree
    n->left = NULL;
    n->right = NULL;
    tree->root = n;   //set root to new node
    tree->size++; //incrementing size
    return 1;
  }
  node_t *cur = tree->root;
  while(1){
    int diff = strcmp(key,cur->key);
    if(diff == 0){  //if diff is zero then we are altering an existing key
      strcpy(cur->val,val);
      return 0; //indicates to main we are editing an existing value
    }
    else if(diff < 0){  //if new string is less than cur's string then go left
      if(cur->left == NULL){
        node_t *temp = malloc(sizeof(node_t));
        strcpy(temp->key,key);
        strcpy(temp->val,val);
        temp->left = NULL;
        temp->right = NULL;
        cur->left = temp; //add new node to tree
        tree->size++;
        return 1;
      }
      else{
        cur = cur->left;  //shift to the left if nothing is there
      }
    }
    else{ //if new string is more than diff go right
      if(cur->right == NULL){
        node_t *temp = malloc(sizeof(node_t));
        strcpy(temp->key,key);
        strcpy(temp->val,val);
        temp->left = NULL;
        temp->right = NULL;
        cur->right = temp;  //add new node to the tree
        tree->size++;
        return 1;
      }
      else{
        cur = cur->right; //shift to the right if nothing is there
      }
    }
  }
  return -1;  //never reaches here
}

char *treemap_get(treemap_t *tree, char key[])
{
  node_t *cur = tree->root;
  while(cur != NULL)//go until end of tree
  {
    int x = strcmp(key, cur->key);
    if(x == 0) // they are the same
    {
      return cur->val;
    }
    else if(x < 0)  // move left
    {
      cur = cur->left;
    }
    else  //move right
    {
      cur = cur->right;
    }
  }
  return NULL;  //key not in the tree
}

void node_remove_all(node_t *cur)
{
  if(cur == NULL)//should never happen
  {
    return;
  }

  if(cur->left != NULL) //if there is node to the left go there
  {
    node_remove_all(cur->left);
  }
  if(cur->right != NULL)  //if there is node to the right go there
  {
    node_remove_all(cur->right);
  }
  free(cur);  //frees the current node from memory
}

void treemap_clear(treemap_t *tree)
{
  tree->size = 0;
  node_remove_all(tree->root);  //send root node to helper
  tree->root = NULL;//set root to null after freeing it all
}

void node_print_revorder(node_t *cur, int indent) //order is right current left
{
  if(cur == NULL)
  {
    return;
  }
  if(cur->right != NULL)
  {
    node_print_revorder(cur->right, indent + 1);  //always increment indent by 1
  }
  for(int i = 0; i < indent; i++) //prints spaces before the key val pair. 2 spaces per indent
  {
    printf("  ");
  }
  printf("%s -> %s\n",cur->key,cur->val);//prints the key val pair
  if(cur -> left != NULL)
  {
    node_print_revorder(cur->left, indent + 1);
  }
}

void treemap_print_revorder(treemap_t *tree)
{
  if(tree == NULL)//never should occur
  {
    return;
  }
  node_t *cur = tree->root;
  node_print_revorder(cur, 0);//puts tree into helper, starts with no indents
}

void node_write_preorder(node_t *cur, FILE *out, int depth)//order is curr, left, right
{
  if(cur == NULL)
  {
    return;
  }
  for(int i = 0; i < depth; i++)
  {
    fprintf(out,"  ");//2 spaces per depth, same as indent
  }
  fprintf(out,"%s %s\n", cur->key, cur->val); //writes key val combo to file
  if(cur->left != NULL)
  {
      node_write_preorder(cur->left,out,depth+1);
  }
  if(cur->right != NULL)
  {
      node_write_preorder(cur->right,out,depth+1);
  }
}

void treemap_print_preorder(treemap_t *tree)
{
  if(tree == NULL)
  {
    return;
  }
  node_t *cur = tree->root;
  node_write_preorder(cur,stdout,0);  //sends root node to helper, writing to standard output
}

void treemap_save(treemap_t *tree, char *fname)
{
  node_t *cur = tree->root;
  FILE *temp = fopen(fname, "w"); //opens file
  node_write_preorder(cur,temp,0);  //calls helper to write current tree to file
  fclose(temp); //closes file
}

int treemap_load(treemap_t *tree, char *fname)
{

  FILE *temp = fopen(fname, "r"); //opens file
  if(temp == NULL)
  {
    return 0;//file doesnt exist or didnt load properly
  }
  treemap_clear(tree);//clears tree before writing new one
  char holder[128]; //holds key
  char holder2[128];  //holds val
  while(fscanf(temp,"%s %s", holder, holder2)!= EOF)  //while file isnt empty
  {
    treemap_add(tree,holder,holder2);
  }
  fclose(temp);//close file
  return 1;//everything worked as intended
}
