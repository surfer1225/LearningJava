package main.java.DataStructure.Tree;

import java.util.*;
import java.util.stream.Collectors;

/*
987. Vertical Order Traversal of a Binary Tree

Given a binary tree, return the vertical order traversal of its nodes values.

For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes,
we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.
 */

/*
class Solution {
    List<Location> locations;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Each location is a node's x position, y position, and value
        locations = new ArrayList();
        dfs(root, 0, 0);
        Collections.sort(locations);

        List<List<Integer>> ans = new ArrayList();
        ans.add(new ArrayList<Integer>());

        int prev = locations.get(0).x;

        for (Location loc: locations) {
            // If the x value changed, it's part of a new report.
            if (loc.x != prev) {
                prev = loc.x;
                ans.add(new ArrayList<Integer>());
            }

            // We always add the node's value to the latest report.
            ans.get(ans.size() - 1).add(loc.val);
        }

        return ans;
    }

    public void dfs(TreeNode node, int x, int y) {
        if (node != null) {
            locations.add(new Location(x, y, node.val));
            dfs(node.left, x-1, y+1);
            dfs(node.right, x+1, y+1);
        }
    }
}

class Location implements Comparable<Location>{
    int x, y, val;
    Location(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Location that) {
        if (this.x != that.x)
            return Integer.compare(this.x, that.x);
        else if (this.y != that.y)
            return Integer.compare(this.y, that.y);
        else
            return Integer.compare(this.val, that.val);
    }
}
 */
public class VerticalOrderTraversal {

    class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class DataHelper {
        int y;
        int val;

        public DataHelper(int y, int val) {
            this.y = y;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root==null) return result;

        Map<Integer, List<DataHelper>> positionMap = new HashMap<>();
        int[] minmax = new int[2];
        preorderTraverse(positionMap, root, minmax, new Position(0,0));

        for (int i=minmax[0];i<=minmax[1];++i) {
            if (positionMap.containsKey(i)) {
                List<DataHelper> dataHelperList = positionMap.get(i);
                Collections.sort(dataHelperList, (d1,d2) -> {
                    if (d1.y==d2.y) return d1.val - d2.val;
                    else return d1.y-d2.y;
                });
                result.add(dataHelperList.stream().map(d -> d.val).collect(Collectors.toList()));
            }
        }

        return result;
    }

    private void preorderTraverse(Map<Integer, List<DataHelper>> positionMap, TreeNode node, int[] minmax,
                                  Position position) {
        if (node==null) return;

        positionMap.computeIfAbsent(position.x,placeholder->new LinkedList<>()).
                add(new DataHelper(position.y,node.val));

        minmax[0] = Math.min(position.x,minmax[0]);
        minmax[1] = Math.max(position.x,minmax[1]);

        preorderTraverse(positionMap, node.left, minmax, new Position(position.x-1,position.y+1));
        preorderTraverse(positionMap, node.right, minmax, new Position(position.x+1, position.y+1));
    }
}
