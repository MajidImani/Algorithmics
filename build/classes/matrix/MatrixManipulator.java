package matrix;

import factory.IRandomFactory;
import java.util.Random;

public class MatrixManipulator implements IMatrixManipulator{

    private final Random random;

    public MatrixManipulator(IRandomFactory factory) {
        this.random = factory.CreateRandomInstance();
    }

    @Override
    public double[][] generateRandomMatrix(int numOfRows, int numOfCols, int bound) {
        double[][] matrix = new double[numOfRows][numOfCols];
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                matrix[i][j] = random.nextInt(bound);                
            }
        }
        return matrix;
    }

    @Override
    public void print(double[][] a) {
        int numOfRows = a.length;
        int numOfCols = a[0].length;        
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }     
        System.out.println();
    }

    @Override
    public double[][] add(double[][] first, double[][] second) {
        int numOfRows = first.length;
        int numOfCols = first[0].length;
        double[][] result = new double[numOfRows][numOfCols];
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                result[i][j] = first[i][j] + second[i][j];
            }
        }
        return result;
    }

    @Override
    public double[][] subtract(double[][] first, double[][] second) {
        int numOfRows = first.length;
        int numOfCols = first[0].length;
        double[][] result = new double[numOfRows][numOfCols];
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                result[i][j] = first[i][j] - second[i][j];
            }
        }
        return result;
    }
    
    @Override
    public double[][] multiply(double[][] first, double[][] second) {
        int firstNumOfRows = first.length;
        int firstNumOfCols = first[0].length;
        int socondNumOfRows = second.length;
        int secondNumOfCols = second[0].length;
        if (firstNumOfCols != socondNumOfRows) {
            throw new RuntimeException("Illegal matrix dimensions.");
        }
        double[][] result = new double[firstNumOfRows][secondNumOfCols];
        for (int i = 0; i < firstNumOfRows; i++) {
            for (int j = 0; j < secondNumOfCols; j++) {
                for (int k = 0; k < firstNumOfCols; k++) {
                    result[i][j] += first[i][k] * second[k][j];
                }
            }
        }
        return result;
    }
    
}
