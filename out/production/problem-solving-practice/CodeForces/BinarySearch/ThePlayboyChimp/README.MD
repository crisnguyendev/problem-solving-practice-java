Input:
- N in 1..50 000: number of lady chimp
- N integers in 1..2^31 - 1: height of N chimps
- Chimp are ordered in non-decreasing of their height
- Q in 1..25 000: number of queries
- Q lines: height of Luchu in 1..2^31 - 1
- Queries are not in order


Output:
- For each query height:
    - Find height of tallest lady chimp that is shorter than Luchu
    - Find height of shortest lady chimp that is taller than Luchu
    - If cannot find -> replace height by X

Example:
Input:
4
1 4 5 7
4
4 6 8 10

Output:
1 5
5 7
7 X
7 X

Observation:
- Given Luchu's height = H:
    - Pair of tallest and shortest lady chimp height -> chimp[i] and chimp[i+1]: chimp[i] < H && chimp[i+1] > H
    - Find H in array chimp until left  = right - 1


