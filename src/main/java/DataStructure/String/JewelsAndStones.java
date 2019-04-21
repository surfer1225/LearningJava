package main.java.DataStructure.String;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        int cnt = 0;
        for (char c:J.toCharArray()) {
            while (S.indexOf(c)>-1) {
                S = S.replaceFirst(String.valueOf(c),"");
                ++cnt;
            }
        }
        return cnt;
    }
}
