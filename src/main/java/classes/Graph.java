package classes;


import java.util.*;

class Graph {
    private Map<String, Map<String, Integer>> adjacencyMap;

    public Graph() {
        adjacencyMap = new HashMap<>();
    }

    public void addEdge(String source, String destination, int weight) {
        adjacencyMap.computeIfAbsent(source, k -> new HashMap<>()).put(destination, weight);
        adjacencyMap.computeIfAbsent(destination, k -> new HashMap<>()).put(source, weight);
    }

    public List<String> dijkstra(String source, String destination) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        Set<String> visited = new HashSet<>();

        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        queue.add(source);
        distances.put(source, 0);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            visited.add(current);

            if (current.equals(destination)) {
                break;
            }

            Map<String, Integer> neighbors = adjacencyMap.getOrDefault(current, Collections.emptyMap());
            for (String neighbor : neighbors.keySet()) {
                if (visited.contains(neighbor)) {
                    continue;
                }

                int weight = neighbors.get(neighbor);
                int newDistance = distances.get(current) + weight;

                if (!distances.containsKey(neighbor) || newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        List<String> path = new ArrayList<>();
        String current = destination;
        while (previous.containsKey(current)) {
            path.add(0, current);
            current = previous.get(current);
        }
        path.add(0, source);

        return path;
    }
    public int calculateDistance(List<String> path) {
        int distance = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            String current = path.get(i);
            String next = path.get(i + 1);
            distance += adjacencyMap.get(current).get(next);
        }
        return distance;
    }
}



