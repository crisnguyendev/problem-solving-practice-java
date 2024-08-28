Input:
- n in 1..500: rows
- m in 1..500: columns
- For each n rows:
    - For each m chars:
        - '.': intact ice
        - 'X': cracked ice
- r1, c1: initial coordinates, which is cracked ice.
- r2, c2: target cell.

- From each cell, can move to adjacent cell which is intact ice -> become cracked ice
-

Output:
- Can reach to destination: YES or NO

Example:
Input
4 6
X...XX
...XX.
.X..X.
......
1 6
2 2

Output:
YES

Observation:
- Consider each cell as vertex in graph
- Each move to intact ice: same -> BFS

Pseudocode:
- Add StartCell(r1, c1) to queue
- While queue is not empty
    - currentCell = queue.poll
    - For each adjacent cells of currentCell
        - If adjacent cell = intact ice ->
            - If adjacent cell = target cell -> return YES
            - Else:
            - Add adjacent cell to queue
            - Mark adjacent as visited (cracked)
Return No



