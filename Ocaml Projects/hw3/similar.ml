open FTools

let ngram_n = 3
(* Your code goes here: *)

(* Define the function that lower-cases and filters out non ->-alphabetic characters *)
let cleanup_chars s = String.map (fun a -> match a with 'a'..'z' -> a | _ -> ' ') (String.lowercase_ascii s)

(* extract a list of n-grams from a string, naively *)
let ngrams n s = List.init ((String.length s)-(n-1)) (fun i -> String.sub s i n) (* creates strings size of n of all possible concurrent combinations that are n long *)

(* Define the function that converts a string into a list of "normalized" n-grams *)
let n_grams s = List.filter (fun a -> if String.contains a ' ' then false else true) (* remove and ngrams with spaces in them*)
(List.map cleanup_chars (ngrams ngram_n s))

(* Define a function to convert a list into a multiset *)
let multiset_of_list lst =
let sortedList = List.sort compare lst in (* Sorts the list so all of the same elements are next to each other *)
match sortedList with
| [] -> []
| h::t -> let acc,a,b = List.fold_left (fun (acc,a,b) c -> if c = a then acc,a,b+1
else (a,b)::acc,c,1) ([],h,1) t in (* if elements are the same then add one to b then once it is a new element add previous element and count to accumulator *)
(a,b)::acc
(* multiset utility functions *)
let multi_helper gram lst = List.fold_left (fun (a,acc) x -> if(gram = x) then a+1,acc else a,x::acc) (1,[]) lst (*didnt need to use this, seemed inefficient*)

(* multiplicity of e in multiset b - 0 if not in the multiset *)
let multiplicity e b = List.fold_left (fun acc (x,y) -> if (e = x) then acc+y else acc) 0 b
(* size of a multiset is the sum of the multiplicities of its elements *)
let size b = List.fold_left (fun acc (x,y) -> acc+y) 0 b

(* Define the similarity function between two multisets: size of intersection / size of union *)
let intersection_size s1 s2 = List.fold_left (fun acc (x,y) -> if((multiplicity x s2) = 0) then acc
else if((multiplicity x s2) < y) then acc+(multiplicity x s2) else (acc + y)) 0 s1(* if in both lists find the smaller value *)
let union_size s1 s2 = (size s1) + (size s2) - (intersection_size s1 s2) (* size of each minus the intersection*)
let similarity s1 s2 = float_of_int(intersection_size s1 s2) /. float_of_int(union_size s1 s2) (* intersection / union*)

(* Find the most similar representative file *)
let find_max repsims repnames = List.fold_left max (0.,"-") (List.combine repsims repnames) (* combines lists to make touple list *)

let main all replist_name target_name =
  (* Read the list of representative text files *)
  let repfile_list = FTools.file_lines replist_name in    (*string list of file names*)
  (* Get the contents of the repfiles and the target file as strings *)
  let rep_contents = List.map FTools.file_as_string repfile_list in (*converting contents of eacch file to string*)
  let target_contents = FTools.file_as_string target_name in (* comparting all of them to target contents *)
  (* Compute the list of normalized n-grams from each representative *)
  let rep_ngrams = List.map n_grams rep_contents in
  (* Convert the target text file into a list of normalized n-grams *)
  let target_ngrams = n_grams target_contents in
  (* Convert all of the stem lists into stem sets *)
  let rep_multisets = List.map multiset_of_list rep_ngrams in
  let target_multiset = multiset_of_list target_ngrams in
  (* Compute the similarities of each rep set with the target set *)
  let repsims = List.map (similarity target_multiset) rep_multisets in
  let (sim,best_rep) = find_max repsims repfile_list in
  let () = if all then
  let () = List.iter2 (fun x y -> Printf.printf "%s/%.12f\n" x y) repfile_list repsims in
  let () = print_endline "" in
  () else begin
  let () = Printf.printf "The most similar file to %s was %s\n" target_name best_rep in
  let () = Printf.printf "Similarity: %.12f" sim in
  let () = print_endline "" in
  print_endline ""  end in
  (* this last line just makes sure the output prints before the program exits *)
  flush stdout
