Algorithm find3rdLargest(array[n])
Input array of n integers
Output third max value in array

firstMax <- Int.MinValue
secondMax <- Int.MinValue
thirdMax <- Int.MinValue

for i <- 0 to n - 1 do
    if array[i] > firstMax then
        firstMax <- array[i]
    else if array[i] > secondMax then
        secondMax <- array[i]
    else if array[i] > thirdMax then
        thirdMax <- array[i]
return thirdMax

-> Worst case: O(n)


