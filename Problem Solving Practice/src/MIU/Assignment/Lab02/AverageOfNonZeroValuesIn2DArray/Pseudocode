**Part a**

Algorithm averageOfArray(array[n][n])
Input All values are non-zero
Output Average of non-zero values

sum <- 0
for i <- 0 to n-1 do
    for j <-0 to n-1 do
        sum = sum + array[i][j]
average = sum / (n * n)
return average

Complexity: O(n^2)

**Part b**

Algorithm averageOfArray(array[n][n])
Input All non-zero appear in the lower triangular and diagonal part only
Output Average of non-zero values

sum <- 0
count <- 0
for i <- 0 to n-1 do
    for j <-0 to i do
        sum = sum + array[i][j]
        count = count + 1
average = sum / count
return average

Complexity: O(n^2)

**Part c**

Algorithm averageOfArray(array[n][n])
Input All non-zero appear in the upper triangular part only
Output Average of non-zero values

sum <- 0
count <- 0
for i <- 0 to n-1 do
    for j <- i+1 to n-1 do
        sum = sum + array[i][j]
        count = count + 1
average = sum / count
return average

Complexity: O(n^2)

**Part d**

Algorithm averageOfArray(array[n][n])
Input All non-zero appear as shown below
Output Average of non-zero values

sum <- 0
count <- 0
for i <- 0 to n-1 do
    for j <-  n / (i + 1) to 1 do
        sum = sum + array[i][ n - j]
        count = count + 1
        {decrease counter j}
average = sum / count
return average

Complexity: O(nlogn)