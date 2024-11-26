Input
- t: number of test case
- n in 2..50000: number of places in town
- For each street:
    - Two place in 1..n
    - Length of street 0..20000

Output:
- Maximum length of longest street in the city

Example:
Input
1
6
1 2 3
2 3 4
2 6 2
6 4 6
6 5 5

Output:
12

Observation:
- Given n places (vertices) -> n - 1 street (edges)
- Bidirectional graph
- For each vertex: find most far vertex in graph

