package factory;

import dynamicprogramming.AbstractTSP;

public interface ITSPFactory {

    public AbstractTSP CreateTSPInstance();
}
