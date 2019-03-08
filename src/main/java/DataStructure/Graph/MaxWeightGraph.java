package main.java.DataStructure.Graph;

import java.util.HashSet;
import java.util.Set;

public class MaxWeightGraph {
    private Set<Node> nodes = new HashSet<>();
    private Set<String> edges = new HashSet<>();
    private int maxWeight = 0;

    private void addEdge(Edge edge) throws Exception { addEdge(edge.src, edge.des); }
    private void addEdge(Node src, Node des) throws Exception {
        if (nodes.contains(src) && nodes.contains(des)) {
            if (edges.contains(des.name+','+src.name)) {
                throw new Exception("Cyclic reference is not allowed. "+des.name+" -> "+src.name+" already exists");
            }
            src.children.add(des);
            edges.add(src.name+','+des.name);
        }
        else {
            throw new Exception("nodes do not exist yet, please add the nodes first");
        }
    }

    public int maxWeightPath(Set<Node> inputNodes, Set<Edge> inputEdges, Node src) throws Exception {
        nodes.addAll(inputNodes);
        for (Edge e : inputEdges) addEdge(e);
        maxWeightHelper(src, 0);
        return maxWeight;
    }

    private void maxWeightHelper(Node n, int sum) {
        if (n.children.isEmpty()) {
            maxWeight = Math.max(maxWeight, sum+n.val);
            return;
        }
        n.children.forEach( node -> maxWeightHelper(node, sum+n.val) );
    }
}
