package dynamicprogramming;

import problem.IOneDMatrixProblem;
import problem.ISolution;

public abstract class AbstractMatrixChainMultiply implements IOneDMatrixProblem, ISolution {

    protected double [] p;
    protected double[][] path;
    protected double[][] cost;
    protected int numberOfMatrices;

    @Override
    public void define(double[] matrix) {
        this.p = matrix;
        numberOfMatrices = p.length - 1;
    }

    @Override
    public abstract void solve();
}
