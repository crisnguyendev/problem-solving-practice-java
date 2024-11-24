Input:
- k: strength factor:
    - cannot jump more than k feet
    - If jump exactly k feet -> k - 1
    - If jump less than k -> k remain

- T <= 500: number of test cases
- For each test case:
    - n: number of rungs
    - n integers: r(i) height of rungs

Output:
- Minimum value of k to reach the top rung

Example
Input
4
3 9 10 14

Output:
6

Observation:
- If reach to top rung
    - last jump = r(n) - r(n-1) >= latest k
    - max jump <=k:
        - If max jump occur x times: k = max jump + x