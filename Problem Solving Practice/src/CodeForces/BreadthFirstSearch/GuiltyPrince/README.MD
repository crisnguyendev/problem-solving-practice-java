Input:
- A cell can be a land or water
- Each time the prince can move to a new cell from current position if share a side

- T <= 500: number of test
- For each test case:
    - W in 1..20: number of cells in x direction
    - H in 1..20: number of cells in y direction
    - For each line of H: W characters
        - '.' : land
        - '#' : water
        - '@' : initial position of prince

Output:
- For each case:
    - Print case number & the number of cells to reach from initial position.

Example:

- Input:
1
11 6
..#..#..#..
..#..#..#..
..#..#..###
..#..#..#@.
..#..#..#..
..#..#..#..

- Output:
Case 1: 6

Observation:
- Prince can only move from land to land:
    - Consider each cell as a node of graph
    - Edge to connect from cell to nearby cells (via x, y direction), with same distance -> BFS
    - Try to connect to maximum of nearby cells

Pseudocode:
- Node (x, y)
- Array of Node: nodes
- Queue of Node: queue
- For each line 1..H: y
    - For each row 1..W: x
        - Add node to nodes