package main.java.DataStructure.Array;

public class NewYearChaos {
    public void newYearChaos(int[] q) {
        int cnt = 0;

        for (int i=q.length-1;i>=0;--i) {
            if (q[i]-i>3) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j=Math.max(0,q[i]-2);j<i;j++) if (q[j]>q[i]) cnt++;
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) {
        NewYearChaos nyc = new NewYearChaos();
        nyc.newYearChaos(new int[]{2,1,5,3,4});
        nyc.newYearChaos(new int[]{2,5,1,3,4});
        nyc.newYearChaos(new int[]{5,1,2,3,7,8,6,4});
        nyc.newYearChaos(new int[]{1,2,5,3,7,8,6,4});
    }
}
