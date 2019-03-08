package main.java.DataStructure.Tree;

/**
 * Created by Ryan on 28/1/18.
 */

public class PopulateTreeRight {
    public class Node
    {
        public Node[] Children;
        public Node Right;
    }

    public void connectRight(Node root) {
        if(root == null) return;
        Node[] children = root.Children;

        Node cur = root;
        while(cur != null){
            if (children.length>1) {
                for (int i=1;i<children.length;i++) {
                    children[i-1].Right=children[i];
                }
            }
            children[children.length-1].Right = getNext(cur);
            cur = cur.Right;
        }

        for (int i=0;i<children.length;i++)
            connectRight(children[i]);
    }

    private Node getNext(Node root){
        Node temp = root.Right;
        while(temp != null){
            if (temp.Children.length>0) return temp.Children[0];
            temp = temp.Right;
        }
        return null;
    }
}
