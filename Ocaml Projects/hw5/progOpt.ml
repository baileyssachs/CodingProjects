(* progOpt.ml -- optimizations for our little programming language *)

open Program
exception OptError of string

let is_const_exp = function
 IntC _ | ListC _| BoolC _ -> true
 | _ -> false

(* added cases for each of the possible expressions and methods *)
let rec fold_consts e = match e with
  | (IntC _) | (BoolC _) | ListC _ | Name _ -> e
  | Print e -> Print (fold_consts e)
  | Apply (e1, e2) -> Apply (fold_consts e1, fold_consts e2)
  | Add (e1, e2) -> (match (fold_consts e1, fold_consts e2) with (* match with folded versions of expressions *)
                    | (IntC a, IntC b) -> IntC (a + b) (*if both correct type do operation*)
                    | (a, b) -> Add (a, b)) (*if not both correct type just return the Operation with the folded consts*)
  | Sub (e1, e2) -> (match (fold_consts e1, fold_consts e2) with
                    | (IntC a, IntC b) -> IntC (a - b)
                    | (a, b) -> Sub (a, b))
  | Mul (e1, e2) -> (match (fold_consts e1, fold_consts e2) with
                    | (IntC a, IntC b) -> IntC (a * b)
                    | (a, b) -> Mul (a, b))
  | Div (e1, e2) -> (match (fold_consts e1, fold_consts e2) with
                    | (IntC a, IntC b) -> IntC (a / b)
                    | (a, b) -> Div (a, b))
  | And (e1, e2) -> (match (fold_consts e1, fold_consts e2) with
                    | (BoolC a, BoolC b) -> BoolC (a && b)
                    | (a, b) -> And (a, b))
  | Or (e1, e2) -> (match (fold_consts e1, fold_consts e2) with
                    | (BoolC a, BoolC b) -> BoolC (a || b)
                    | (a, b) -> Or (a, b))
  | Not e1 -> (match (fold_consts e1) with
                    | BoolC a -> BoolC(not a)
                    | a -> Not a)
  | If (e1, e2, e3) -> (match (fold_consts e1, fold_consts e2, fold_consts e3) with
                    | (BoolC a, b, c) -> if a then b else c
                    | (a, b, c) -> If(a, b, c))
  | Lt (e1, e2) -> (match (fold_consts e1, fold_consts e2) with
                    | (IntC a, IntC b) -> BoolC (a < b)
                    | (a, b) -> Lt (a, b))
  | Gt (e1, e2) -> (match (fold_consts e1, fold_consts e2) with
                    | (IntC a, IntC b) -> BoolC (a > b)
                    | (a, b) -> Gt (a, b))
  | Eq (e1, e2) -> (match (fold_consts e1, fold_consts e2) with
                    | (IntC a, IntC b) -> BoolC (a = b)
                    | (a, b) -> Eq (a, b))
  | While (e1, e2) -> (match (fold_consts e1, fold_consts e2) with
                    | (BoolC a, b) -> if a then b else Seq []
                    | (a, b) -> While(a, b))
  | Cons (e1, e2) -> (match (fold_consts e1, fold_consts e2) with
                    | (IntC a, ListC b) -> ListC (a::b)
                    | (a, b) -> Cons (a, b))
  | Head e1 -> (match (fold_consts e1) with
                    | ListC (h::t) -> IntC h
                    | ListC [] -> raise (OptError "Head") (*if empty list throw exception*)
                    | a -> Head a)
  | Tail e1 -> (match (fold_consts e1) with
                    | ListC (h::t) -> ListC t
                    | ListC [] -> raise (OptError "Tail")(*if emprt list throw expcetion*)
                    | a -> Tail a)
  | Let (e1, e2, e3) -> let a = fold_consts e2 in
                      let b = fold_consts e3 in if(is_const_exp a) && (is_const_exp b) then b else Let(e1, a, b)
  | Set (e1, e2) -> Set (e1, fold_consts e2)
  | Fun (e1, e2, e3) -> Fun (e1, e2, fold_consts e3)
  | Readint -> Readint
  | Seq e1 -> let rec seq_help e2 acc = match e2 with
      | [] -> acc (*if empty return acc*)
      | h::[] -> acc @ [fold_consts h] (*if last element append onto acc and return*)
      | h::t -> match (fold_consts h) with (*if list is more than one element go into this*)
            | Name a -> seq_help t acc  (*if name ignore*)
            | a -> if (is_const_exp a) = true then (seq_help t acc) else seq_help t (acc @ [a]) (* if not then add it to acc otherwise skip *)
  in let a = seq_help e1 [] in if(List.for_all is_const_exp a) then if ((List.length a) > 0) then List.hd(List.rev a) else Seq [] else Seq a
(* checks the list for certain conditions and returns the correct input for each situation. *)
