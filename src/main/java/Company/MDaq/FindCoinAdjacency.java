package main.java.Company.MDaq;

/*
FIXME: not working
Find the max number of adjacency coins with the same face after flipping one coin
 */
public class FindCoinAdjacency {
    public static int solution(int[] A) {
        int n = A.length;
        int result = 0;
        for (int i=0;i<n-1;i++) {
            if (A[i] == A[i+1])
                result = result + 1;
        }
        int r = Integer.MIN_VALUE;
        for (int i=0;i<n;i++) {
            int count = 0;
            if (i>0) {
                if (A[i-1] != A[i])
                    count = count + 1;
                else
                    count = count - 1;
            }
            if (i < n-1) {
                if (A[i+1] != A[i])
                    count = count + 1;
                else
                    count = count - 1;
            }
            r = Math.max(r, count);
        }
        System.out.println("result: " + result + ", r: " + r);
        return result + r;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,1,0,1,0,0}));
        System.out.println(solution(new int[]{1,0,0,1,0,0}));
        System.out.println(solution(new int[]{1,1,1,1,1,1}));
        System.out.println(solution(new int[]{1,0,1,1,1,0,1,1,1,0,0,0,1,1,1,1,0,1,0}));
    }
}
