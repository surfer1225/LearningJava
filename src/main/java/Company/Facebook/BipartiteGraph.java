package main.java.Company.Facebook;

/*
785. Is Graph Bipartite?

Given an undirected graph, return true if and only if it is bipartite.

Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B
such that every edge in the graph has one node in A and another node in B.

The graph is given in the following form: graph[i] is a list of indexes j
for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.
There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.

Example 1:
Input: [[1,3], [0,2], [1,3], [0,2]]
Output: true
Explanation:
The graph looks like this:
0----1
|    |
|    |
3----2
We can divide the vertices into two groups: {0, 2} and {1, 3}.

Example 2:
Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
Output: false
Explanation:
The graph looks like this:
0----1
| \  |
|  \ |
3----2
We cannot find a way to divide the set of nodes into two independent subsets.
 */

import java.util.HashSet;
import java.util.Set;

public class BipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        Set<Integer> left = new HashSet<>();
        Set<Integer> right = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        boolean[] res = new boolean[]{true};
        for (int i=0;i<graph.length;i++) {
            dfs(i, left, right, visited, -1, res, graph);
        }
        return res[0];
    }

    /**
     *
     * @param start: dfs starting index
     * @param left: left set
     * @param right: right set
     * @param visited: visited indices
     * @param side: side this start index to be added to
     * @param res: current result
     */
    private void dfs(int start, Set<Integer> left, Set<Integer> right, Set<Integer> visited,
                     int side, boolean[] res, int[][] graph) {
        if (!res[0]) return; // a invalid case found
        if (visited.contains(start)) {
            if (side == -1) return;
            if ((side == 0 && right.contains(start)) || (side == 1 && left.contains(start))) {
                res[0] = false;
            }
            return;
        }

        side = side==-1?0:side;

        visited.add(start);
        if (side == 0) left.add(start);
        else right.add(start);

        for (int i:graph[start]) {
            dfs(i,left,right,visited,(side+1)%2,res,graph);
        }
    }
}
