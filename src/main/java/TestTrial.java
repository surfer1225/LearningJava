package main.java;

import java.util.HashMap;
import java.util.Map;

public class TestTrial {
    public static void main(String[] args) {
        System.out.println('9'-'0');
        System.out.println(" 1 2   3 ".replaceAll("\\s+",""));

        Map<Character, Integer> m = new HashMap<>();
        m.put('a',1);
        m.put('b',2);

        Map<Character, Integer> copy = new HashMap<>(m);
        System.out.println(copy.get('a'));
        copy.put('a',2);
        System.out.println(m.get('a'));
    }
}
