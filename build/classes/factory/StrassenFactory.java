package factory;

import devideconquer.IStrassen;
import devideconquer.Strassen;

public class StrassenFactory implements IStrassenFactory{

    @Override
    public IStrassen CreateStrassenInstance() {
        return new Strassen(new MatrixManipulatorFactorty());
    }
    
}
