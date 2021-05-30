package main.java.BasicAlgo;

/*
Find trending increase starting from first element
 */
public class TrendingIncrease {
    public int getSizeOfLongestTrend(int[] arr) {
        int[] res = new int[arr.length];
        res[0] = 1;
        int max = 0;

        for (int i=1;i<=arr.length-1;++i) {
            if (arr[i] <= arr[0]) {
                res[i] = -1; // i is not part of the trend
            }
            else {
                for (int j=i-1;j>=0;--j) {
                    if (res[j]!=-1 && arr[i] > arr[j]) { // skip the elements not part of the trend
                        res[i] = Math.max(res[i], res[j]+1);
                    }
                }
                max = Math.max(res[i], max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        TrendingIncrease ti = new TrendingIncrease();
        System.out.println(ti.getSizeOfLongestTrend(new int[]{3,1,2,1,4,8,7,9,2}));
    }
}
