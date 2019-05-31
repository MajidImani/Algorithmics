package factory;

import devideconquer.AbstractStrassen;
import devideconquer.Strassen;

public class StrassenFactory implements IStrassenFactory{

    @Override
    public AbstractStrassen CreateStrassenInstance() {
        return new Strassen(new MatrixManipulatorFactorty());
    }
    
}
