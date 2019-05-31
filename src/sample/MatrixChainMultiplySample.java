package sample;

import dynamicprogramming.AbstractMatrixChainMultiply;
import factory.IMatrixChainMultiplyFactory;
import factory.IMatrixManipulatorFactory;
import factory.MatrixChainMultiplyFactory;
import factory.MatrixManipulatorFactorty;
import matrix.IMatrixManipulator;

public class MatrixChainMultiplySample {

    public static void main(String[] args) {
        MatrixChainMultiplySample sample = new MatrixChainMultiplySample();
        sample.testSolve();
    }

    public void testSolve() {
        IMatrixChainMultiplyFactory tspFactorty = new MatrixChainMultiplyFactory();
        IMatrixManipulatorFactory matrixManipulatorFactory = new MatrixManipulatorFactorty();
        IMatrixManipulator manipulator = matrixManipulatorFactory.createMatrixManipulatorInstance();
        double[] p = new double[]{30, 35, 15, 5, 10, 20, 25};
        AbstractMatrixChainMultiply matrixChainMultiply = tspFactorty.CreateMatrixChainMultiplyInstance();
        matrixChainMultiply.define(p);
        matrixChainMultiply.solve();        
        System.out.println();
    }
}
