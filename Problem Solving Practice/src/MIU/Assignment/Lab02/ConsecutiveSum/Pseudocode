Solution 1: Sliding window

Algorithm consecutiveSum(A[n], k)
Input Given an integer array A[0 .. n - 1] and a positive integer k <= n
Output Array Consecutive Sum

B[n - k]
sum <- 0
j <- 0
for i <- 0 to n - 1
    if i < k
        sum = sum + A[i]
    else
        j = j + 1
        sum = sum - A[j] + A[i]
    B[j] = sum
return B

Complexity: O(n)


Solution 2: Nested loop

Algorithm consecutiveSum(A[n], k)
Input Given an integer array A[0 .. n - 1] and a positive integer k <= n
Output Array Consecutive Sum

B[n - k]
j <- 0
for i <- 0 to n - 1 - k
    sum <- 0
    for j <- i to i + k
        sum = sum + A[j]
return B

Complexity: O(n^2)

