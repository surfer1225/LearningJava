package main.java.leetcode;

/**
 * Created by Ryan on 7/1/18.
 */
public class RectangleCoveredArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int abcd = (A-C)*(B-D);
        int efgh = (E-G)*(F-H);

        int common = overlapLength(A, C, E, G) * overlapLength(B, D, F, H);

        return abcd + efgh - common;
    }


    /*
        ACEG => 0
        ACEG => CE
        AECG => EC
        EACG => AC
        EAGC => AG
        EGAC => 0
    */
    private int overlapLength(int A, int C, int E, int G)
    {
        if(C < E || A > G)
            return 0;
        return Math.min(C, G) - Math.max(A, E);
    }
}
