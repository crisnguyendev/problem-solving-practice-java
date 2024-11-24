Input
- T in 1..100: number of test cases
- For each test case:
    - N in 1..10^4: number of document
    - M in 1..3.10^4: dependencies
    - For each M lines:
        - A >= 1, B <= N: A depend on document B
        - Might be repeated dependencies

- If A depends on B and B depends on B -> loop

Output:
- For each case:
    - YES: at least one loop
    - NO: otherwise

Example:
Input:

3
2 1
1 2
2 2
1 2
2 1
4 4
2 3
3 4
4 2
1 3

Output:
NO
YES
YES

Observation:
- Consider each document as vertex of graph
- If A depends on B -> Edge from A to B
- If there is loop:
    - Exist path from A to B that is different with path from B to A -> Visit A at least twice
    -