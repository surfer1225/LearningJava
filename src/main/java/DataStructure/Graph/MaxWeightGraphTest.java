package main.java.DataStructure.Graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxWeightGraphTest {
    public static void main(String[] args) {
        MaxWeightGraph m = new MaxWeightGraph();

        Node A = new Node("A", 8);
        Node B = new Node("B", 1);
        Node C = new Node("C", 4);
        Node E = new Node("E", 3);
        Node F = new Node("F", 5);
        Node G = new Node("G", 2);
        Set<Node> nodes = new HashSet<>(Arrays.asList(A, B, C, E, F, G));
        Set<Edge> edges = new HashSet<>(Arrays.asList(
                new Edge(A, B), new Edge(B, C), new Edge(A, E),
                new Edge(B, E), new Edge(C, F), new Edge(E, F),
                new Edge(E, G), new Edge(G, F)
                ));

        try {
            System.out.println(m.maxWeightPath(nodes, edges, B));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
