Input:
- q in 1..10: number of queries
- Each query:
    - n in 2..1000: number of nodes
    - m in 1..n(n-1)/2: number of edges
    - Each line i of m:
        - u, v: exist connection between u and v (always = 6)
    - s: starting node.

Output:
- For each query:
    - Shortest distance from s to each nodes or -1 if not exist

Example:
Input:
2
4 2
1 2
1 3
1
3 1
2 3
2

Output:
6 6 -1
-1 6

Observation:
- Shortest distance from s to node x = total short path