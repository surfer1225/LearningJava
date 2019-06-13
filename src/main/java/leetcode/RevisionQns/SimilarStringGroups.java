package main.java.leetcode.RevisionQns;

/*
839. Similar String Groups

Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y.

For example, "tars" and "rats" are similar (swapping at positions 0 and 2),
and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".

Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.
Notice that "tars" and "arts" are in the same group even though they are not similar.
Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.

We are given a list A of strings. Every string in A is an anagram of every other string in A. How many groups are there?

Example 1:
 */
public class SimilarStringGroups {

    // track size of each component
    int[] componentSize;

    // keep track of the roots of each item
    int[] roots;

    private int numComponents;
    private int size;

    public int numSimilarGroups(String[] A) {
       this.size = numComponents = A.length;

       componentSize = new int[numComponents];
       roots = new int[size];

       for (int i=0;i<size;++i) roots[i]=i;

       for (int i=0;i<size-1;++i) {
           for (int j=i+1;j<size;++j) {
               if (isSimilar(A[i],A[j])) unify(i,j);
           }
       }
       return numComponents;
    }

    private void unify(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot==qRoot) return;

        if (componentSize[pRoot] < componentSize[qRoot]) {
            componentSize[qRoot] += componentSize[pRoot];
            roots[pRoot] = roots[qRoot];
        }
        else {
            componentSize[pRoot] += componentSize[qRoot];
            roots[qRoot] = pRoot;
        }

        --numComponents;
    }

    private int find(int i) {
        int root = i;
        while (roots[root]!=root) root = roots[root];

        while (i!=root) {
            int next = roots[i];
            roots[i] = root;
            i = next;
        }
        return root;
    }

    /**
     *
     * @param a: root string
     * @param b: anagram of a
     * @return
     */
    private boolean isSimilar(String a, String b) {
        if (a.equals(b)) return true;

        int cnt = 0;
        for (int i=0;i<a.length();++i) {
            if (a.charAt(i)!=b.charAt(i)) cnt++;
        }
        return cnt==2;
    }

    public static void main(String[] args) {
        SimilarStringGroups s = new SimilarStringGroups();
        System.out.println(s.numSimilarGroups(new String[]{
                "qihcochwmglyiggvsqqfgjjxu","gcgqxiysqfqugmjgwclhjhovi","gjhoggxvcqlcsyifmqgqujwhi",
                "wqoijxciuqlyghcvjhgsqfmgg","qshcoghwmglygqgviiqfjcjxu","jgcxqfqhuyimjglgihvcqsgow",
                "qshcoghwmggylqgviiqfjcjxu","wcoijxqiuqlyghcvjhgsqgmgf","qshcoghwmglyiqgvigqfjcjxu",
                "qgsjggjuiyihlqcxfovchqmwg","wcoijxjiuqlyghcvqhgsqgmgf","sijgumvhqwqioclcggxgyhfjq",
                "lhogcgfqqihjuqsyicxgwmvgj","ijhoggxvcqlcsygfmqgqujwhi","qshcojhwmglyiqgvigqfgcjxu",
                "wcoijxqiuqlyghcvjhgsqfmgg","qshcojhwmglyiggviqqfgcjxu","lhogcgqqfihjuqsyicxgwmvgj",
                "xscjjyfiuglqigmgqwqghcvho","lhggcgfqqihjuqsyicxgwmvoj","lhgocgfqqihjuqsyicxgwmvgj",
                "qihcojhwmglyiggvsqqfgcjxu","ojjycmqshgglwicfqguxvihgq","sijvumghqwqioclcggxgyhfjq",
                "gglhhifwvqgqcoyumcgjjisqx"}));
    }
}
