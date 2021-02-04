let file_lines fname =
  let in_file = open_in fname in
  let rec loop acc =
    let next_line = try Some (input_line in_file) with End_of_file -> None in
    match next_line with
    | (Some l) -> loop (l::acc)
    | None -> acc
  in
  let lines = try List.rev (loop []) with _ -> [] in
  let () = close_in in_file in
  lines

let file_as_string fname = String.concat "\n" (file_lines fname)

module type Summary = sig
  type e
  type t
  val empty : t
  val union_size : t -> t -> int
  val inter_size : t -> t -> int
  val size : t -> int
  val of_list : e list -> t
end

module type Element = sig
  type e
  val of_string : string -> e list
end

(* These two are not for real use, just for testing *)
module Nilement = struct
  type e = int
  let of_string s = [String.length s]
end

module Nummary = struct
  type e = int
  type t = int
  let empty = 0
  let of_list = function [] -> 0 | h::t -> h
  let size s = s
  let inter_size s1 s2 = min s1 s2
  let union_size s1 s2 = max s1 s2
end
(* Everything above was given *)
(* now back to real uses *)
let cleanup_chars s = String.map (fun a -> match a with 'a'..'z' -> a | _ -> ' ') (String.lowercase_ascii s)
(* extract a list of n-grams from a string, naively *)
let ngrams n s = List.init ((String.length s)-(n-1)) (fun i -> String.sub s i n)
(* Took of_string from hw3 *)
module Ngram(N : sig val n : int end) = struct
  type e = string
  let of_string str = List.filter (fun a -> if String.contains a ' ' then false else true) (* remove and ngrams with spaces in them*)
  (List.map cleanup_chars (ngrams N.n str))
end
(*this was given*)
module Stem = struct
  type e = string
  let of_string str = List.map Stemmer.stem (Str.split (Str.regexp {|\b|}) str)
end



(* multiplicity of e in multiset b - 0 if not in the multiset *)
let multiplicity e b = List.fold_left (fun acc (x,y) -> if (e = x) then acc+y else acc) 0 b
(* size of a multiset is the sum of the multiplicities of its elements *)
let size b = List.fold_left (fun acc (x,y) -> acc+y) 0 b

(* Define the similarity function between two multisets: size of intersection / size of union *)
let intersection_size s1 s2 = List.fold_left (fun acc (x,y) -> if((multiplicity x s2) = 0) then acc
else if((multiplicity x s2) < y) then acc+(multiplicity x s2) else (acc + y)) 0 s1(* if in both lists find the smaller value *)


(* Your multiset implementation from HW3 *)
module ListMSet = struct
  type e = string
  type t = (string * int) list
  let empty = []
  let of_list lst = let sortedList = List.sort compare lst in (* Sorts the list so all of the same elements are next to each other *)
  match sortedList with
  | [] -> []
  | h::t -> let acc,a,b = List.fold_left (fun (acc,a,b) c -> if c = a then acc,a,b+1
  else (a,b)::acc,c,1) ([],h,1) t in (* if elements are the same then add one to b then once it is a new element add previous element and count to accumulator *)
  (a,b)::acc
  let union_size m1 m2 = (size m1) + (size m2) - (intersection_size m1 m2)
  let inter_size m1 m2 = List.fold_left (fun acc (x,y) -> if((multiplicity x m2) = 0) then acc
  else if((multiplicity x m2) < y) then acc+(multiplicity x m2) else (acc + y)) 0 m1 (* your implementation of intersection_size *)
  let size m1 = List.fold_left (fun acc (x,y) -> acc+y) 0 m1
end

module SetSummary = struct
  module StringSet = Set.Make(String)
  type e = string
  type t = StringSet.t
  let empty = StringSet.empty (*creates an empty set*)
  let of_list lst = List.fold_left (fun x y -> StringSet.add y x) StringSet.empty lst (*adding each elemnt to the string set*)
  let size s = StringSet.cardinal s (* cardinal takes the size of the set*)
  let union_size s1 s2 = size (StringSet.union s1 s2) (* caclulates the union set then takes size of it*)
  let inter_size s1 s2 = size (StringSet.inter s1 s2) (* calculates the intersection set then takes the size of it*)
end

(* SAME STORY HERE CHANGE IT ALL *)
module MapMSet = struct
  module MapSet = Map.Make(String)
  type e = string
  type t = int MapSet.t
  let empty = MapSet.empty (*creates an empty map*)
  let of_list lst = List.fold_left (fun acc k -> if (MapSet.mem k acc)
  then (MapSet.update k (fun (Some x) -> Some(x+1)) acc)
  else (MapSet.add k 1 acc)) MapSet.empty lst (* this goes through and if the key already exists it adds one to its value otherwise adds the key with a value of 1 to the map*)
  let size s = MapSet.fold (fun x y acc -> acc+y) s 0 (*adds up all the values of each key*)
  let union_size s1 s2 = size (MapSet.union (fun a x y -> if x > y then Some x else Some y) s1 s2) (*calculates the union map then takes the size*)
  let inter_size s1 s2 = size (MapSet.merge (fun a x y -> match (x,y) with (*matches so we can accomidate options*)
  | (Some x, Some y) -> if x < y then Some x else Some y
  | _ -> None) s1 s2) (* This calculates the map intersection then takes the size of it*)
end


(*all of this is nearly identical to hw3, used the same logic but changed the names as necissary to match the structs given*)
module FindSim (E : Element)(MS : Summary with type e = E.e) = struct
  let similarity s1 s2 = float_of_int(MS.inter_size s1 s2) /. float_of_int(MS.union_size s1 s2)
  let main replist_name target_name =
    let repfile_list = file_lines replist_name in
    let rep_contents = List.map file_as_string repfile_list in
    let target_contents = file_as_string target_name in
    let rep_elems = List.map E.of_string rep_contents in (* _almost_ the same as your rep_ngrams *)
    let target_elems = E.of_string target_contents in (* _almost the same as your target_ngrams *)
    let rep_summaries = List.map MS.of_list rep_elems in (* change this to the right thing *)
    let target_summary = MS.of_list target_elems in (* this too *)
    let repsims = List.map2 (fun x y -> (similarity x target_summary, y)) rep_summaries repfile_list in
    List.stable_sort (Fun.flip compare) repsims
end
