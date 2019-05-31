package type;

import java.util.Comparator;

public class WeightComparator implements Comparator<Edge> {

    @Override
    public int compare(Edge e1, Edge e2) {
        return e1.getWeight() - e2.getWeight();
    }
}
