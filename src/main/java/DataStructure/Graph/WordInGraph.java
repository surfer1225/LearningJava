package main.java.DataStructure.Graph;

import java.util.Arrays;

/*
Given a grid with every cell filled with a letter in the range ‘a’-‘z’,
find the number of occurrence of a given word by joining cells in the grid,
there should be no cycle / reusing letters for the found paths.

No diagonal

What if the grid is very big but the word is relatively small (1mil * 1mil grid, 1k length word)
 */
public class WordInGraph {

    // can consider multi-threading or map reduce if graph is too big

    int cnt = 0;

    public int countWordInGraph(char[][] graph, String word) {
        int l=graph.length, w=graph[0].length;

        for (int i=0;i<l;++i) {
            for (int j=0;j<w;++j) {
                dfsCheck(graph,i,j,l,w,0,word);
            }
        }

        return cnt;
    }

    private void dfsCheck(char[][] graph, int i, int j, int l, int w, int index, String word) {
        if (i<0 || i>=l || j<0 || j>=w || index>=word.length() || graph[i][j]!=word.charAt(index)) return;
        if (index==word.length()-1 && graph[i][j]==word.charAt(index)) {
            cnt++;
            return;
        }

        dfsCheck(graph,i+1,j,l,w,index+1,word);
        dfsCheck(graph,i,j+1,l,w,index+1,word);
        dfsCheck(graph,i-1,j,l,w,index+1,word);
        dfsCheck(graph,i,j-1,l,w,index+1,word);
    }

    public static void main(String[] args) {
        WordInGraph w = new WordInGraph();

        System.out.println(w.countWordInGraph(new char[][]{
                {'t','n','a','z','c'},
                {'m','n','f','z','y'},
                {'a','c','c','a','b'},
                {'t','d','t','t','x'},
                {'a','c','a','t','w'},
        }, "cat"));
    }
}
