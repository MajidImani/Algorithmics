package factory;

import greedy.AbstractPrim;
import greedy.Prim;

public class PrimFactory implements IPrimFactory {

    @Override
    public AbstractPrim CreatePrimInstance() {
        return new Prim();
    }
}