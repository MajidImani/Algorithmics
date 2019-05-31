package devideconquer;

import problem.ISolution;
import problem.IStrassenProblem;

public abstract class AbstractStrassen implements IStrassenProblem, ISolution {

    protected double[][] first;
    protected double[][] second;
    protected int numberOfVertices;

    @Override
    public void define(double[][] first, double[][] second) {
        this.numberOfVertices = first.length;
        this.first = first;
        this.second = second;
    }

    @Override
    public abstract void solve();

}
