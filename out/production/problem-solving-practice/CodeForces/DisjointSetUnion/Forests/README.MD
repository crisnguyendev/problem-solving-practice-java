Input:
- n: number of cases
- For each case (separated by blank line):
    - P: number of people
    - T: number of tree
    - Pair: P(i) can hear T(i)

Output:
- How many opinions are represented: people hold the same opinion if they hear exactly the same set of tree.

Example:
Input:
1

3 4
1 2
3 3
1 3
2 2
3 2
2 4

Output:
2

Observation:
- People are in same opinion:
    - Have same set of tree -> Union
- Count opinion -> count different set