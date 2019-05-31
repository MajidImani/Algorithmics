package sample;

import dynamicprogramming.AbstractTSP;
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
        AbstractTSP tsp = tspFactorty.CreateTSPInstance();                
        tsp.define(manipulator.generateRandomMatrix(4, 4, 20));
        tsp.solve();
    }
}
