package greedy;

import problem.IPrimProblem;
import problem.ISolution;

public abstract class AbstractPrim implements IPrimProblem, ISolution {

    protected int numberOfVertices;
    protected double[][] graph;
    protected boolean[] shortestPath;
    protected double[] parent;

    @Override
    public void define(double[][] graph) {
        this.graph = graph;
        this.numberOfVertices = this.graph.length;
        this.parent = new double[numberOfVertices];
        this.shortestPath = new boolean[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            this.graph[i][i] = 0;
        }
    }

    @Override
    public abstract void solve();

}
