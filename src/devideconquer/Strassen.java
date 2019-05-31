package devideconquer;

import factory.IMatrixManipulatorFactory;
import matrix.IMatrixManipulator;

public class Strassen extends AbstractStrassen {

    IMatrixManipulator manipulator;

    public Strassen(IMatrixManipulatorFactory factory) {
        manipulator = factory.createMatrixManipulatorInstance();
    }

    @Override
    public void solve() {
        double[][] result = strassenMultiply(first, second);
        manipulator.print(result);
    }

    private double[][] strassenMultiply(double[][] first, double[][] second) {
        int n = first.length;
        if (!isPoweofTwo(n)) {
            System.out.println("Please use power two dimension arrays.");
            throw new RuntimeException("Illegal power of 2 dimensions.");
        }

        double[][] result = new double[n][n];
        //Base Case
        if (n == 1) {
            result[0][0] = first[0][0] * second[0][0];
            return result;
        }

        //Devide Pahse
        double[][] first11, first12, first21, first22;
        first11 = devide(first, 1, 1);
        first12 = devide(first, 1, 2);
        first21 = devide(first, 2, 1);
        first22 = devide(first, 2, 2);

        double[][] second11, second12, second21, second22;
        second11 = devide(second, 1, 1);
        second12 = devide(second, 1, 2);
        second21 = devide(second, 2, 1);
        second22 = devide(second, 2, 2);

        //Recursive Pahse
        double[][] M1 = strassenMultiply(manipulator.add(first11, first22), manipulator.add(second11, second22));
        double[][] M2 = strassenMultiply(manipulator.add(first21, first22), second11);
        double[][] M3 = strassenMultiply(first11, manipulator.subtract(second12, second22));
        double[][] M4 = strassenMultiply(first22, manipulator.subtract(second21, second11));
        double[][] M5 = strassenMultiply(manipulator.add(first11, first12), second22);
        double[][] M6 = strassenMultiply(manipulator.subtract(first21, first11), manipulator.add(second11, second12));
        double[][] M7 = strassenMultiply(manipulator.subtract(first12, first22), manipulator.add(second21, second22));

        //Conquer Pahse
        double[][] result11 = manipulator.add(manipulator.subtract(manipulator.add(M1, M4), M5), M7);
        double[][] result12 = manipulator.add(M3, M5);
        double[][] result21 = manipulator.add(M2, M4);
        double[][] result22 = manipulator.add(manipulator.add(manipulator.subtract(M1, M2), M3), M6);
        conquer(result11, result, 1, 1);
        conquer(result12, result, 1, 2);
        conquer(result21, result, 2, 1);
        conquer(result22, result, 2, 2);
        return result;
    }

    private double[][] devide(double[][] matrix, int row, int col) {
        int n = matrix.length;
        int numOfRows = (row == 1) ? n / 2 : (n - n / 2);
        int numOfCols = (col == 1) ? n / 2 : (n - n / 2);
        int rowIndex = (row == 1) ? 0 : n / 2;
        int colIndex;
        double[][] result = new double[numOfRows][numOfCols];
        for (int i = 0; i < numOfRows; i++) {
            colIndex = (col == 1) ? 0 : n / 2;
            for (int j = 0; j < numOfCols; j++) {
                result[i][j] = matrix[rowIndex][colIndex++];
            }
            rowIndex++;
        }
        return result;
    }

    private void conquer(double[][] matrix, double[][] result, int row, int col) {
        int n = result.length;
        int numOfRows = (row == 1) ? n / 2 : (n - n / 2);
        int numOfCols = (col == 1) ? n / 2 : (n - n / 2);
        int rowIndex = (row == 1) ? 0 : n / 2;
        int colIndex;
        for (int i = rowIndex; i < numOfRows + rowIndex; i++) {
            colIndex = (col == 1) ? 0 : n / 2;
            for (int j = colIndex; j < numOfCols + colIndex; j++) {
                result[i][j] = matrix[i - rowIndex][j - colIndex];
            }
        }
    }

    private boolean isPoweofTwo(int number) {
        return number > 0 && ((number & (number - 1)) == 0);
    }

}
