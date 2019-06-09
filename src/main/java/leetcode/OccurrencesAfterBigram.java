package main.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
5083. Occurrences After Bigram
User Accepted: 0
User Tried: 0
Total Accepted: 0
Total Submissions: 0
Difficulty: Easy
Given words first and second, consider occurrences in some text of the form "first second third",
where second comes immediately after first, and third comes immediately after second.

For each such occurrence, add "third" to the answer, and return the answer
 */
public class OccurrencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> result = new ArrayList<>();

        String[] textArr = text.split(" ");
        for (int i=1;i<textArr.length;i++) {
            if (textArr[i].equals(second) && textArr[i-1].equals(first) && i+1<textArr.length)
                result.add(textArr[i+1]);
        }

        return result.toArray(new String[]{});
    }

    public static void main(String[] args) {
        OccurrencesAfterBigram o = new OccurrencesAfterBigram();
        for (String s:o.findOcurrences("alice is a good girl she is a good student","a", "good"))
            System.out.println(s);

        o = new OccurrencesAfterBigram();
        for (String s:o.findOcurrences("alice is a good girl she is a good student","a", "good"))
            System.out.println(s);
    }
}
