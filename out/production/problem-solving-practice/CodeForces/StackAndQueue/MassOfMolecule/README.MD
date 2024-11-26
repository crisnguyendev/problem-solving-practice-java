Input
- Formula of molecule:
    - Consist of chars H, C, O, (, ), 2, 3, .., 9 only
    - Length <= 100
Rules of formula:
    - Group of atoms is in parentheses: ( ). Example: CH(OH)
    - Group can be nested
    - Same letter can be replace by letter + number of occurrences. Ex: COOHHH -> CO2H3
    - Same group can be replace by group + number of occurrences. Ex: CH(CO)(CO) -> CH(CO)2
    - Number is always >= 2 and <= 9
    - A mass of a molecule is a sum of masses of all its atoms. H: 1, C: 12, O: 16

Output:
- Mass of molecule <= 10 000

Example:
Input:
((CH)2(OH2H)(C(H))O)3

Output:
222

Observation:
Read formula:
- Mass of single group/atom =  mass of atom/group * occurrences
- Group: end with ')'
    - Loop back to previous chars until meet '(' -> Pop stack
- Meet number: multiply with previous group -> Pop then push new value

