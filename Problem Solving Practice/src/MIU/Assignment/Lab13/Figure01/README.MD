# 1. Adjacency matrix:
```
    A   B   C   D   E   F   G   H   I 
A   0   22  9   12  0   0   0   0   0  
B   22  0   35  0   0   36  0   34  0  
C   9   35  0   4   65  42  0   0   0 
D   12  0   4   0   33  0   0   0   30 
E   0   0   65  33  0   18  23  0   0  
F   0   36  42  0   18  0   39  24  0
G   0   0   0   0   23  39  0   25  21 
H   0   34  0   0   0   24  25  0   19
I   0   0   0   30  0   0   21  19  0 
```
# 2. Shortest path from A by using Dijkstra algorithm:
-> **Select and mark as visited A, unvisited adjacency vertices: B, C, D**
- **dist[A] = 0**
- **path[A] = { }**
  - dist[B] = dist[A] + weight(A, B) = 0 + 22 = 22
  - dist[C] = dist[A] + weight(A, C) = 0 + 9 = 9
  - dist[D] = dist[A] + weight(A, D) = 0 + 12 = 12

- **Select and mark as visited vertex C, unvisited adjacency vertices: B, F, E, D**
- **dist[C] = dist[A] + weight(A, C) = 0 + 9 = 9**
- **path[C] = path[A] U {A, C} = {(A, C)}**
  - dist[B] = dist[C] + weight(C, B) = 9 + 35 = 44
  - dist[F] = dist[C] + weight(C, F) = 9 + 42 = 51
  - dist[E] = dist[C] + weight(C, E) = 9 + 65 = 74
  - dist[D] = dist[C] + weight(C, D) = 9 + 4 = 13
- **Select and mark as visited vertex D, unvisited adjacency vertices: E, I**
- **dist[D] = dist[A] + weight(A, D) = 0 + 12 = 12**
- **path[D] = path[A] U {A, D} = {(A, D)}**
  - dist[E] = dist[D] + weight(D, E) = 12 + 33 = 45
  - dist[I] = dist[D] + weight(D, I) = 12 + 30 = 42
- **Select and mark as visited vertex B, unvisited adjacency vertices: F**
- **dist[B] = dist[A] + weight(A, B) = 0 + 22 = 22**
- **path[B] = path[A] U {A, B} = {(A, B)}**
  - dist[F] = dist[B] + weight(B, F) = 22 + 36 = 58
- **Select and mark as visited vertex I, unvisited adjacency vertices: H, G**
- **dist[I] = dist[D] + weight(D, I) = 12 + 30 = 42**
- **path[I] = path[D] U {D, I} = {(A, D), (D, I)}**
  - dist[H] = dist[I] + weight(I, H) = 42 + 19 = 61
  - dist[G] = dist[I] + weight(I, G) = 42 + 21 = 63
- **Select and mark as visited vertex E, unvisited adjacency vertices: F, G**
- **dist[E] = dist[D] + weight(D, E) = 12 + 33 = 45**
- **path[E] = path[D] U {D, E} = {(A, D), (D, E)}**
  - dist[F] = dist[E] + weight(E, F) = 45 + 18 = 63
  - dist[G] = dist[E] + weight(E, G) = 45 + 23 = 68
- **Select and mark as visited vertex F, unvisited adjacency vertices: G, H**
- **dist[F] = dist[C] + weight(C, F) = 9 + 42 = 51**
- **path[F] = path[C] U {C, F} = {(A, C), (C, F)}**
  - dist[G] = dist[F] + weight(F, G) = 51 + 39 = 90
  - dist[H] = dist[F] + weight(F, H) = 51 + 24 = 75
- **Select and mark as visited vertex H, unvisited adjacency vertices: G**
- **dist[H] = dist[I] + weight(I, H) = 42 + 19 = 61**
- **path[H] = path[I] U {I, H} = {(A, D), (D, I), {I, H}}**
  - dist[G] = dist[H] + weight(H, G) = 61 + 25 = 86
- **Select and mark as visited vertex H, unvisited adjacency vertices: none**
- **dist[G] = dist[I] + weight(I, G) = 42 + 21 = 63**
- **path[G] = path[I] U {I, G} = {(A, D), (D, I), (I,G)}**

# 3. Time complexity: V * V (V: number of vertices)

# 4. Find MST using Kruskal algorithm:
```
- C, D: 4
  - findSet(C) != findSet(D)
    - joinSet: {C, D}
- A, C: 9
  - findSet(A) != findSet(C)
    - joinSet: {A, C, D}
- A, D: 12
  - findSet(A) == findSet(D)
  - Skipped
- E, F: 18
  - findSet(E) != findSet(F)
    - joinSet: {E, F}
- H, I: 19
  - findSet(H) != findSet(I)
    - joinSet: {H, I}
- G, I: 21
  - findSet(G) != findSet(I)
    - joinSet: {G, H, I}
- A, B: 22
  - findSet(A) != findSet(B)
    - joinSet: {A, B, C, D}
- E, G: 23
  - findSet(E) != findSet(G)
    - joinSet: {E, F, G, H, I}
- F, H: 24
  - findSet(F) == findSet(H)
  - Skipped
- G, H: 25
  - findSet(G) == findSet(H)
  - Skipped
- D, I: 30
  - findSet(D) != findSet(I)
    - joinSet: {A, B, C, D, E, F, G, H, I}
- All vertices are visited -> Stop
```
# 5. Time complexity: ElogE (E: number of edges)