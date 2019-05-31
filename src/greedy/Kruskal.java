package greedy;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import type.Edge;
import type.Vertex;
import type.WeightComparator;

public class Kruskal extends AbstractKruskal {

    @Override
    public void solve() {
        for (int i = 0; i < vertices.size(); i++) {
            HashSet<Vertex> set = new HashSet<>();
            set.add(vertices.get(i));
            subsets.add(set);
        }
                
        Collections.sort(edges, new WeightComparator());
        for (int i = 0; i < edges.size(); i++) {
            Edge edg = edges.get(i);
            Vertex srcNode = vertices.get(edg.getSource());
            Vertex destNode = vertices.get(edg.getDestination());

            if (findVertex(srcNode) != findVertex(destNode)) {
                System.out.println(edg.getSource() + " --> " + edg.getDestination() + " == " + edg.getWeight());
                union(findVertex(srcNode), findVertex(destNode));
            }
        }
    }

    private void union(int i, int j) {
        HashSet<Vertex> aSet = subsets.get(i);
        HashSet<Vertex> bSet = subsets.get(j);
        Iterator<Vertex> iter = bSet.iterator();
        while (iter.hasNext()) {
            Vertex b = iter.next();
            aSet.add(b);
        }
        subsets.remove(j);

    }

    private int findVertex(Vertex node) {
        int number = -1;

        for (int i = 0; i < subsets.size(); i++) {
            HashSet<Vertex> set = subsets.get(i);
            Iterator<Vertex> iterator = set.iterator();
            while (iterator.hasNext()) {
                Vertex setnode = iterator.next();
                if (setnode.getNumber() == node.getNumber()) {
                    number = i;
                    return number;
                }

            }
        }
        return number;
    }

}
