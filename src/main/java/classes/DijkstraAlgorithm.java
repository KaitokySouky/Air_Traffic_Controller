package classes;

public class DijkstraAlgorithm {

    private static final int NO_PARENT = -1;

    // Fonction pour trouver le sommet avec la distance minimale,
    // à partir de l'ensemble des sommets qui ne sont pas encore inclus dans le plus court chemin
    private static int findMinDistance(int[] distances, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;

        for (int vertex = 0; vertex < distances.length; vertex++) {
            if (!visited[vertex] && distances[vertex] < minDistance) {
                minDistance = distances[vertex];
                minDistanceVertex = vertex;
            }
        }

        return minDistanceVertex;
    }

    // Fonction pour afficher le chemin le plus court à partir de la source vers le sommet donné
    private static void printPath(int[] parents, int destination) {
        if (parents[destination] == NO_PARENT) {
            System.out.println(destination);
            return;
        }

        printPath(parents, parents[destination]);
        System.out.println(destination);
    }

    // Fonction pour implémenter l'algorithme de Dijkstra pour un graphe représenté sous forme de matrice d'adjacence
    public static void dijkstra(int[][] graph, int source) {
        int vertexCount = graph.length;

        // distances[i] contient la distance la plus courte de la source au sommet i
        int[] distances = new int[vertexCount];

        // visited[i] sera vrai si le sommet i a déjà été inclus dans le plus court chemin
        boolean[] visited = new boolean[vertexCount];

        // parents[i] contiendra le prédécesseur du sommet i dans le plus court chemin de la source vers i
        int[] parents = new int[vertexCount];

        // Initialiser toutes les distances à l'infini, les sommets à false et les parents à NO_PARENT
        for (int i = 0; i < vertexCount; i++) {
            distances[i] = Integer.MAX_VALUE;
            visited[i] = false;
            parents[i] = NO_PARENT;
        }

        // La distance de la source à elle-même est toujours 0
        distances[source] = 0;

        // Calculer le plus court chemin pour tous les sommets
        for (int i = 0; i < vertexCount - 1; i++) {
            // Sélectionner le sommet non visité avec la distance minimale
            int currentVertex = findMinDistance(distances, visited);

            // Marquer le sommet comme visité
            visited[currentVertex] = true;

            // Mettre à jour les distances des sommets adjacents non visités
            for (int adjacentVertex = 0; adjacentVertex < vertexCount; adjacentVertex++) {
                int edgeDistance = graph[currentVertex][adjacentVertex];

                if (edgeDistance > 0 && !visited[adjacentVertex] && distances[currentVertex] + edgeDistance < distances[adjacentVertex]) {
                    distances[adjacentVertex] = distances[currentVertex] + edgeDistance;
                    parents[adjacentVertex] = currentVertex;
                }
            }
        }

        // Afficher les distances et les chemins les plus courts
        for (int i = 0; i < vertexCount; i++) {
            if (i != source) {
                System.out.print("Le chemin le plus court de " + source + " à " + i + " est :");}
            }
        }
    }

