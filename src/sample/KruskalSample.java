package sample;

import factory.IKruskalFactory;
import factory.IMatrixManipulatorFactory;
import factory.KruskalFactory;
import factory.MatrixManipulatorFactorty;
import greedy.AbstractKruskal;
import java.util.ArrayList;
import matrix.IMatrixManipulator;
import type.Edge;
import type.Vertex;

public class KruskalSample {

    public static void main(String[] args) {
        KruskalSample sample = new KruskalSample();
        sample.testSolve();
    }

    public void testSolve() {
        IKruskalFactory dijkstraFactory = new KruskalFactory();
        AbstractKruskal kruskal = dijkstraFactory.CreateKruskalInstance();
        ArrayList<Edge> edges = new ArrayList<>();
        ArrayList<Vertex> vertices = new ArrayList<>();
        vertices.add(new Vertex(0));
        vertices.add(new Vertex(1));
        vertices.add(new Vertex(2));
        vertices.add(new Vertex(3));
        vertices.add(new Vertex(4));
        vertices.add(new Vertex(5));

        edges.add(new Edge(0, 1, 3));
        edges.add(new Edge(0, 5, 1));
        edges.add(new Edge(1, 2, 2));
        edges.add(new Edge(2, 3, 1));
        edges.add(new Edge(2, 5, 3));
        edges.add(new Edge(3, 4, 2));
        edges.add(new Edge(4, 5, 1));

        kruskal.define(vertices, edges);
        kruskal.solve();
    }
}
