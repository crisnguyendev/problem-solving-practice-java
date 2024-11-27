Input
- t <= 1000: number of test cases
- R <= 100: rows
- C <= 100: columns

Output:
- Try to find sentence ALL IZZ WELL in the matrix

Example:
Input:
1
3 6
AWE.QX
LLL.EO
IZZWLL

Output:
YES

Observation:
- Each cell in matrix: vertex of graph
- Find vertical/horizontal neighbours
- Sentence ALLIZZWELL is started by 'A' char -> DFS from 'A'
- Sentence = All chars in order -> If cannot find any char in order -> Stop DFS

Pseudocode
- For each 'A' in Matrix
    - DFS(A):
        - Visited[i]
        - List of char: Chars in sentence in order
        - Add 'A' to stack
        - Mark Chars[0] as found
        - Mark Visited[0] = true
        - While stack is not empty:
            - Get all neighbours of first char (c) in stack
            - If found neighbour = next char in sentence && unvisited:
                - Add neighbour to stack
            - Else cannot find any neighbour that is matched with next char in sentence -> stop DFS with current 'A'
        - If found all chars in sentence in order -> return YES
    - If cannot find any 'A' that is return YES -> Return NO
