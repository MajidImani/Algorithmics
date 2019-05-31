package dynamicprogramming;

import factory.IMatrixManipulatorFactory;
import factory.MatrixManipulatorFactorty;
import matrix.IMatrixManipulator;

public class MatrixChainMultiply extends AbstractMatrixChainMultiply {

    public MatrixChainMultiply() {
    }

    @Override
    public void solve() {
        matrixChainOrder();
        print(cost);
        print(path);
        printOptimalParens(1, numberOfMatrices);
    }

    private void matrixChainOrder() {
        path = new double[numberOfMatrices][numberOfMatrices + 1]; // S
        cost = new double[numberOfMatrices + 1][numberOfMatrices + 1]; // M
        for (int i = 1; i < numberOfMatrices + 1; i++) {
            cost[i][i] = 0;
        }
        for (int l = 2; l < numberOfMatrices + 1; l++) {
            for (int i = 1; i < (numberOfMatrices + 1) - l + 1; i++) {
                int j = i + l - 1;
                cost[i][j] = Double.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    double q = cost[i][k] + cost[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < cost[i][j]) {
                        cost[i][j] = q;
                        path[i][j] = k;
                    }
                }
            }
        }
    }

    private void printOptimalParens(int i, int j) {
        if (i == j) {
            System.out.print("A" + i + " ");
        } else {
            System.out.print("(");
            printOptimalParens(i, (int) path[i][j]);
            printOptimalParens((int) path[i][j] + 1, j);
            System.out.print(")");
        }
    }

    private void print(double[][] matrix) {
        IMatrixManipulatorFactory manipulatorFactory = new MatrixManipulatorFactorty();
        IMatrixManipulator manipulator = manipulatorFactory.createMatrixManipulatorInstance();
        manipulator.print(matrix);
    }
}
