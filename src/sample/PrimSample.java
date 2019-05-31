package sample;

import factory.IMatrixManipulatorFactory;
import factory.IPrimFactory;
import factory.MatrixManipulatorFactorty;
import factory.PrimFactory;
import greedy.AbstractPrim;
import matrix.IMatrixManipulator;

public class PrimSample {
    
    public static void main(String[] args) {
        PrimSample sample = new PrimSample();
        sample.testSolve();
    }
    
    public void testSolve() {
        IPrimFactory primFactory = new PrimFactory();
        IMatrixManipulatorFactory matrixManipulatorFactory = new MatrixManipulatorFactorty();
        IMatrixManipulator manipulator = matrixManipulatorFactory.createMatrixManipulatorInstance();
        AbstractPrim prim = primFactory.CreatePrimInstance();
        double graph[][] = new double[][]{
            {0, 4, 0, 6},
            {4, 0, 5, 8},
            {0, 5, 0, 1},
            {6, 8, 1, 0}};
        manipulator.print(graph);
        prim.define(graph);
        prim.solve();
    }
}
