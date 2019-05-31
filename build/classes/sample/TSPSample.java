package sample;

import dynamicprogramming.ITSP;
import factory.IMatrixManipulatorFactory;
import factory.ITSPFactory;
import factory.MatrixManipulatorFactorty;
import factory.TSPFactory;
import matrix.IMatrixManipulator;

public class TSPSample {

    public static void main(String[] args) {
        TSPSample sample = new TSPSample();
        sample.testSolve();
    }

    public void testSolve() {
        ITSPFactory tspFactorty = new TSPFactory();
        IMatrixManipulatorFactory matrixManipulatorFactory = new MatrixManipulatorFactorty();
        IMatrixManipulator manipulator = matrixManipulatorFactory.createMatrixManipulatorInstance();        
        ITSP tsp = tspFactorty.CreateTSPInstance(manipulator.generateRandomMatrix(3, 3, 20));                
        tsp.solve();
    }
}
