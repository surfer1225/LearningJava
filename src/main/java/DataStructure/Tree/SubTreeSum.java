package main.java.DataStructure.Tree;

/**
 * Created by Ryan on 26/12/17.
 */

// number of subtrees whose values summing to a given value
public class SubTreeSum {
    int total=0;
    public int pathSum(TreeNode root, int sum) {
        pathSumHelper(root, sum);
        return total;
    }

    private int pathSumHelper(TreeNode cur, int sum) {
        if (cur==null) return 0;

        int left = pathSumHelper(cur.left, sum);
        if (left==sum) total++;
        int right = pathSumHelper(cur.right, sum);
        if (right==sum) total++;
        System.out.println("left, right, cur.val: "+left+", "+right+", "+cur.val);
        return (cur.val+left+right);
    }

    public static void main(String[] args) {
        TreeBuilder b = new TreeBuilder();
        SubTreeSum s = new SubTreeSum();
        System.out.println(s.pathSum(b.buildTree(), 8));
    }
}
