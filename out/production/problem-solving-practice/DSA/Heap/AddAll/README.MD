# Input:
- N positive integers N in [2, 5000], number < 100 000
- If only 2 first then:
  - Cost = Sum of 2 numbers
- Else:
  - Cost = new number + last cost

# Output:
- Minimum total cost of addition set of numbers

# Example:

Input:
1 2 3

Output:
4

# Observation:
- Minimum cost if starting from minimum number in ascending order -> Priority Heap
