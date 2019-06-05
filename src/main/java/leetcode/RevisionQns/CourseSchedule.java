package main.java.leetcode.RevisionQns;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
207. Course Schedule

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 */
public class CourseSchedule {

    //better solution
    /*
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        final List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        return !hasCycle(graph, numCourses);
    }

    private boolean hasCycle(final List<Integer>[] graph, int numCourses) {
        final boolean[] visited = new boolean[numCourses];
        final boolean[] onStack = new boolean[numCourses];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (hasCycle(i, graph, visited, onStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycle(int v, final List<Integer>[] graph, final boolean[] visited, final boolean[] onStack) {
        visited[v] = true;
        onStack[v] = true;
        boolean hasCycle = false;
        for (int w : graph[v]) {
            if (!visited[w]) {
                hasCycle = hasCycle(w, graph, visited, onStack);
                if (hasCycle) {
                    break;
                }
            } else if (onStack[w]) {
                hasCycle = true;
                break;
            }
        }
        onStack[v] = false;
        return hasCycle;
    }
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] courseGraph = new LinkedList[numCourses];
        for (int i=0;i<numCourses;++i) {
            courseGraph[i] = new LinkedList<>();
        }

        for (int[] prerequisite:prerequisites) {
            courseGraph[prerequisite[0]].add(prerequisite[1]);
        }

        for (int i=0;i<numCourses;++i) {
            Set<Integer> visited = new HashSet<>();
            if (!visited.contains(i) && dfsDetectCycle(courseGraph,i,visited,i)) return false;
        }

        return true;
    }

    private boolean dfsDetectCycle(List<Integer>[] courseGraph, int i, Set<Integer> visited, int initial) {
        visited.add(i);

        for (int n:courseGraph[i]) {
            if (n==initial) return true;
            if (visited.contains(n)) continue;
            if (dfsDetectCycle(courseGraph,n,visited,initial)) return true;
        }

        return false;
    }
}
