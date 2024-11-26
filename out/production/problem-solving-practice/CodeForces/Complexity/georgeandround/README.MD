Input:
- Int n,m in 1..3000
- n: minimum number of problems in good round
- m: number of prepared problems
- a1 < a2 < .. < an in 1..10^6: complexity for good round
- b1 < b2 < .. < bn in 1..10^6: complexity of prepared problems.

Rule:
- can simplify prepared problem bc -> bd if c >= d
- Good round if:
    - Have >= n problem:
        - At lease 1 problem with complexity a1, a2.. an


Output:
- Minimum number of additional problems to m, to get good round

Observation/Clarify:
To make a Good round:
- Need n problem
    - For each ai:
        - while having prepared problem (k) in pocket:
            - If b(k) >= ai:
                - matched requirement -> go to next case a(i + 1)
                - Check from k + 1 for next case a(i + 1)
            - If b(k) < ai:
                - Try next prepared problem (k+1) in pocket
        - if still not matched -> need additional problem

