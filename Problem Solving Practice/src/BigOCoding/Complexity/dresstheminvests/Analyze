Input:
- n in 1.. 10^5: number of soldiers
- m in 1..10^5: number of vests
- x, y in 0..10^9: permissible value of size
- a1 <= a2 ... <= an in 1..10^9: desired sizes of vests
- b1 <= b2 ... <= bm in 1..10^9: available vests
- soldier i-th is ok with vest j-th if: ai - x <= bj <= ai + y

Output:
- k: maximum of soldiers can have vest
- u, v in 1..k:
    - u: soldier
    - v: vest

Example:
-Input:
    3 3 2 2
    1 5 9
    3 5 7

Output:
    3
    1 1
    2 2
    3 3

Observation:
- 1 soldier could fit with multiple vests
- 1 soldier have boundary for desired size:
    - lower bound
    - upper bound
- Smallest soldier should try from the smallest vest
- 1 vest cannot be matched with any soldier if:
    - smaller than the smallest desired size
    - bigger than the biggest desired size
- when try to pair the smallest vest in available list with smallest soldier in waiting list, could have case:
    - smaller than the lower bound of soldier -> this vest cannot match with any soldier later on -> remove the vest from available list
    - bigger than lower bound and smaller than upper bound -> found it -> remove pair of vest + soldier from list
    - bigger than upper bound -> this soldier cannot match with any vest later on -> remove this soldier from the waiting list
    - matching will be end if the waiting list or available list is empty.
