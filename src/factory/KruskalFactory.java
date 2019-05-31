package factory;

import greedy.AbstractKruskal;
import greedy.Kruskal;

public class KruskalFactory implements IKruskalFactory {

    @Override
    public AbstractKruskal CreateKruskalInstance() {
        return new Kruskal();
    }
    
}
