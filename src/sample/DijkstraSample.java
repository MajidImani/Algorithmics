package sample;

import factory.DijkstraFactory;
import factory.IDijkstraFactory;
import factory.IMatrixManipulatorFactory;
import factory.MatrixManipulatorFactorty;
import greedy.AbstractDijkstra;
import matrix.IMatrixManipulator;

public class DijkstraSample {

    public static void main(String[] args) {
        DijkstraSample sample = new DijkstraSample();
        sample.testSolve();
    }

    public void testSolve() {
        IDijkstraFactory dijkstraFactory = new DijkstraFactory();
        IMatrixManipulatorFactory matrixManipulatorFactory = new MatrixManipulatorFactorty();
        IMatrixManipulator manipulator = matrixManipulatorFactory.createMatrixManipulatorInstance();
        AbstractDijkstra dijkstra = dijkstraFactory.CreateDijkstraInstance();
        double[][] graph = manipulator.generateRandomMatrix(5, 5, 20);
        manipulator.print(graph);
        dijkstra.define(graph, 0);
        dijkstra.solve();
    }
}
