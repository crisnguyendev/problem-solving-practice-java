Input:
- Kefa's house: in vertex 1
- Restaurant: in leaf vertices
- Kefa can go from house to restaurant if no more than m vertices with cats in his path.

- n in 2..10^5: number of vertices
- m in 1..n: maximum vertices with cats
- for each vertex a[i] of n:
    - 0: no cat
    - 1: has a cat
- for each (x,y) of n - 1: edges of tree

Output:
- Number of distinct leaves of tree path that Kefa can go from house to restaurant

Example:
Input:
4 1
1 1 0 0
1 2
1 3
1 4

Ouput:
2

Observation:
- Kefa go from root vertex
- While exist unvisited vertices:
    - If exist edge that connect 2 vertices
- A leaf node:
    - Is a node without any child node
    - Do not count cat to path
    - Counted as result if has valid path
- A non-leaf node:
    - Is a node with some edges to other nodes (child node)
    - Add to path
    - Count cat to path