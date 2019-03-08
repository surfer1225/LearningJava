package main.java.DataStructure.Graph;

class Edge {
    Node src;
    Node des;

    private Edge() {}

    public Edge(Node src, Node des) {
        this.src = src;
        this.des = des;
    }
}

