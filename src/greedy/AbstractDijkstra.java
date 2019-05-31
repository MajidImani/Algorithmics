package greedy;

import problem.IDijkstraProblem;
import problem.ISolution;

public abstract class AbstractDijkstra implements IDijkstraProblem, ISolution {

    protected int numberOfVertices;
    protected double[][] graph;
    protected int source;
    protected double[] distance;
    protected boolean[] shortestPath;

    @Override
    public void define(double[][] graph, int source) {
        this.graph = graph;
        this.numberOfVertices = this.graph.length;
        this.distance = new double[numberOfVertices];
        this.shortestPath = new boolean[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            this.graph[i][i] = 0;
        }
    }

    @Override
    public abstract void solve();

}
