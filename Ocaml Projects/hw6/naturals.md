# Naturals

### ``pow_nat``

### Property
p(n): for all `n : nat`, for all `𝓍 : float`
`pow 𝓍 (to_int n) ≡ pow_nat 𝓍 n`

### Base Case
p(Zero):for all `𝓍 : float`
`pow 𝓍 (to_int Zero) ≡ pow_nat 𝓍 Zero`
`pow 𝓍 (to_int Zero)` ≡ `pow x 0`           [Eval to_int]
≡ `1.0`                                     [Eval pow]
≡ `pow_Nat x Zero`                          [Reverse eval pow_nat]

### Inductive Case
for all `n : nat`, for all `𝓍 : float`
`pow 𝓍 (to_int n) ≡ pow_nat 𝓍 n` -> `pow 𝓍 (to_int (Succ n)) ≡ pow_nat 𝓍 (Succ n)`

### IH:
assume `pow 𝓍 (to_int n) ≡ pow_nat 𝓍 n` 

`pow 𝓍 (to_int (Succ n))` ≡ `pow x (1 + (to_int n))`              [eval to_int]
≡ `x * (pow x (to_int n))`                                        [eval pow]
≡ `x * pow_nat 𝓍 n`                                               [IH]
≡ `pow_nat x (Succ n) `                                           [reverse eval pow_nat]





### ``geq_nat``

### Property
p(n):  for all `m : nat`, for all `n : nat`
`geq_nat m n` ≡ `(to_int m) >= (to_int n)`

### Base Case
p(Zero): for all `m : nat`
`geq_nat m Zero` ≡ `(to_int m) >= (to_int Zero)`
`(to_int m) >= (to_int Zero)` ≡ `0 >= 0`                 [Eval to_int]
≡ `true`                                                 [Eval boolean]
≡ `geq_nat m Zero `                                        [reverse eval geq_nat]

### Inductive Case
 for all `m : nat`, for all `n : nat`
`geq_nat m n` ≡ `(to_int m) >= (to_int n)` -> `geq_nat m (Succ n)` ≡ `(to_int m) >= (to_int (Succ n))`

### IH:
assume `geq_nat m n` ≡ `(to_int m) >= (to_int n)`

Case 1: `m = n`
`(to_int m) >= (to_int (Succ n))` ≡ `(to_int n) >= (to_int (Succ n))`             [since m = n replace m with n]
≡ `(to_int n) >= (1 + (to_int n))`                                                [eval to_int]
≡ `false`                                                                         [n is not >= (n+1)]
≡ `geq_nat n (Succ n)`                                                            [reverse eval geq_nat since m = n it is false]
≡ `geq_nat m (Succ n)`                                                            [Replace n with m because m = n]

Case 2: `m != n`
`geq_nat m (Succ n)` ≡ `geq_nat m n`              [eval geq_nat knowing m != n]
≡ `(to_int m) >= (to_int n)`                      [IH]
≡ `(to_int m) >= 1 + (to_int n)`                  [since m != n, then m > n and m >= n+1]
≡ `(to_int m) >= (to_int (Succ n))`               [reverse eval to_int]