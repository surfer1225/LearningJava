package main.java.DataStructure.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreorderIterative {
    public List<Integer> preorderTraversal(TreeNode root) {

        if (root==null) return new LinkedList<>();

        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();

        st.push(root);

        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            list.add(node.val);
            if (node.right!=null) st.push(node.right);
            if (node.left!=null) st.push(node.left);
        }

        return list;
    }
}
