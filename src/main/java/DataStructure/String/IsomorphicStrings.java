package main.java.DataStructure.String;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ryan on 7/1/18.
 */

/*
iso if a string can be mapped to another with char 1-1 mapping
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> m = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            if (m.containsKey(s.charAt(i))) {
                if (!m.get(s.charAt(i)).equals(Character.valueOf(t.charAt(i))))
                    return false;
            }
            else {
                m.put(s.charAt(i), t.charAt(i));
            }
        }
        m.clear();
        for (int i=0;i<s.length();i++) {
            if (m.containsKey(t.charAt(i))) {
                if (!m.get(t.charAt(i)).equals(Character.valueOf(s.charAt(i))))
                    return false;
            }
            else {
                m.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }
}
