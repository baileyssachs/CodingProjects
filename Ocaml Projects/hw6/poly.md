### I. ``deg (polycomp p1 p2)`` ≡ ``(deg p1)*(deg p2)``

### Property
P(p1): for all `p2: polyExpr`,
 `deg (polycomp p1 p2)` ≡ `(deg p1)*(deg p2)`

### Base Case:
P(X):for all `p2: polyExpr`
`deg (polycomp X p2)` ≡ `(deg X)*(deg p2)`

`deg (polycomp X p2)` ≡ `deg p2`                        [eval polycomp]
≡ `1 * (deg p2)`                                        [algebra]
≡ `(deg X) * (deg p2)`                                  [reverse eval deg]

P(Int i): `deg (polycomp (Int i) p2)` ≡ `(deg (Int i))*(deg p2)`

`deg (polycomp (Int i) p2)` ≡ `deg (Int i)`                     [eval polycomp]
≡ `0`                                                           [eval Deg]
≡ `(deg (Int i))`                                               [algebra]
≡ `(deg (Int i)) * (deg p2)`                                    [reverse eval deg and algebra because anything times 0 is still 0]
          

### Inductive Case
for all `a : polyExpr`, `b : polyExpr`, `p2: polyExpr`
`deg (polycomp a p2)` ≡  `(deg a)*(deg p2)`  && `deg (polycomp b p2)` ≡ `(deg b)*(deg p2)` ->  `deg (polycomp (Add(a, b)) p2)` ≡ `(deg Add(a, b))*(deg p2)`
&& `deg (polycomp (Mul(a,b)) p2)` ≡ `(deg Mul(a,b))*(deg p2)`

### IH:
assume: `deg (polycomp a p2)` ≡  `(deg a)*(deg p2)`, `deg (polycomp b p2)` ≡ `(deg b)*(deg p2)`

p(Add): `deg (polycomp (Add(a, b)) p2)` ≡ `deg (Add(polycomp a p2, polycomp b p2))`             [eval polycomp]
≡  `max (deg (polycomp a p2)) (deg(polycommp b p2))`                                            [eval deg]
≡ `max ((deg a)*(deg p2)) ((deg b)*(deg p2))`                                                   [IH]
≡ `(max (deg a) (deg b)) * (deg p2)`                                                            [algebra]
≡ `(deg Add(a, b)) * (deg p2)`                                                                  [reverse eval deg]

P(Mul): `deg (polycomp (Mul(a,b)) p2)` ≡ `deg(Mul(polycomp a p2, polycomp b p2))`                 [eval polycomp]
≡  `deg(polycomp a p2) + deg(polycomp b p2)`                                                      [eval deg]
≡  `((deg a)*(deg p2)) + ((deg b)*(deg p2))`                                                      [IH]
≡ `((deg a) + (deg b)) * (deg p2)`                                                                [algebra]
≡ `(deg Mul(a,b)) * (deg p2)`                                                                     [reverse eval deg]