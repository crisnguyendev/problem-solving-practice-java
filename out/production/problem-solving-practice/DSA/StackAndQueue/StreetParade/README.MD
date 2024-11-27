Input
- n: number of mobiles
- 1..n: inorder mobiles
- mobile enter side street -> leave street first
- mobile cannot drive back
- mobile cannot re-enter the side street

Output:
- yes: if mobile can be re-ordered with side street
- no:

Example:
Input:
5
5 1 2 4 3
0

Output:
yes

Observation:
- mobile enter side street -> stack (LIFO)
- mobile after cross side street -> queue (FIFO)
- If Mobile can be re-ordered:
    - Go with order 1 to n
    - The last in side street i can get back to main street only after mobile i-1 just cross side street
    - Yes if all mobile cross side street with right order + no mobile left in side street.
