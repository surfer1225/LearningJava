package main.java.BasicAlgo;

import java.util.HashMap;
import java.util.Map;

public class SeparatingWords {

    Map<String, Integer> dict = new HashMap<>();
    Map<String, Integer> score = new HashMap<>();

    public int getMaxScore(String str) {
        if (score.containsKey(str)) {
            return score.get(str);
        }
        int max = 0;
        int maxIndex = -1;
        for (int i = 1; i <= str.length(); i++) {
            int beginScore = getScore(str.substring(0, i));
            int remainingScore = getMaxScore(str.substring(i));
            if (beginScore + remainingScore > max) {
                max = beginScore + remainingScore;
                maxIndex = i;
            }
        }
        if (maxIndex != -1) {
            score.put(str.substring(0, maxIndex), max);
        }
        return max;
    }

    private int getScore(String s) {
        return dict.getOrDefault(s, -1);
    }

    public static void main(String[] args) {
        SeparatingWords sw = new SeparatingWords();
        sw.dict.put("v", 1);
        sw.dict.put("vi", 4);
        sw.dict.put("i", 5);
        sw.dict.put("r", 3);
        sw.dict.put("ir", 4);
        sw.dict.put("vir", 8);
        System.out.println(sw.getMaxScore("vir"));
    }
}
