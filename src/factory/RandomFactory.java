package factory;

import java.util.Random;

public class RandomFactory implements IRandomFactory
{
    @Override
    public Random CreateRandomInstance() {        
        return new Random(System.currentTimeMillis());
    }
    
}
