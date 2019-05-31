package factory;

import dynamicprogramming.AbstractMatrixChainMultiply;
import dynamicprogramming.MatrixChainMultiply;

public class MatrixChainMultiplyFactory implements IMatrixChainMultiplyFactory {

    @Override
    public AbstractMatrixChainMultiply CreateMatrixChainMultiplyInstance() {
        return new MatrixChainMultiply();
    }
    
}
