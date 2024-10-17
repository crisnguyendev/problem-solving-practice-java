Input:
- Ferry is initialized from left bank
- Loading & unloading time = 0
- Ferry travel continuously between banks if there is >= 1 car at bank
- Ferry can take n cars across river in t minutes and return in t minutes.
- When ferry arrive at a bank: unload all cars and load up to n cars.
- c: number of test cases
- n, t, m
- For each m:
    - Arrival time of car at bank + bank which car arrive

Output:
- For each test case:
    - For each car: Time that car is unloaded at the opposite bank
Example:
Input:
1
2 10 3
10 right
25 left
40 left

Output:

30
40
60

Observation:
- While there is waiting car at any bank -> Ferry will not stop working
- Initially, Ferry will start from Left Bank
- If 1st car in Left
- When Ferry arrive at a bank:
    - Unload all ferries that arrived at opposite bank
    - If there is waiting car & car in Ferry < n -> Load car into Ferry
    - If there is waiting car & car in Ferry >= n -> Cannot load car into Ferry
    - Move to opposite bank

Pseudocode
- ferryStay = left
- for each car:
    - add to waiting queue
- while waiting queue is not empty:
    -
