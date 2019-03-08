package main.java.DataStructure.Graph;

import java.util.HashSet;
import java.util.Set;

class Node {
    String name;
    Set<Node> children;
    int val;

    private Node() {}

    Node(String name, int val) {
        this.name = name;
        this.val = val;
        this.children = new HashSet<>();
    }

    @Override
    public int hashCode() { return name.hashCode(); }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Node)) return false;
        Node node = (Node) obj;
        return this.name.equals(node.name);
    }
}

