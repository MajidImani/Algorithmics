package problem;

import java.util.ArrayList;
import type.Edge;
import type.Vertex;

public interface IKruskalProblem extends IProblem {

    public void define(ArrayList<Vertex> vertices, ArrayList<Edge> edges);
}
