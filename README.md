# Beyond-Borders
A java tool to find the best route to travel the city using the shortest path algorithm.

Beyond Borders: Maximizing Your Student Experience Abroad

# Introduction

The shortest path problem is an extensively researched area in algorithms, forming the core of route planning algorithms. Dijkstra's algorithm, a simple yet highly effective approach, is widely recognized as one of the best-known algorithms for this purpose. Dijkstra, the algorithm efficiently and accurately determines the optimal path in various applications, making it one of the cornerstones of route planning and network optimization. The algorithm is employed by route-finding software worldwide to efficiently determine the optimal route between two locations on a map. However, in the real world, travel route optimization can be more intricate than finding the shortest path in a graph. When considering public transportation, factors such as travel time, number of transfers, and monetary cost come into play, making the quest for the best travel route more complex.
To truly identify the optimal route, these diverse factors must be incorporated into the algorithm. This leads us to a significant question: How can we leverage Dijkstra's algorithm to discover the shortest paths and optimize travel time between key locations in a foreign city, thus enabling students to navigate their day-to-day life more efficiently while studying abroad?

# Context :
As an International Student navigating an unfamiliar city, I can attest to the overwhelming challenges posed by public transportation systems and language barriers. Thankfully, with the application of Dijkstra's algorithm, my fellow students and I can now find the shortest and most efficient paths between our essential locations, such as universities, accommodations, libraries, landmarks, and social spots. This newfound efficiency has saved us valuable time, allowing us to dedicate more focus to our studies, cultural experiences, and personal growth. The implementation of Dijkstra's algorithm for optimizing travel time has proven to be not only beneficial for students studying abroad, but it has also provided a practical application of the algorithm we learned in our Algorithm course.
Through this project, we have deepened our understanding of graph algorithms and witnessed their real-world relevance in a tangible and meaningful way. Moreover, there are notable cost savings associated with efficient travel planning. By reducing our travel time and utilizing the most direct routes, we have successfully minimized transportation expenses, leaving us with more resources to invest in other aspects of our study abroad journey.

# Analysis
This project's methodology is based on the use of a greedy algorithm to calculate the most optimal itinerary, incorporating all of the destinations a student must visit within a day. The basis is the road map, with destinations acting as vertices (V) and roads acting as edges (E), both weighted proportionally to their respective lengths in miles. The source point is the student's university, and the ultimate destination is the student's home place. The city of Boston serves as the project's main point of reference. As a result, the distances between points A and B, as well as the locations inside Boston, are regarded as well-known and established inputs to the analysis.
To solve this problem, we used Dijkstra's method, which is famous for its temporal complexity of O(E * log(V)). In this approach, the shortest path tree is constructed, with the selected source node serving as the root. During execution, two sets are kept: one of visited vertices and the other of vertices remaining to be examined and included in the shortest path tree. At each iteration, a vertex from the "yet to be visited" set is chosen and added to the "visited" set based on its lowest distance from the source.
We created a Graph class in the application that represents the destinations as V and its edges as E. We introduced some new methods, such as addEdge and getShortestPath. The addEdge method takes the source node, the destination node, and the distance (in miles), whereas the getShortestPath method takes the start node and the destination node and returns the shortest path. Furthermore, the main method will make use of the Graph class, with the map, start, and destination nodes as input.
Our implementation operates on the principle of iteratively exploring nodes in the graph, keeping track of the shortest known distance from the source node to each visited node and works as follows :
1. Mark all locations as unvisited and create a set to keep track of locations included in the shortest path tree. Initially, this set only contains the source location i.e. university.
2. Assign a distance value as infinite to all the locations in the input graph. Assign distance value as zero for the source location.
3. Set the source as the current location.
4. Dijkstra's algorithm selects the location with the smallest distance from the set of
unvisited locations and explores its neighboring locations.
5. For each neighboring location, the algorithm updates its distance if a shorter path is found
through the current location.
6. This process continues until all locations are visited, and the shortest distances from the
source location to all other locations are determined.
 
 One of the key aspects that contribute to the efficiency of Dijkstra's algorithm is its use of a priority queue (commonly implemented with a min-heap) to efficiently select the node with the smallest distance in each iteration. This allows the algorithm to avoid redundant calculations and focus on nodes that contribute to finding the shortest path more quickly.
The provided map depicts the destinations as vertices and the distance (in miles) between them is the edges. Here, “Northeastern University” serves as the designated starting point or source node and the Home icon represents the sink node.
After running the algorithm with different inputs, we noticed that the implemented algorithm performs well finding the shortest and most efficient paths between locations. It also efficiently plans our routes and minimizes travel time between them.
The below image shows the shortest path.
 
# Let’s find the shortest path from the source to various locations.
# Example 1 :
Source : Northeastern University

Destination : First Corps Of Cadet Armory
Shortest Path :
Northeastern University -> First Church of Christ Scientist -> Boston Public Library -> First Corps Of Cadet Armory
Distance : 1.1

# Example 2 :
Source : Northeastern University
Destination : New England Aquarium
Shortest Path :
Northeastern University -> First Church of Christ Scientist -> Boston Public Library -> First Corps Of Cadet Armory -> Boston Commons -> Faneuil Hall -> New England Aquarium
Distance : 1.8
 
# Example 3 :
Source : Northeastern University
Destination : Home
Shortest Path :
Northeastern University -> First Church of Christ Scientist -> Boston Public Library -> First Corps Of Cadet Armory -> Boston Commons -> Faneuil Hall -> New England Aquarium -> The Institute of Contemporary Art -> Home
Distance : 6.2

# Conclusion
Despite the time constraints, we are content with the results obtained from the algorithm and have confidence in its ability to optimize travel routes for international students, as outlined in the initial objectives of this report. Specifically, we can successfully determine an optimal route from the starting point (Northeastern University) to the destination point (Home) that encompasses all the required locations a student has to visit within a day, ensuring efficiency and providing an optimal route.
