package classes;
import java.util.*;
public class FordFulkerson {

	private int[] parent;
    private Queue<Integer> queue;
    private int numberOfVertices;
    private boolean[] visited;

    public FordFulkerson(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        this.queue = new LinkedList<>();
        parent = new int[numberOfVertices];
        visited = new boolean[numberOfVertices];
    }

    public boolean bfs(int source, int goal, int[][] residualGraph) {
        Arrays.fill(visited, false);
        queue.clear();
        queue.add(source);
        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next = 0; next < numberOfVertices; next++) {
                if (!visited[next] && residualGraph[current][next] > 0) {
                    queue.add(next);
                    parent[next] = current;
                    visited[next] = true;
                }
            }
        }

        return visited[goal];
    }

    public int fordFulkerson(int[][] graph, int source, int goal) {
        int u, v;
        int maxFlow = 0;
        int[][] residualGraph = new int[numberOfVertices][numberOfVertices];

        for (u = 0; u < numberOfVertices; u++) {
            for (v = 0; v < numberOfVertices; v++) {
                residualGraph[u][v] = graph[u][v];
            }
        }

        while (bfs(source, goal, residualGraph)) {
            int pathFlow = Integer.MAX_VALUE;

            for (v = goal; v != source; v = parent[v]) {
                u = parent[v];
                pathFlow = Math.min(pathFlow, residualGraph[u][v]);
            }

            for (v = goal; v != source; v = parent[v]) {
                u = parent[v];
                residualGraph[u][v] -= pathFlow;
                residualGraph[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
