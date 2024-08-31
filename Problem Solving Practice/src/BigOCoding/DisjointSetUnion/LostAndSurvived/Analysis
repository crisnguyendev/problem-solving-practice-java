Input:
- N, Q in 1.. 100 000
- For Q lines:
    - A, B: survivor A & B unite into a larger group

Output:
- answer each Q line: difference between group of largest and smallest size at that time.
- If there is 1 group -> output 0
- If 2 survivors are same group already -> skip merging and print current answer.

Example:
Input:
5 3
1 2
2 3
5 4

Output:
1
2
1

Observation:
- With A, B:
    - Check group (parent) of A and B
    - If parent of A != parent of B -> Unite A & B
        -> Size of group of A & B = Size group A + Size group B
        -> Check and assign max group size & min group size
