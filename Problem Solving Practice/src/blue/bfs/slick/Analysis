Input:
- N in 1..250: rows
- M in 1..250: columns
- For each row in N:
    - M integers: 1 or 0
-  Two pixels in the same slick if they are in the same row or the same column.

Output:
- Number of slicks in the sea
- Output the size of each slick in ascending order & number of slicks of that size.

Example:
Input:
10 10
1 1 1 1 1 1 1 1 1 1
1 1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 1 1 1
1 1 0 0 1 0 0 1 1 1
1 0 1 0 0 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
1 1 1 1 1 1 1 1 1 1
0 0 0 0 0 0 0 0 0 0
1 1 1 1 1 1 1 1 1 1
0 0

Output:
7
1 2
2 1
6 1
10 2
20 1

Observation:
- 2 slicks is separated by space (0)
- Two adjacent pixels in same row or column:
    - Have same value = 1: in same slick
    - Different values: stop expand area of current slick
- Each pixel is vertex
- Try to expand slick by compare to next adjacent pixels in same row or colum