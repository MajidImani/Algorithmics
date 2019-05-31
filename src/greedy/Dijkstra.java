package greedy;

public class Dijkstra extends AbstractDijkstra {

    private final double MAX_Double = Double.MAX_VALUE;

    @Override
    public void solve() {
        for (int i = 0; i < numberOfVertices; i++) {
            distance[i] = MAX_Double;
            shortestPath[i] = false;
        }
        distance[source] = 0;

        for (int count = 0; count < numberOfVertices - 1; count++) {
            int u = minDistance();
            shortestPath[u] = true;

            for (int v = 0; v < numberOfVertices; v++) {
                if (!shortestPath[v] && graph[u][v] != 0 && distance[u] != MAX_Double && distance[u] + graph[u][v] < distance[v]) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }
        
        print();
    }

    private int minDistance() {
        int minIndex = -1;
        double minValue = MAX_Double;

        for (int v = 0; v < numberOfVertices; v++) {
            if (shortestPath[v] == false && distance[v] <= minValue) {
                minValue = distance[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    void print() {
        for (int i = 0; i < numberOfVertices; i++) {
            System.out.println(i + " --> " + distance[i]);
        }
    }

}
