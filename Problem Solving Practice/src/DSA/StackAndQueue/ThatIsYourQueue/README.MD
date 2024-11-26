Input:
- 10 test cases:
    - Start with a line:
        - P: Population of country, 1 <= P <= 1 000 000 000
        - C: number of commands to process
    - C lines:
        - 'N' command: next citizen to be admitted -> Remove from the front and add back to queue
        - or 'E' x:
            - x: citizen is to be expedited to the front of queue
- 0 0: Stop

- Every citizen is assigned a Unique number, from 1 to P
- They are put in queue in order from 1 -> P


Output:
- Each test case:
    - One line for each 'N' command

Example:
Input:
3 6
N
N
E 1
N
N
N
10 2
N
N
0 0

Output:
Case 1:
1
2
1
3
2
Case 2:
1
2