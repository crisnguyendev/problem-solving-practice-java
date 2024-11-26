# Input:
- N  contracts, each has deadline d(i)
- Programmer need b(i) time to complete contract i
- If pay him x(i) -> he needs only b(i) - a(i) * x(i)
- Can do instantly if extra payment is b(i) / a(i)
# Output:
- Minimum sum of money to pay extra, so that programmer perform all contract in time
# Example:
- Input:
```
1
2
20 50 100
10 100 50
```
- Output:
```
5.00
```
# Observation:
- 