Input:
- n, m in 1..50: size of map
- k in 0..50: number of lakes
- for each n lines:
    - for each m chars present for cell:
        - '.': water
        - '*': land
- Map contains at least k lakes
- Lake: water cells connected by sides but not connected to ocean

Output:
- Minimum number of cell should be transformed to land
- Map after transformation

Example
Input:
5 4 1
****
*..*
****
**.*
..**

Output:
1
****
*..*
****
****
..**

Observation
-