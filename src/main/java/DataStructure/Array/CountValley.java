package main.java.DataStructure.Array;

public class CountValley {
    public int countingValleys(int n, String s) {
        int cnt = 0;
        int lvl = 0;

        for (int i=0;i<n;++i) {
            if (s.charAt(i)=='U') {
                lvl++;
            }
            else {
                if (lvl==0) cnt++;
                lvl--;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        CountValley cv = new CountValley();
        System.out.println(cv.countingValleys(8,"UDDDUDUU"));
        System.out.println(cv.countingValleys(12,"DDUUDDUDUUUD"));
    }
}
