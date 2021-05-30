package main.java.BasicAlgo;

import java.util.HashMap;
import java.util.Map;

public class SeparatingWordsII {

    Map<String, Integer> dict = new HashMap<>();

    public int getMaxScore(String str) {
        int[][] max_score = new int[str.length()][str.length()];
        for (int i = 0; i < str.length(); ++i) {
            max_score[i][i] = getScore(String.valueOf(str.charAt(i)));
        }
        for (int i = 1; i <= str.length() - 1; ++i) {
            for (int j = 0; j <= str.length() - i - 1; ++j) {
                max_score[j][j + i] = getScore(str.substring(j, j + i + 1));
                for (int k = j; k <= j + i - 1; ++k) {
                    max_score[j][j + i] = Math.max(max_score[j][i], max_score[j][k] + max_score[k + 1][j + i]);
                }
            }
        }
        for (int i = 0; i < str.length(); ++i) {
            for (int j = 0; j < str.length(); ++j) {
                System.out.print(max_score[i][j] + ", ");
            }
            System.out.println();
        }
        return max_score[0][str.length() - 1];
    }

    private int getScore(String s) {
        return dict.getOrDefault(s, -1);
    }

    public static void main(String[] args) {
        SeparatingWordsII sw = new SeparatingWordsII();
        sw.dict.put("v", 1);
        sw.dict.put("vi", 4);
        sw.dict.put("i", 5);
        sw.dict.put("r", 3);
        sw.dict.put("ir", 4);
        sw.dict.put("vir", 8);
        System.out.println(sw.getMaxScore("vir"));
    }
}
