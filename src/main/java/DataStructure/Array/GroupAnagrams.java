package main.java.DataStructure.Array;

import java.util.*;

/**
 * Created by Ryan on 31/12/17.
 */

/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
 */

public class GroupAnagrams {

    Map<String, List<String>> m = new HashMap<>();

    public List<List<String>> groupAnagrams(String[] strs) {
        for (String s:strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String tempStr = new String(temp);
            if (m.containsKey(tempStr)) m.get(tempStr).add(s);
            else {
                List<String> l = new LinkedList<>();
                l.add(s);
                m.put(tempStr, l);
            }
        }
        return new ArrayList<>(m.values());
    }
}
