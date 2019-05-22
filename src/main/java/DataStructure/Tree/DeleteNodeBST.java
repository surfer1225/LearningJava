package main.java.DataStructure.Tree;

public class DeleteNodeBST {
    TreeNode parent = null;
    TreeNode target = null;
    boolean isLeft = false;

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val == key) {
            // process the deletion
            if (root.left == null) {
                root = root.right;
                return root;
            }
            if (root.right == null) {
                root = root.left;
                return root;
            }
            target = root;
            TreeNode newRoot = getLeftMax(root.left);
            newRoot.right = root.right;
            newRoot.left = root.left;
            return newRoot;
        }
        // case: not the root
        else {
            search(root, key);
            if (target == null) return root; //not found
            if (target.left == null) {
                if (isLeft) parent.left = target.right;
                else parent.right = target.right;
            }
            else if (target.right == null) {
                if (isLeft) parent.left = target.left;
                else parent.right = target.left;
            }
            else {
                TreeNode leftMax = getLeftMax(target.left);
                if (isLeft) parent.left = leftMax;
                else parent.right = leftMax;
                leftMax.right = target.right;
                leftMax.left = target.left;
            }
            return root;
        }
    }

    private TreeNode getLeftMax(TreeNode node) {
        TreeNode prev = target;
        while (node.right != null) {
            prev = node;
            node = node.right;
        }
        if (prev == target) {
            prev.left = node.left;
        }
        else prev.right = node.left;
        return node;
    }

    private void search(TreeNode node, int key) {
        if (node==null || (node.left==null && node.right==null) || target!=null) return; //target found or no target here

        if (node.left!=null && node.left.val==key) {
            target = node.left;
            parent = node;
            isLeft = true;
            return;
        }
        if (node.right!=null && node.right.val==key) {
            target = node.right;
            parent = node;
            isLeft = false;
            return;
        }
        search(node.left, key);
        search(node.right, key);
    }
}
