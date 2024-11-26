Input:
- n queries: in 1..200 000
- Query i is receive at t(i), need be processed for d(i) time: t(i) is distinct
- If server is free + queries queue empty -> start process immediately
- If server is busy + queue size < b -> add to queue
- If server is busy + queue size >= b -> reject new query + never be processed
- b in 1..200 000
- When server finish 1 query -> process next one in queue
- If new query comes at x + server finish query at x -> process new query

Output:
- Print finish time for each query(i) or -1 if it is rejected

Example:
Input:
5 1
2 9
4 8
10 9
15 2
19 1

Output:
11 19 -1 21 22

Observation:
- At t time:
    - Server is free = t > last completed time in Queue
    - Server is busy =  t < last completed time in Queue
    - Add to queue -> Compute last completed time again
    -
