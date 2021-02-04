(* don't remove these, they make tests much easier to express *)
open Program
open Parser
open ProgOpt

let test1 = (typeof (Tail (ListC [3;4])) [] = ListT)
let test2 = (typeof (Head (ListC [3;4])) [] = IntT)
let test3 = (typeof (Cons (Head(ListC [5;6]), (Tail (ListC [3;4])))) [] = ListT)
let test4 = (typeof (Eq(ListC [1;2], ListC [1;2])) [] = BoolT)
let test5 = (eval(Head(ListC [1;2;3])) [] = (IntR 1, []))
let test6 = (eval(Tail(ListC [1;2;3])) [] = (ListR [2;3], []))
let test7 = (eval (Cons (Head(ListC [5;6]), (Tail (ListC [3;4])))) [] = (ListR [5;4], []))
let test8 = (eval (Cons (IntC 3, (Tail (ListC [3;4])))) [] = (ListR [3;4], []))
let test9 = (parse_program (tokens (wordlist example1))= Let ("f", Fun ("g", FunT (IntT, IntT), Apply (Name "g", IntC 0)),
 Print (Apply (Name "f", Fun ("x", IntT, Add (Name "x", IntC 2))))))
let test10 = (parse_program (tokens (wordlist example2)) = Let ("gcd",
 Fun ("a", IntT,
  Fun ("b", IntT,
   Let ("q", Div (Name "a", Name "b"),
    Let ("r", Sub (Name "a", Mul (Name "q", Name "b")),
     Seq
      [While (Not (Eq (Name "r", IntC 0)),
        Seq
         [Set ("a", Name "b"); Set ("b", Name "r");
          Set ("q", Div (Name "a", Name "b"));
          Set ("r", Sub (Name "a", Mul (Name "q", Name "b")))]);
       Name "b"])))),
 Print (Apply (Apply (Name "gcd", IntC 217), IntC 527))))
let test11 = (parse_program (tokens (wordlist example3)) = Let ("y", IntC 0,
 Let ("x", Add (IntC 1, IntC 2),
  While (Gt (Name "x", IntC 0),
   Seq
    [Set ("x", Sub (Name "x", IntC 1));
     If (Gt (IntC 1, IntC 0), Name "x", Name "y");
     If (Lt (IntC 1, IntC 0), Name "x", Name "y");
     While (Gt (IntC 1, IntC 0), Print (Name "y")); Add (IntC 1, IntC 2);
     Seq [Let ("z", Add (IntC 2, IntC 3), Lt (IntC 1, IntC 2))]]))))
let test12 = (parse_program (tokens (wordlist example4)) = Let ("y", Mul (IntC 0, IntC 0),
 Let ("z",
  If (Gt (Name "y", IntC 4), Seq [Set ("y", Sub (Name "y", IntC 1)); IntC 1],
   IntC 0),
  Seq
   [Print (Name "y");
    If (Eq (Add (IntC 1, IntC 0), Sub (IntC 2, IntC 1)),
     Let ("z", Readint, Name "z"), Add (IntC 42, IntC 17))])))
let test13 = (parse_program (tokens (wordlist example6)) = Let ("readlist",
 Fun ("x", UnitT,
  Let ("out", ListC [],
   Let ("cont", BoolC true,
    Let ("x", IntC 0,
     Seq
      [While (Name "cont",
        Seq
         [Set ("x", Readint);
          If (Lt (Name "x", IntC 0), Set ("cont", BoolC false),
           Set ("out", Cons (Name "x", Name "out")))]);
       Name "out"])))),
 Let ("printlist",
  Fun ("l", ListT,
   While (Not (Eq (Name "l", ListC [])),
    Seq [Print (Head (Name "l")); Set ("l", Tail (Name "l"))])),
  Let ("rev",
   Fun ("in", ListT,
    Let ("out", ListC [],
     Seq
      [While (Not (Eq (Name "in", ListC [])),
        Seq
         [Set ("out", Cons (Head (Name "in"), Name "out"));
          Set ("in", Tail (Name "in"))]);
       Name "out"])),
   Apply (Name "printlist",
    Apply (Name "rev", Apply (Name "readlist", Seq [])))))))

let test14 = (fold_consts (example2 |> wordlist |> tokens |> parse_program) = Let ("gcd",
 Fun ("a", IntT,
  Fun ("b", IntT,
   Let ("q", Div (Name "a", Name "b"),
    Let ("r", Sub (Name "a", Mul (Name "q", Name "b")),
     Seq
      [While (Not (Eq (Name "r", IntC 0)),
        Seq
         [Set ("a", Name "b"); Set ("b", Name "r");
          Set ("q", Div (Name "a", Name "b"));
          Set ("r", Sub (Name "a", Mul (Name "q", Name "b")))]);
       Name "b"])))),
 Print (Apply (Apply (Name "gcd", IntC 217), IntC 527))))
let test15 = (fold_consts (example5 |> wordlist |> tokens |> parse_program) = Let ("rev",
 Fun ("in", ListT,
  Let ("out", ListC [],
   Seq
    [While (Not (Eq (Name "in", ListC [])),
      Seq
       [Set ("out", Cons (Head (Name "in"), Name "out"));
        Set ("in", Tail (Name "in"))]);
     Name "out"])),
 Apply (Name "rev", ListC [1; 2; 3; 4; 5])))
let test15 = (fold_consts (example1 |> wordlist |> tokens |> parse_program) = Let ("f", Fun ("g", FunT (IntT, IntT), Apply (Name "g", IntC 0)),
 Print (Apply (Name "f", Fun ("x", IntT, Add (Name "x", IntC 2))))))
let test16 = (fold_consts (example6 |> wordlist |> tokens |> parse_program) = Let ("readlist",
 Fun ("x", UnitT,
  Let ("out", ListC [],
   Let ("cont", BoolC true,
    Let ("x", IntC 0,
     Seq
      [While (Name "cont",
        Seq
         [Set ("x", Readint);
          If (Lt (Name "x", IntC 0), Set ("cont", BoolC false),
           Set ("out", Cons (Name "x", Name "out")))]);
       Name "out"])))),
 Let ("printlist",
  Fun ("l", ListT,
   While (Not (Eq (Name "l", ListC [])),
    Seq [Print (Head (Name "l")); Set ("l", Tail (Name "l"))])),
  Let ("rev",
   Fun ("in", ListT,
    Let ("out", ListC [],
     Seq
      [While (Not (Eq (Name "in", ListC [])),
        Seq
         [Set ("out", Cons (Head (Name "in"), Name "out"));
          Set ("in", Tail (Name "in"))]);
       Name "out"])),
   Apply (Name "printlist",
    Apply (Name "rev", Apply (Name "readlist", Seq [])))))))
let test17 = ((eval (parse_program (tokens (wordlist example1)))) [] = (UnitR, []))
let test18 = ((eval (parse_program (tokens (wordlist example2)))) [] = (UnitR, []))
let test19 = (eval (Cons (Head(ListC [5]), (Tail (ListC [3])))) [] = (ListR [5], []))
let test20 = (typeof (Tail (ListC [])) [] = ListT)
let test21 = (typeof (Cons (Head(ListC []), (Tail (ListC [])))) [] = ListT)
