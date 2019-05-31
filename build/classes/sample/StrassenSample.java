package sample;

import devideconquer.IStrassen;
import factory.IMatrixManipulatorFactory;
import factory.IStrassenFactory;
import factory.MatrixManipulatorFactorty;
import factory.StrassenFactory;
import matrix.IMatrixManipulator;

public class StrassenSample {

    public static void main(String[] args) {
        StrassenSample sample = new StrassenSample();
        sample.testStrassenMultiply();
        //sample.testStrassenDevide();
        //sample.testStrassenConquer();
    }

    public void testStrassenMultiply() {
        IMatrixManipulatorFactory manipulatorFactorty = new MatrixManipulatorFactorty();
        IMatrixManipulator manipulator = manipulatorFactorty.createMatrixManipulatorInstance();
        double first[][] = manipulator.generateRandomMatrix(8, 8, 20);
        manipulator.print(first);
        double second[][] = manipulator.generateRandomMatrix(8, 8, 20);
        manipulator.print(second);

        IStrassenFactory strassenFactory = new StrassenFactory();
        IStrassen strassen = strassenFactory.CreateStrassenInstance();
        double[][] strassenResult = strassen.strassenMultiply(first, second);
        manipulator.print(strassenResult);
        double[][] manipulatorResult = manipulator.multiply(first, second);
        manipulator.print(manipulatorResult);        
    }

    public void testStrassenDevide() {
        IMatrixManipulatorFactory manipulatorFactorty = new MatrixManipulatorFactorty();
        IMatrixManipulator manipulator = manipulatorFactorty.createMatrixManipulatorInstance();
        double matrix[][] = manipulator.generateRandomMatrix(4, 4, 20);
        manipulator.print(matrix);

        IStrassenFactory strassenFactory = new StrassenFactory();
        IStrassen strassen = strassenFactory.CreateStrassenInstance();
        double[][] matrix11 = strassen.devide(matrix, 1, 1);
        double[][] matrix12 = strassen.devide(matrix, 1, 2);
        double[][] matrix21 = strassen.devide(matrix, 2, 1);
        double[][] matrix22 = strassen.devide(matrix, 2, 2);
        manipulator.print(matrix11);
        manipulator.print(matrix12);
        manipulator.print(matrix21);
        manipulator.print(matrix22);
    }

    public void testStrassenConquer() {
        IMatrixManipulatorFactory manipulatorFactorty = new MatrixManipulatorFactorty();
        IMatrixManipulator manipulator = manipulatorFactorty.createMatrixManipulatorInstance();
        double matrix[][] = manipulator.generateRandomMatrix(4, 4, 20);
        manipulator.print(matrix);

        IStrassenFactory strassenFactory = new StrassenFactory();
        IStrassen strassen = strassenFactory.CreateStrassenInstance();
        double[][] matrix11 = strassen.devide(matrix, 1, 1);
        double[][] matrix12 = strassen.devide(matrix, 1, 2);
        double[][] matrix21 = strassen.devide(matrix, 2, 1);
        double[][] matrix22 = strassen.devide(matrix, 2, 2);

        double result[][] = new double[4][4];
        manipulator.print(result);
        strassen.conquer(matrix11, result, 1, 1);
        manipulator.print(result);
        strassen.conquer(matrix12, result, 1, 2);
        manipulator.print(result);
        strassen.conquer(matrix21, result, 2, 1);
        manipulator.print(result);
        strassen.conquer(matrix22, result, 2, 2);
        manipulator.print(result);
    }
}
