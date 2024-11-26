Input:
- t: number of test cases
- For each test case:
    - m, n: number of row and column in maze
    - M[i][j]:
        - '#': wall
        - '.': space
- Valid maze:
    - Only 1 entry vertex
    - Only 1 exit vertex
    - At least 1 path from entry to exit vertex

Output:
- The maze is valid or invalid

Example:
Input:
1
4 4
####
#...
#.##
#.##

Output:
valid

Observation:
- Consider each M[i][j] as a node of graph
- Entry vertex or Exit Point: from rear edge: i or j = 0
- Path from vertex X to vertex Y: All spaces without wall.
-


