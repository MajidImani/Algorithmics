package greedy;

public class Prim extends AbstractPrim {

    private final double MAX_Double = Double.MAX_VALUE;

    @Override
    public void solve() {
        double[] key = new double[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            key[i] = MAX_Double;
            shortestPath[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < numberOfVertices - 1; count++) {
            int u = minimum(key);

            shortestPath[u] = true;

            for (int v = 0; v < numberOfVertices; v++) {
                if (graph[u][v] != 0 && !shortestPath[v]
                        && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        print();
    }

    private int minimum(double[] key) {
        double min = MAX_Double;
        int minIndex = -1;

        for (int v = 0; v < numberOfVertices; v++) {
            if (!shortestPath[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    private void print() {
        for (int i = 1; i < numberOfVertices; i++) {
            System.out.println(parent[i] + " --> " + i + " , " + graph[i][(int)parent[i]]);
        }
    }

}
