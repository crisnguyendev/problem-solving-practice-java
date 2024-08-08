Input:
- T in 1..500: number of test cases
- T Strings representing expressions L: L.length in 1..10^6
- Total size all input expressions < 5.10^6
- "<" always have only one corresponding ">" after

Output:
- Length of longest prefix that is valid or 0

Example:
Input:
3
<<>>
><
<>>>

Output:
4
0
2

Observation:
- Valid prefix:
    - Only one ">" after each "<"
    -> Stack
        - If see ">" -> push -> Stack size++
        - If see "<" after ">" = Stack is not empty -> pop
        - If see "<" but not after any ">" = Stack is empty -> break expression
    - Number of ">" = number of "<"
    - Length = x 2 of numbers of valid pair ">" and "<"

Pseudo code
