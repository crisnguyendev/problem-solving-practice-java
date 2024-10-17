Input:
- N in 2..1000: number of countries
- For each line in 1..N-1:
    - u, v: there is road between u, v
- Q: girls
- For each girl:
    - x: where girl lives

- Bishu lives in country 1 - root of tree
- Bishu will accept the proposal from girl who live nearest his country
- If >=2 girls have same distance -> pick the minimum id
- No two girl in same country

Output:
- Id of girl whom Bishu will accept

Example:
Input:
6
1 2
1 3
1 4
2 5
2 6
4
5
6
3
4

Output:
3

Observation:
- Consider each country is vertex of graph
- Distance between each country = same
