package factory;

import dynamicprogramming.AbstractTSP;
import dynamicprogramming.TSP;

public class TSPFactory implements ITSPFactory{
    
    @Override
    public AbstractTSP CreateTSPInstance() {
        return new TSP();
    }
}
