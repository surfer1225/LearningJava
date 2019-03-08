package main.java.Company.Facebook;
// print the right view of BST
/**
 * Created by Ryan on 3/7/17.
 */
public class RightViewOfTree {

    public static int currentLevel =0;
    public void rightViewRecur(Node root, int nextLevel){
        if (root == null) { return; }
        if (currentLevel < nextLevel) {
            System.out.println("Right node: " + root.data);
            currentLevel = nextLevel;
        }
        rightViewRecur(root.right, nextLevel + 1);
        rightViewRecur(root.left, nextLevel + 1);
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.right.left = new Node(30);
        root.right.right = new Node(35);
        root.left.right.right = new Node(45);

        RightViewOfTree i  = new RightViewOfTree();
        i.rightViewRecur(root,1);
    }
}
class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
        this.left = null;
        this.right =null;
    }
}
