package main.java.Company.Facebook;

import java.util.*;

/*
269. Alien Dictionary

There is a new alien language which uses the latin alphabet.
However, the order among letters are unknown to you.
You receive a list of non-empty words from the dictionary,
where words are sorted lexicographically by the rules of this new language.
Derive the order of letters in this language.

Example 1:

Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

Output: "wertf"
Example 2:

Input:
[
  "z",
  "x"
]

Output: "zx"
Example 3:

Input:
[
  "z",
  "x",
  "z"
]

Output: ""

Explanation: The order is invalid, so return "".
Note:

You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
 */
public class AlienDictHard {
    //my solution
    /*
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";

        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        if (wordSet.size()==1) return words[0].substring(0,1);

        List<Integer>[] comparatorGraph = new LinkedList[26];
        for (int i=0;i<26;++i) comparatorGraph[i] = new LinkedList<>();
        Set<Integer> wordIndices = new HashSet<>();
        for (int i=1;i<words.length;++i) {
            int m=0,n=0;
            while (m<words[i-1].length() && n<words[i].length()) {
                char mChar = words[i-1].charAt(m++);
                char nChar = words[i].charAt(n++);
                if (mChar != nChar) {
                    wordIndices.add(mChar-'a');
                    wordIndices.add(nChar-'a');
                    comparatorGraph[mChar-'a'].add(nChar-'a');
                    break;
                }
            }
        }
        String[] res = new String[]{""};
        for (int start:wordIndices)
            dfs(comparatorGraph,start,res,String.valueOf((char) (start+'a')),wordIndices.size(),new HashSet<>());
        return res[0];
    }

    private void dfs(List<Integer>[] graph, int i, String[] res, String acc, int orderSize, Set<Character> visited) {
        if (!res[0].isEmpty()) return;
        if (visited.contains((char) (i+'a'))) return;
        visited.add((char) (i+'a'));

        if (graph[i].isEmpty()) {
            if (acc.length() == orderSize) res[0] = acc;
            return;
        } else {
            for (int n : graph[i]) {
                dfs(graph,n,res,acc+((char) (n+'a')),orderSize,visited);
            }
        }

        visited.remove((char) (i+'a'));
    }
*/

    public String alienOrder(String[] words) {

        HashMap<Character, List<Character>> map = buildGraph(words);
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        boolean[] visited = new boolean[26];
        boolean[] stk = new boolean[26];


        for (char key : map.keySet()) {

            if (visited[key - 'a']) continue;
            if (dfs(map, stack, key, visited, stk)) {
                return "";
            }

        }

        while (!stack.isEmpty()) {
            result.append(Character.toString(stack.pop()));
        }

        return result.toString();

    }


    private boolean dfs(HashMap<Character, List<Character>> map, Stack<Character> stack, char key, boolean[] visited, boolean[] stk) {


        int idxKey = key - 'a';

        if (stk[idxKey]) return true;
        if (visited[idxKey]) return false;

        visited[idxKey] = true;
        stk[idxKey] = true;

        List<Character> childrens = map.get(key);

        for (char children : childrens) {
            if (dfs(map, stack, children, visited, stk))
                return true;
        }

        stk[idxKey] = false;

        stack.push(key);

        return false;

    }

    private HashMap<Character, List<Character>> buildGraph(String[] words) {

        HashMap<Character, List<Character>> map = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray())
                map.putIfAbsent(c, new LinkedList<>());
        }

        for (int i = 1; i < words.length; ++i) {

            String current = words[i];
            String prev = words[i - 1];

            int length = Math.min(current.length(), prev.length());

            for (int k = 0; k < length; ++k) {
                if (current.charAt(k) == prev.charAt(k)) continue;
                else {
                    map.get(prev.charAt(k)).add(current.charAt(k));
                    break;
                }
            }
        }
        return map;
    }


    public static void main(String[] args) {
        AlienDictHard a = new AlienDictHard();
        System.out.println(a.alienOrder(new String[]{"wrt",
                "wrf",
                "er",
                "ett",
                "rftt"}));

        System.out.println(a.alienOrder(new String[]{"x", "z", "x"}));
        System.out.println(a.alienOrder(new String[]{"x", "x", "z"}));
        System.out.println(a.alienOrder(new String[]{"xyr", "xz"}));
        System.out.println(a.alienOrder(new String[]{"ac","ab","b"}));
    }
}
