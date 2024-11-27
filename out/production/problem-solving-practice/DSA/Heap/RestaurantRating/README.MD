# Input: 
- Review is positive if it is in top one-third (1/3) of reviews
- Minimum rating = minimum in top one-third reviews
# Output:
- Minimum rating on website
# First observation:
- Calculate top one-third while inputting -> Max Heap
- If number of reviews < 3 -> Cannot get one-third
# Brute force Algorithm: find minimum of top rating
```
while adding rating do
    add to maxHeap
    if maxHeap.size >= 3
        totalTopRating = maxHeap.size / 3 
        for i 1..totalTopRating do
            minimumRating = maxHeap.poll
            add minimumRating to tempList
        for each rating in tempList
            add rating back to maxHeap
        return minimumRating
    else
        return not exist
```
# Optimization: 
- If use only 1 heap to get minimum of top ratings -> Have to poll and add back after every input
- totalTopRating will increase after every 3 reviews

  - Use minHeap to save top rating
  - Use maxHeap to save nonTopRating
  - 

# Optimal Algorithm: find minimum of top rating
```
When add new rating do
    if have not enough review then
      add to maxHeap
    if new rating > top of minHeap then
      poll minHeap and add to maxHeap 
      add new rating to minHeap
    if totalTopRating increase then
      poll maxHeap to add to minHeap
if minHeap is not empty then
  return minHeap.poll
else
  return not exist
```
