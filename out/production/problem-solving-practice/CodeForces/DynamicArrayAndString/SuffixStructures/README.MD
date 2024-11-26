Input:
- String s
- String t
- s != t
- Only lowercase char (a - z) for both string.
- Length <= 100
- Suffix automaton function: remove char from String
- Suffix array function: swap 2 chars

Expect Output:
- Try above functions to transform s -> t. Result could be one of cases:
    + both: need involve both function
    + array: need involve only suffix array function
    + automaton: need involve only suffix automaton function
    + need a tree: none of above

Example:
- Input:
    automation
    tomat
- Output:
    both

Observation:
- s can be transformed to t if only:
    - Count of each unique char in t <= in s
        - Need only suffix array if:
            - s.length = t.length -> array
        - Else if need involve suffix automaton also (both) if:
            - s.length > t.length -> both
        - Need only suffix automaton if:
            - order of each char in s = in t -> automaton
    - else -> need a tree

Brute force solution:
- for char c in t:
    - if s not contain char c -> return Need a tree
    - count c in s:
        - if count c in s < t -> return Need a tree
    - if s.length = t.length -> return Array
    - if s.length > t.length -> return


