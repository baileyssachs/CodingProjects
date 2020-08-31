//helge393
//sachs096

public class MyMaze {
    Cell[][] maze;

    public MyMaze(int rows, int cols) {
        maze = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = new Cell();//initializes a cell in each spot in the 2d array
                if (i == rows - 1 && j == cols - 1)//checks if bottom right(where exit goes)
                    maze[i][j].setRight(false);//creates the exit by opening the wall
            }
        }
    }

    /* TODO: Create a new maze using the algorithm found in the writeup. */
    public static MyMaze makeMaze(int rows, int cols) {
        MyMaze newMaze = new MyMaze(rows, cols);//have to create a new maze because method is static
        Stack1Gen make = new Stack1Gen();
        int[] temp = new int[2];
        int[] temp2 = new int[2];
        temp[0] = 0;
        temp[1] = 0;
        temp2[0] = temp[0];
        temp2[1] = temp[1];
        make.push(temp2);
        newMaze.maze[0][0].setVisited(true);//starts at top left corner
        while (!make.isEmpty()) {
            temp = (int[]) make.top();
            boolean allVisited = true;
            if (temp[0] - 1 >= 0) {//checks to make sure not out of bounds
                if (!newMaze.maze[temp[0] - 1][temp[1]].getVisited()) {//checks if it has been visited or now
                    allVisited = false;
                }
            }
            if (temp[0] + 1 <= newMaze.maze.length - 1) {//checks to make sure not out of bounds
                if (!newMaze.maze[temp[0] + 1][temp[1]].getVisited()) {//checks if it has been visited or now
                    allVisited = false;
                }
            }
            if (temp[1] - 1 >= 0) {//checks to make sure not out of bounds
                if (!newMaze.maze[temp[0]][temp[1] - 1].getVisited()) {//checks if it has been visited or now
                    allVisited = false;
                }
            }
            if (temp[1] + 1 <= newMaze.maze[0].length - 1) {//checks to make sure not out of bounds
                if (!newMaze.maze[temp[0]][temp[1] + 1].getVisited()) {//checks if it has been visited or now
                    allVisited = false;
                }
            }
            boolean breaker = false;//this will break the next loop if all spots around current spot have been visited
            if (allVisited) {
                make.pop();//goes back one stop in the maze and repeats the whole process
                breaker = true;
            }
            while (!allVisited) {    //allVisited becomes a temp variable to confirm that a neighbor location has been chosen
                if (breaker)//stops the whole loop if all have been visited
                    break;
                int newTemp = (int) (Math.random() * 4);
                if (newTemp == 0) {
                    if ((temp[0] - 1) < 0 || newMaze.maze[temp[0] - 1][temp[1]].getVisited())//checks out of bounds and that it hasnt been visited before
                        newTemp = (int) (Math.random() * 4);//if it has been visited goes to a new spot around the current one.
                    else {
                        newMaze.maze[temp[0] - 1][temp[1]].setBottom(false);//opens a hole downward above itself(therefore opening a hole above current tile)
                        newMaze.maze[temp[0] - 1][temp[1]].setVisited(true);
                        temp[0]--;
                        temp2 = new int[2];
                        temp2[0] = temp[0];
                        temp2[1] = temp[1];
                        make.push(temp2);//initialized new arrays so they arent changed down the line when temp changes
                        allVisited = true;
                    }
                } else if (newTemp == 1) {
                    if ((temp[0] + 1) > newMaze.maze.length - 1 || newMaze.maze[temp[0] + 1][temp[1]].getVisited())//checks out of bounds and that it hasnt been visited before
                        newTemp = (int) (Math.random() * 4);
                    else {
                        newMaze.maze[temp[0]][temp[1]].setBottom(false);//opens a hole below current tile
                        newMaze.maze[temp[0] + 1][temp[1]].setVisited(true);
                        temp[0]++;
                        temp2 = new int[2];
                        temp2[0] = temp[0];
                        temp2[1] = temp[1];
                        make.push(temp2);//initialized new arrays so they arent changed down the line when temp changes
                        allVisited = true;
                    }
                } else if (newTemp == 2) {
                    if ((temp[1] - 1) < 0 || newMaze.maze[temp[0]][temp[1] - 1].getVisited())//checks out of bounds and that it hasnt been visited before
                        newTemp = (int) (Math.random() * 4);
                    else {
                        newMaze.maze[temp[0]][temp[1] - 1].setRight(false);//opens a hole to the left of tile
                        newMaze.maze[temp[0]][temp[1] - 1].setVisited(true);
                        temp[1]--;
                        temp2 = new int[2];
                        temp2[0] = temp[0];
                        temp2[1] = temp[1];
                        make.push(temp2);//initialized new arrays so they arent changed down the line when temp changes
                        allVisited = true;
                    }
                } else {
                    if ((temp[1] + 1) > newMaze.maze[0].length - 1 || newMaze.maze[temp[0]][temp[1] + 1].getVisited())//checks out of bounds and that it hasnt been visited before
                        newTemp = (int) (Math.random() * 4);
                    else {
                        newMaze.maze[temp[0]][temp[1]].setRight(false);//opens a hole to the right of tile
                        newMaze.maze[temp[0]][temp[1] + 1].setVisited(true);
                        temp[1]++;
                        temp2 = new int[2];
                        temp2[0] = temp[0];
                        temp2[1] = temp[1];
                        make.push(temp2);//initialized new arrays so they arent changed down the line when temp changes
                        allVisited = true;
                    }
                }
            }
        }
        for (int i = 0; i < newMaze.maze.length; i++)
            for (int j = 0; j < newMaze.maze[0].length; j++)
                newMaze.maze[i][j].setVisited(false);//Clears isvisited throughout the maze so none have been visited. You need to do this so solve doesnt break
        return newMaze;
    }

    /* TODO: Print a representation of the maze to the terminal */
    public void printMaze(boolean path) {//prints out the maze with given symbols for each part
        for (int i = 0; i < (maze.length * 2) + 1; i++) {
            String row = "";
            if (i == 1)
                row += " ";
            else
                row += "|";
            for (int j = 0; j < maze[0].length; j++) {
                if (i == 0 || i == maze.length * 2) {
                    row += "---|";
                } else {
                    if (i % 2 == 1) {
                        if (path && maze[i / 2][j].getVisited()) {
                            row += " * ";
                        } else {
                            row += "   ";
                        }
                        if (maze[i / 2][j].getRight())
                            row += "|";
                        else
                            row += " ";
                    } else {
                        if (maze[i / 2 - 1][j].getBottom())
                            row += "---|";
                        else
                            row += "   |";
                    }
                }
            }
            System.out.println(row);
        }
    }

    /* TODO: Solve the maze using the algorithm found in the writeup. */
    public void solveMaze() {
        Q1Gen solve = new Q1Gen();
        int[] current = new int[2];
        int[] temp = new int[2];
        current[0] = 0;
        current[1] = 0;
        temp[0] = current[0];
        temp[1] = current[1];
        solve.add(temp);
        while (solve.length() > 0) {//while queue is not empty
            current = (int[]) solve.remove();//current takes from front of the queue
            maze[current[0]][current[1]].setVisited(true);//mark current tile as visited
            if (current[0] == maze.length - 1 && current[1] == maze[0].length - 1) {
                break;
            } else {
                if (current[0] - 1 >= 0) {//makes sure not out of bounds
                    if (!maze[current[0] - 1][current[1]].getVisited() && !maze[current[0] - 1][current[1]].getBottom()) {
                        temp = new int[2];
                        temp[0] = current[0] - 1;
                        temp[1] = current[1];
                        solve.add(temp);//adds into temp array so coordinates dont get messed with when current is changed
                    }
                }
                if (current[0] + 1 <= maze.length - 1) {//makes sure not out of bounds
                    if (!maze[current[0] + 1][current[1]].getVisited() && !maze[current[0]][current[1]].getBottom()) {
                        temp = new int[2];
                        temp[0] = current[0] + 1;
                        temp[1] = current[1];
                        solve.add(temp);//adds into temp array so coordinates dont get messed with when current is changed
                    }
                }
                if (current[1] - 1 >= 0) {//makes sure not out of bounds
                    if (!maze[current[0]][current[1] - 1].getVisited() && !maze[current[0]][current[1] - 1].getRight()) {
                        temp = new int[2];
                        temp[0] = current[0];
                        temp[1] = current[1] - 1;
                        solve.add(temp);//adds into temp array so coordinates dont get messed with when current is changed
                    }
                }
                if (current[1] + 1 <= maze[0].length - 1) {//makes sure not out of bounds
                    if (!maze[current[0]][current[1] + 1].getVisited() && !maze[current[0]][current[1]].getRight()) {
                        temp = new int[2];
                        temp[0] = current[0];
                        temp[1] = current[1] + 1;
                        solve.add(temp);//adds into temp array so coordinates dont get messed with when current is changed
                    }
                }
            }
        }
        printMaze(true);
    }

    public static void main(String[] args) {
        MyMaze test = new MyMaze(5, 20);
        test = test.makeMaze(5, 20);
        test.printMaze(false);
        test.solveMaze();
    }
}