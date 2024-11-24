Input:
- t in 1..10: test cases
- For each test case:
    - N in 2..1000000: number of students
    - e in 0..N/2: pair of friends
    - For each pair:
        - a, b: pair of friends

- Organizer will meet in person few people whom will pass news to their friends and so on.

Output:
- The number that organizer have to meet in person.

Example:
Input:
2
4
2
0 1
1 2
3
0

Output:
2
3

Observation:
- If student A:
    - Has no friend -> will meet in person with them
    - Has friend B -> No need to meet B
- Consider each student as vertex in graph
- If exist pair of friends A & B -> Have edge between A-B
- Meet in person A -> Distance[A] = 0
-> Apply DFS to find all distance from Organizer (Root) to every student
-> Answer is total of vertex which distance[v] = 1

Pseudocode:
- DFS -> distance[V];
- count = 0;
- For each student V:
    - If distance[V] = 0 -> count++
