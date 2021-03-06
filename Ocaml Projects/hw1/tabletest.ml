let test1 = (Tables.table_of_stringlist "," ["a,,c"]) = [["a";"";"c"]]
let test2 = (Tables.table_of_stringlist "b" ["abcb"]) = [["a"; "c"]]
let test3 = (Tables.table_of_stringlist "&" ["ab&cd"; "g"; "h&i"]) = [["ab";"cd"]; ["g"]; ["h";"i"]]
let test4 = (Tables.table_of_stringlist "\n" ["ab\ncd"]) = [["ab";"cd"]]
let test5 = (Tables.make_row_assoc false [[]]) = [[]]
let test6 = (Tables.make_row_assoc false []) = []
let test7 = (Tables.make_row_assoc false [["ab"];["cd"];["ef"]]) = [[("1","ab")]; [("1","cd")]; [("1","ef")]]
let test8 = (Tables.make_row_assoc true [["c1";"c2";"c3"]; ["a"; "b"]; ["x";"y";"z";"!"]]) = [[("c1", "a"); ("c2", "b")]; [("c1", "x"); ("c2", "y"); ("c3", "z")]]
let test9 = (Tables.row_get_column "" [("","yes")]) = "yes"
let test10 = (Tables.row_get_column "one" [("one","yes");("one","no")]) = "yes"
let test11 = (Tables.row_get_column "one" [("one","yes");("one","no")]) = "yes"
let test12 = (Tables.row_get_column "nothing" [("one","yes");("one","no");("nope","?")]) = ""
let test13 = (Tables.sort_assoc "a" [[("a","b")]]) = [[("a", "b")]]
let test14 = (Tables.sort_assoc "stuff" [[("stuff","cd")]; [("stuff", "ab")]]) = [[("stuff", "ab")]; [("stuff", "cd")]]
let test15 = (Tables.sort_assoc "stuff" [[("stuff","ab")]; [("stuff", "cd")]; [("stuff", "ef")]]) = [[("stuff", "ab")]; [("stuff", "cd")]; [("stuff", "ef")]]
let test16 = (Tables.sort_assoc "" [[("test","yo")]; [(" ","asdad")]]) = [[("test", "yo")]; [(" ", "asdad")]]
let test17 = (Tables.cut_to_rows 0 [[("a","b")]]) = []
let test18 = (Tables.cut_to_rows 2 [[("a","b")]]) = [[("a", "b")]]
let test19 = (Tables.cut_to_rows 2 [[("a","b")];[("c","d")];[("e","f")]]) = [[("a", "b")]; [("c", "d")]]
let test20 = (Tables.cut_to_rows 0 [[]]) = []
let test21 = (Tables.cut_to_rows 1 [[]]) = [[]]
let test22 = (Tables.reassemble ["a";"c"] [[("a","b"); ("b","a")]]) = [["b"; ""]]
let test23 = (Tables.reassemble ["a";"b";"c"] [[("a","b"); ("b","a")];[("c","c")]]) = [["b"; "a"; ""]; [""; ""; "c"]]
let test24 = (Tables.reassemble [] [[("a","b"); ("b","a")]]) = [[]]
let test25 = (Tables.reassemble ["a"] [[]]) = [[""]]
