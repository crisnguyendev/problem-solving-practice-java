Input:
- N number element of array A [1, 100000]
Output:
- For each element A(i), find product of:
    - Largest, Second largest and Third largest
    - Or -1 if not exist product

Example:
Input:
5
1 2 3 4 5

Output:
-1
-1
6
24
60

Observation:
- Find largest -> Use Max Heap
- Not exist product -> Heap size < 3
- For every time add new element to heap do
    - Poll 3 top elements -> Product
    - Add those back to heap

