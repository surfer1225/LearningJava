package main.java.DataStructure.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InorderIterative {
    public List<Integer> inorderTraversal(TreeNode root) {

        if (root==null) return new LinkedList<>();

        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;

        while (cur!=null || !st.isEmpty()) {
            while (cur!=null) {
                st.push(cur);
                cur = cur.left;
            }

            TreeNode top = st.pop();
            list.add(top.val);
            cur = top.right;
        }

        return list;
    }
}
