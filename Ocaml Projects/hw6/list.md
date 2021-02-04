### I. ``map id l ≡ l``

### Property
P(l): for all `l : int list`
`map id l ≡ l`
### Base Case:
P([]): `map id [] ≡ []`
`map id []` ≡ `[]`                      [eval map]

### Inductive Case
for all `l : int list`
`map id l ≡ l` -> `map id (x::l) ≡ (x::l)`

### IH: 
assume `map id l ≡ l` 

`map id (x::l)` ≡ `(id x)::(map id l)`          [eval map]
≡ `(id x)::l`                                   [IH]
≡ `(x::l)`                                      [reverse eval map]



### II. ``length l ≡ length (reverse l)``

### Property
Original Property:
p(l): for all `l : int list`
`length l ≡ length (reverse l)`

Since this is true: `length (reverse l) ≡ length (tail_rev l [])` then prove lemma

lemma:
P(l): for all `l : int list`, `l2 : int list`
`(length l) + (length l2)` ≡ `length (tail_rev l l2)`

### Base Case:

P([]):for all `l2 : int list`
`(length []) + (length l2)` ≡ `length (tail_rev [] l2)`

`length (tail_rev [] l2)` ≡ `length l2`                      [eval tail_rev]
≡ `0 + (length l2)`                                          [algebra]
≡ `(length []) + (length l2)    `                            [reverse eval length]

### Inductive Case
for all `l : int list`, `l2 : int list`
`(length l) + (length l2)` ≡ `length (tail_rev l l2)` -> `(length (x::l)) + (length l2)` ≡ `length (tail_rev (x::l) l2)`

#### IH:
assume `(length l) + (length l2)` ≡ `length (tail_rev l l2)`

`length (tail_rev (x::l) l2)` ≡ `length (tail_rev l (x::l2))`                     [eval tail_rev]
≡`(length l) + (length (x::l2))`                                                  [IH]
≡`(length l) + (length l2) + 1`                                                   [eval length]
≡`1 + (length l) + (length l2)`                                                   [algebra]
≡`(length (x::l)) + (length l2)`                                                  [reverse eval length]

Since:  `length (reverse l) ≡ length (tail_rev l []) ≡ (length l)` then lemma proves original claim that
`length(reverse l) ≡ (length l)`