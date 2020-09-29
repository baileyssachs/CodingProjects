(* tables.ml - CSci 2041 HW 1 table slicer and dicer *)
(* Bailey Sachs *)

(* Free functions, don't question! *)
let read_lines () =
  let rec read_help acc =
    try read_help ((read_line ())::acc) with End_of_file -> List.rev acc
  in read_help []

let make_row delim str = List.map String.trim (Str.split (Str.regexp delim) str)

let rec write_row r delim = match r with
| [] -> ()
| h::[] -> print_endline h
| h::t -> let () = print_string h in
          let () = print_string delim in write_row t delim

let rec output_table od t = match t with
| [] -> ()
| r::rs -> let () = write_row r od in output_table od rs

(* Now your turn. *)
(* used split on char meathod built into string class. appened answer then called on rest of the array.*)
let rec table_of_stringlist delim rlist = match rlist with
| [] -> []
| h::t -> (String.split_on_char delim.[0] h)::(table_of_stringlist delim t)

(* is the helper meathod for make row assoc if the bool is false. pairs nums with given elements in order*)
let rec make_row_help (table:string list) acc = match table with
| [] -> []
| h::t -> (string_of_int acc, h)::make_row_help t (acc+1)
(* Helper meathod for make row assoc is the bool is true. pairs elements with elements from the first list *)
let rec make_row_help2 (table:string list) (stuff:string list) = match (table,stuff) with
| ([],[]) -> []
| ([], _) -> []
| (_,[]) -> []
|(h::t,a::b) -> (h,a)::make_row_help2 t b
(* runs through the whole list list for make row assoc. Did this beacuse make row assoc cant be recursive. This is the looper for the false helper *)
let rec make_row_looper (table:string list list) = match table with
| [] -> []
| h::t -> make_row_help h 1:: make_row_looper t
(* runs through the whole list list for make row assoc. Did this beacuse make row assoc cant be recursive. This is the looper for the true helper *)
let rec make_row_looper2 (table:string list) (stuff:string list list) = match stuff with
| [] -> []
| a::b -> make_row_help2 table a::make_row_looper2 table b
(* puts together all 4 helper meathods into one. calls false looper if hr is false and true looper if true*)
let make_row_assoc (hr:bool) (table:string list list) = match table with
| [] -> []
| h::t -> if hr = false then make_row_looper table else make_row_looper2 h t
(* goes in and gets the row at a given column. Checks col against all first elements and returns the second element in the touple if they are the same. *)
let row_get_column col ralist =
  let rec col_help col ralist = match ralist with
  | [] -> ""
  | (a,b)::x -> if a = col then b else col_help col x
in col_help col ralist
(* needed a comparison meathod for list.stable sort. Gives values for comparisons. This compares strings and gives the sort meathod a valid sorting meathod *)
let rec sort_help st l1 l2 = match (l1,l2) with
| ([],[]) -> 0
| ([], _) -> -1
| (_, []) -> 1
| ((a,b)::x, (c,d)::y) -> if a = st then String.compare b d else sort_help st x y
(* uses sort help as the comparison function in list.stable_sort. plugged in other values and stable sort does the rest. *)
let sort_assoc sortcol ralist = List.stable_sort (sort_help sortcol) ralist
(* just returns rows appended to each other until k equals 0. decrements k by one each time.*)
let cut_to_rows k ralist =
  let rec cut_help k ralist = match ralist with
  | [] -> []
  | a::b -> if k > 0 then a::cut_help (k-1) b else cut_help 0 []
in cut_help k ralist
(* appends columns onto each other from the list. Helps break the list list in reassemble down. *)
let rec re_help2 (clist : string list)  (ralist : (string*string) list) = match clist with
| [] -> []
| a::b -> row_get_column a ralist::re_help2 b ralist


(* Uses re_help2 to break down the list list into easier to deal with pieces. recursively loops through feeding re_help2 single lists and appends them to each other until done.*)
let reassemble (clist : string list)  (ralist : (string*string) list list) =
  let rec re_help (clist2 : string list)  (ralist2 : (string*string) list list) = match ralist2 with
  | [] -> []
  | a::b ->  re_help2 clist2 a::re_help clist2 b
in re_help clist ralist

(* OK, more free stuff *)
let rec main id od sortcol srev hr outcols outrows =
  let sl = read_lines () in
  let rtable = table_of_stringlist id sl in
  let ratab = make_row_assoc hr rtable in
  let stab = if sortcol = "" then ratab else sort_assoc sortcol ratab in
  let stab = if (sortcol <> "") && srev then List.rev stab else stab in
  let ktab = if outrows = max_int then stab else cut_to_rows outrows stab in
  let oclist = match (outcols,hr) with
  | ("*",false) -> nclist rtable
  | ("*",true) -> List.hd rtable
  | _ -> make_row "," outcols in
  let ntable = reassemble oclist ktab
  in
  output_table od (if hr then oclist::ntable else ntable)
(* magic you don't need to understand yet *)
and nclist rt =
  List.init (List.fold_left max 0 (List.rev_map List.length rt)) (fun n -> string_of_int (n+1))
