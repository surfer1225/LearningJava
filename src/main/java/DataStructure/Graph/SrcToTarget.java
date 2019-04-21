package main.java.DataStructure.Graph;

import java.util.LinkedList;
import java.util.List;

/*
797. All Paths From Source to Target

Given a directed, acyclic graph of N nodes.
Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.
graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:
Input: [[1,2], [3], [3], []]
Output: [[0,1,3],[0,2,3]]
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 */
public class SrcToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new LinkedList<>();
        if (graph==null || graph.length==0 || graph[0].length==0) return res;
        for (int i=0;i<graph.length;++i) {
            DFS(graph, i, res);
        }
        return res;
    }

    private void DFS(int[][] graph, int s, List<List<Integer>> acc) {
        DFSHelper(graph,s,acc,new LinkedList<>());
    }

    private void DFSHelper(int[][] graph, int s, List<List<Integer>> acc, List<Integer> cur) {
        cur.add(s);
        if (graph[s].length==0) acc.add(cur);
        else {
            for (int i=0;i<graph[s].length;i++) {
                DFSHelper(graph, graph[s][i], acc, new LinkedList<>(cur));
            }
        }
    }
}
