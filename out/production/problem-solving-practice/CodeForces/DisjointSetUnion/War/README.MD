Input:
- n: number of people
- c, x, y:
    - c: code of operation
        - 1: setFriends
        - 2: setEnemies
        - 3: areFriends
        - 4: areEnemies
    - x, y: parameters
- Last line: 0 0 0
- ~: friends
- *: enemies
- x ~ y, y ~ z -> x ~ z
- x ~ y -> y ~ x
- x ~ x: true
- x * y -> y * x
- x * x: false
- x ~ y, y * z -> x * z

Output:
- For every areFriends and areEnemies operation: write 0 or 1
- For every setFriends or setEnemies operation
    - which contradicts with previous knowledge: write -1
    - Successful -> no output

Example:
Input:
10
1 0 1
1 1 2
2 0 5
3 0 2
3 8 9
4 1 5
4 1 2
4 8 9
1 8 9
1 5 2
3 5 2
0 0 0

Output:
1
0
1
0
0
-1
0

Observation:
- x & y are friends -> x & y are in same set -> Union x & y & union enemy of x with enemy of y
- x & y are enemies -> x & y are in different set -> Union x with enemy of y & union y with enemy of x