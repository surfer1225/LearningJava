package main.java.DataStructure.Tree;

public class BinaryTreeFromArr {

    private static int countBranch(int[] arr) {
        TreeNode root = treeFromArr(arr, 0);
        inOrder(root);
        return 1;
    }

    private static void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.println("value: " + node.val);
        inOrder(node.right);
    }

    private static TreeNode treeFromArr(int[] arr, int i) {

        if (i > arr.length - 1) return null;
        TreeNode node = new TreeNode(arr[i]);

        if (i + 1 < arr.length) {
            if (arr[i + 1] >= arr[i]) node.right = treeFromArr(arr, i + 1);
            else node.left = treeFromArr(arr, i + 1);
        }
        return node;
    }

    public static void main(String[] args) {
        System.out.println(countBranch(new int[]{2, 1, 4, 3, 5}));
    }
}


