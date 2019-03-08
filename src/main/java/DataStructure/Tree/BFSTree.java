package main.java.DataStructure.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ryan on 19/2/18.
 */
public class BFSTree {
    TreeNode tn;

    void printTreeBFS() {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(tn);

        while (!q.isEmpty()) {
            TreeNode tmp = q.poll();
            System.out.println(tmp.val);

            if (tmp.left!=null) {
                q.add(tmp.left);
            }
            if (tmp.right!=null) {
                q.add(tmp.right);
            }
        }
    }
}
