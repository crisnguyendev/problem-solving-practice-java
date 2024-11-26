Input
- N in 3..250: rows
- M in 3..250: columns
- For each N line:
    - For each M chars:
        - '.': blank field
        - '#': a fence
        - 'k': sheep
        - 'v': wolf
- 2 fields belong to same sector if:
    - can move from field A to B without going over the fence
    - only horizontal or vertical steps
- If can escape from field A from the backyard, that field does not belong to any sector.
- Sheep can defend only if they outnumber the wolves in sector -> all wolves die
- Otherwise -> all sheep die
- If a field does not belong to any sector -> all sheep & wolves survive

Output:
- Number of sheep and wolves survive

Example:
Input
8 8
.######.
#..k...#
#.####.#
#.#v.#.#
#.#.k#k#
#k.##..#
#.v..v.#
.######.

Output:
3 1

Observation:
- Field does not belong to any sector -> in the sideline of backyard
- Count sheep or wolves as field, could belong to sector
- Consider each field as vertex
- Expand sector by check adjacent fields (same row or column) -> BFS

Pseudocode
- Survival sheep = Survival wolves = 0;
- For each field (n, m) of backyard:
    - If n = 0 | m = 0 | n = N-1 | m = M-1 -> in sideline -> Not belong to any sector
    - If field is '#' -> fence -> Not belong to any sector
    - Else -> Maybe belong to sector -> Begin BFS from this Field (n, m)
- BFS to expand sector:
    - Sheep in sector = Wolves in sector= 0
    - Add Field(n, m) to queue
    - Free sector = true
    - While queue is not empty
        - Try adjacent fields & not visited:
            - If it is blank field -> Check if in sideline -> Free sector
            - If it is sheep -> Sheep in sector++
            - If it is wolf -> Wolves in sector++
            - Add Field (blank/sheep/wolf) to queue
    - If not free sector:
        - If Sheep in sector++ > Wolves in sector++ -> Survival sheep+= Sheep in sector
        - Else -> Survival wolves+= Wolves in sector++
    - Else:
        - Survival sheep+= Sheep in sector
        - Survival wolves+= Wolves in sector++
