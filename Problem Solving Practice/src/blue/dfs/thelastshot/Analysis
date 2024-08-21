Input:
- N in 1..10000: number of bombs
- M in 1..10000: number of relation between bombs
- For M lines:
    - A, B in 1..N: Bomb B in range of A
- If bomb B in range of A: Bomb explodes -> Trigger A

Output:
- Try to trigger with 1 shot -> maximum impact

Example:
Input:
4 3
1 2
2 4
1 3

Output:
4

Observation:
- Consider each bomb is vertex of graph
- If exist relation between A -> B: Edge from A -> B
- Maximum impact -> Maximum vertex from A to B

Pseudocode:
- Max = 0
- For each unvisited A of graph:
    - DFS:
        - Count vertex if exist path from A to every unvisited Bi in graph
        - If Max < Count -> Max = Count

