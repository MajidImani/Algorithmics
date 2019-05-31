package sample;

import factory.IMatrixManipulatorFactory;
import factory.MatrixManipulatorFactorty;
import matrix.IMatrixManipulator;

public class MatrixManipulatorSample {

    public static void main(String[] args) {
        MatrixManipulatorSample sample = new MatrixManipulatorSample();
        sample.testMatrixManipulatorAdd();
        sample.testMatrixManipulatorSubtract();
    }

    public void testMatrixManipulatorAdd() {
        IMatrixManipulatorFactory manipulatorFactorty = new MatrixManipulatorFactorty();
        IMatrixManipulator manipulator = manipulatorFactorty.createMatrixManipulatorInstance();
        double[][] first = manipulator.generateRandomMatrix(4, 4, 20);
        manipulator.print(first);
        double[][] second = manipulator.generateRandomMatrix(4, 4, 20);
        manipulator.print(second);
        double[][] result = manipulator.add(first, second);
        manipulator.print(result);
    }

    public void testMatrixManipulatorSubtract() {
        IMatrixManipulatorFactory manipulatorFactorty = new MatrixManipulatorFactorty();
        IMatrixManipulator manipulator = manipulatorFactorty.createMatrixManipulatorInstance();
        double[][] first = manipulator.generateRandomMatrix(4, 4, 20);
        manipulator.print(first);
        double[][] second = manipulator.generateRandomMatrix(4, 4, 20);
        manipulator.print(second);
        double[][] result = manipulator.subtract(first, second);
        manipulator.print(result);
    }
}
