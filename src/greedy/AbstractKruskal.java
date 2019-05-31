package greedy;

import java.util.ArrayList;
import java.util.HashSet;
import problem.IKruskalProblem;
import problem.ISolution;
import type.Edge;
import type.Vertex;

public abstract class AbstractKruskal implements IKruskalProblem, ISolution {

    protected ArrayList<Edge> edges;
    protected ArrayList<Vertex> vertices;
    protected ArrayList<HashSet<Vertex>> subsets;

    @Override
    public void define(ArrayList<Vertex> vertices, ArrayList<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
        this.subsets = new ArrayList<>();
    }

    @Override
    public abstract void solve();

}
