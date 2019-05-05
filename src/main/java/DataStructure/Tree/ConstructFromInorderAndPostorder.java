package main.java.DataStructure.Tree;

import java.util.HashMap;
import java.util.Map;

/*

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */
public class ConstructFromInorderAndPostorder {
    int end;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder==null || postorder.length==0) return null;
        end = postorder.length-1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<inorder.length;i++) {
            map.put(inorder[i],i);
        }
        return buildTree(inorder,postorder,0,end,map);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int low, int high, Map<Integer, Integer> map) {
        if (low>high || end<0) return null;

        int index = map.get(postorder[end]);

        TreeNode node = new TreeNode(inorder[index]);
        end--;

        node.right = buildTree(inorder,postorder,index+1,high,map);
        node.left = buildTree(inorder,postorder,low,index-1,map);

        return node;
    }
}
