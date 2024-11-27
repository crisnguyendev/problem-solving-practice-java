Input
- X: Samarpit's key value
- Z: Lock's key value
- N: number of Samarpit's other key
- for Y i in 1..N: value of other key
    - New Key value X = (X * Y) % 100000
    - Took same 1s for each

Output:
- Minimum time to get to Lock's key or -1

Observation:
- For each new key value Xi:
    - Process to merge X(i) with Y to new key value X(i+1):
        - New Node X(i+1) of graph
        - Path from X(i) to X(i+1)
    - Processing time = constant -> Equal distance -> BFS
    - Required time = Shortest path from X to Z

Pseudocode
- For each Y in 1..N:
    - X' = (X * Y) % 100 000
    - If X' is new -> add as new node
    - Add Edge X - X'