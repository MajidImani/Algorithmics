package factory;

import greedy.AbstractDijkstra;
import greedy.Dijkstra;

public class DijkstraFactory implements IDijkstraFactory {

    @Override
    public AbstractDijkstra CreateDijkstraInstance() {
        return new Dijkstra();
    }
}
