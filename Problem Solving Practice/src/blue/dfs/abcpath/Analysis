Input:
- Each Test case start with:
    - H, W in 1..50: height and width of grid
    - For H lines:
        - W uppercase letters
- Stop when H = W = 0
- 2 dimension grid of letter
- Find Longest path start from 'A' to consecutive letters.
- Path can step from 1 letter to any adjacent letters (horizontally, vertically, or diagonally)

Output:
- Print Case C: X solution

Example:
Input:

4 3
ABE
CFG
BDH
ABC
0 0

Output:
Case 1: 4

Observation:
- Consider each cell of grid is vertex of graph
- Edge connect between cells is same -> DFS
- Path start from 'A' -> DFS for each 'A' cell
- Because can step to diagonally cell -> Need recursive to save current length for same cells but different paths.

