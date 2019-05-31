package sample;

import devideconquer.AbstractStrassen;
import factory.IMatrixManipulatorFactory;
import factory.IStrassenFactory;
import factory.MatrixManipulatorFactorty;
import factory.StrassenFactory;
import matrix.IMatrixManipulator;

public class StrassenSample {

    public static void main(String[] args) {
        StrassenSample sample = new StrassenSample();
        sample.testStrassenMultiply();
    }

    public void testStrassenMultiply() {
        IMatrixManipulatorFactory manipulatorFactorty = new MatrixManipulatorFactorty();
        IMatrixManipulator manipulator = manipulatorFactorty.createMatrixManipulatorInstance();
        double first[][] = manipulator.generateRandomMatrix(8, 8, 20);
        manipulator.print(first);
        double second[][] = manipulator.generateRandomMatrix(8, 8, 20);
        manipulator.print(second);

        IStrassenFactory strassenFactory = new StrassenFactory();
        AbstractStrassen strassen = strassenFactory.CreateStrassenInstance();
        strassen.define(first, second);
        strassen.solve();
        double[][] manipulatorResult = manipulator.multiply(first, second);
        manipulator.print(manipulatorResult);        
    }
    
}
