package main.java.Company.Facebook;

/*
Convert a BST to a sorted circular doubly-linked list in-place.
Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.

Let's take the following BST as an example, it may help you understand the problem better:

We want to transform this BST into a circular doubly linked list.
Each node in a doubly linked list has a predecessor and successor.
For a circular doubly linked list, the predecessor of the first element is the last element,
and the successor of the last element is the first element.

The figure below shows the circular doubly linked list for the BST above.
The "head" symbol means the node it points to is the smallest element of the linked list.
 */
public class BSTToSortedDoublyList {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    class HeadTail {
        Node head;
        Node tail;

        public HeadTail(Node head, Node tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public Node treeToDoublyList(Node root) {
        HeadTail res = treeToDoublyListHelper(root);
        if (res == null) return null;

        res.head.left = res.tail;
        res.tail.right = res.head;

        return res.head;
    }

    private HeadTail treeToDoublyListHelper(Node node) {
        if (node == null) return null;
        HeadTail left = treeToDoublyListHelper(node.left);
        HeadTail right = treeToDoublyListHelper(node.right);
        HeadTail res = new HeadTail(node, node);
        if (left != null) {
            res.head = left.head;
            left.tail.right = node;
            node.left = left.tail;
        }
        if (right != null) {
            res.tail = right.tail;
            node.right = right.head;
            right.head.left = node;
        }
        return res;
    }

    public static void main(String[] args) {

        BSTToSortedDoublyList b = new BSTToSortedDoublyList();
        Node root = b.new Node(2,
                b.new Node(1, null, null),
                b.new Node(3, null, null));
        Node res = b.treeToDoublyList(root);
        System.out.println(res.val);
    }
}
