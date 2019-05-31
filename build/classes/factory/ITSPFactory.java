package factory;

import dynamicprogramming.ITSP;

public interface ITSPFactory {

    public ITSP CreateTSPInstance(double[][] adjacencyMatrix);

    public ITSP CreateTSPInstance();
}
