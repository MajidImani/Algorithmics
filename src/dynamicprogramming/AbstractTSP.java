package dynamicprogramming;

import problem.I2DMatrixProblem;
import problem.ISolution;

public abstract class AbstractTSP implements I2DMatrixProblem, ISolution {

    protected double[][] adjacencyMatrix;
    protected int numberOfVertices;
    protected double[][] cost;

    @Override
    public abstract void define(double[][] matrix);

    @Override
    public abstract void solve();

}
