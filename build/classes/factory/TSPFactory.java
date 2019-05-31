package factory;

import dynamicprogramming.ITSP;
import dynamicprogramming.TSP;

public class TSPFactory implements ITSPFactory{

    @Override
    public ITSP CreateTSPInstance(double[][] adjacencyMatrix) {
        return new TSP(adjacencyMatrix);
    }
    
    @Override
    public ITSP CreateTSPInstance() {
        return new TSP();
    }
}
