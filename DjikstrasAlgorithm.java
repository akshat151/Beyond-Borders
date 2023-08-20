import java.util.*;

public class DjikstrasAlgorithm {

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge("Northeastern University", "Isabella Stewart Gardner Museum", 0.5);
        graph.addEdge("Isabella Stewart Gardner Museum", "Fenway Park", 0.7);
        graph.addEdge("Northeastern University", "Fenway Park", 1);
        graph.addEdge("Northeastern University", "First Church of Christ Scientist", 0.4);
        graph.addEdge("Fenway Park", "First Church of Christ Scientist", 0.5);
        graph.addEdge("Fenway Park", "Charles River Esplanade", 2.2);
        graph.addEdge("First Church of Christ Scientist", "Boston Public Library", 0.2);
        graph.addEdge("Charles River Esplanade", "Boston Public Library", 0.3);
        graph.addEdge("First Church of Christ Scientist", "First Corps Of Cadet Armory", 1.2);
        graph.addEdge("Boston Public Library", "First Corps Of Cadet Armory", 0.5);
        graph.addEdge("Charles River Esplanade", "Boston Commons", 2.6);
        graph.addEdge("First Corps Of Cadet Armory", "Boston Commons", 0.1);
        graph.addEdge("Boston Commons", "Faneuil Hall", 0.5);
        graph.addEdge("Boston Commons", "Boston Tea Party", 2.4);
        graph.addEdge("Faneuil Hall", "New England Aquarium", 0.1);
        graph.addEdge("Boston Tea Party", "New England Aquarium", 0.4);
        graph.addEdge("Boston Tea Party", "The Institute of Contemporary Art", 0.2);
        graph.addEdge("New England Aquarium", "The Institute of Contemporary Art", 0.6);
        graph.addEdge("New England Aquarium", "Old North Church", 0.5);
        graph.addEdge("Faneuil Hall", "Old North Church", 0.5);
        graph.addEdge("Faneuil Hall", "TD Garden", 0.5);
        graph.addEdge("Old North Church", "TD Garden", 0.2);
        graph.addEdge("TD Garden", "Museum of Science", 0.4);
        graph.addEdge("TD Garden", "LongFellow Bridge", 1.5);
        graph.addEdge("Museum of Science", "LongFellow Bridge", 0.4);
        graph.addEdge("Faneuil Hall", "LongFellow Bridge", 2.2);
        graph.addEdge("Boston Commons", "LongFellow Bridge", 2.4);
        graph.addEdge("LongFellow Bridge", "Ray and Maria Stata Center", 3);
        graph.addEdge("Ray and Maria Stata Center", "MIT Museum", 0.2);
        graph.addEdge("Ray and Maria Stata Center", "CZC", 1.3);
        graph.addEdge("MIT Museum", "CZC", 0.3);
        graph.addEdge("Ray and Maria Stata Center", "Simon's Hall", 1);
        graph.addEdge("CZC", "Simon's Hall", 0.5);
        graph.addEdge("Fenway Park", "Simon's Hall", 3.4);
        graph.addEdge("First Corps Of Cadet Armory", "Home", 7.4);
        graph.addEdge("Boston Tea Party", "Home", 4);
        graph.addEdge("The Institute of Contemporary Art", "Home", 0.2);

        String startLocation = "Northeastern University";
        String destinationLocation = "Museum of Science";

        List<String> shortestPath = graph.getShortestPath(startLocation, destinationLocation);

        System.out.println("Optimal route from " + startLocation + " to " + destinationLocation + ":");
        System.out.println();
        for (String location : shortestPath) {
            System.out.print(location + " -> ");
        }
    }
}

class Graph {
    private final Map<String, Map<String, Double>> adjacencyMap;

    public Graph() {
        adjacencyMap = new HashMap<>();
    }

    public void addEdge(String source, String destination, double weight) {
        adjacencyMap.computeIfAbsent(source, k -> new HashMap<>()).put(destination, weight);
        adjacencyMap.computeIfAbsent(destination, k -> new HashMap<>()).put(source, weight);
    }

    public List<String> getShortestPath(String start, String destination) {
        Map<String, Double> distances = new HashMap<>();
        Map<String, String> previousNodes = new HashMap<>();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

        distances.put(start, 0.0);
        priorityQueue.add(start);

        while (!priorityQueue.isEmpty()) {
            String current = priorityQueue.poll();
            if (current.equals(destination)) {
                break;
            }

            for (Map.Entry<String, Double> neighborEntry : adjacencyMap.getOrDefault(current, Collections.emptyMap()).entrySet()) {
                String neighbor = neighborEntry.getKey();
                Double weight = neighborEntry.getValue();

                Double totalDistance = distances.getOrDefault(current, Double.MAX_VALUE) + weight;
                if (totalDistance < distances.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    distances.put(neighbor, totalDistance);
                    previousNodes.put(neighbor, current);
                    priorityQueue.add(neighbor);
                }
            }
        }

        List<String> shortestPath = new ArrayList<>();
        String current = destination;
        while (previousNodes.containsKey(current)) {
            shortestPath.add(current);
            current = previousNodes.get(current);
        }
        shortestPath.add(start);
        Collections.reverse(shortestPath);
        return shortestPath;
    }
}
