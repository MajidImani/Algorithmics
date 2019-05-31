package factory;

import matrix.IMatrixManipulator;
import matrix.MatrixManipulator;

public class MatrixManipulatorFactorty implements IMatrixManipulatorFactory{    
    
    @Override
    public IMatrixManipulator createMatrixManipulatorInstance() {
        return new MatrixManipulator(new RandomFactory());
    }
    
}
