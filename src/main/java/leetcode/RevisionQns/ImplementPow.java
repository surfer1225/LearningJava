package main.java.leetcode.RevisionQns;

/**
 * Created by Ryan on 17/12/17.
 */
public class ImplementPow {
    public double myPow(double x, int n) {

        double temp=x;
        if(n==0)
            return 1;
        temp=myPow(x,n/2);
        if(n%2==0)
            return temp*temp;
        else
        {
            if(n > 0)
                return x*temp*temp;
            else
                return (temp*temp)/x;
        }

        //alternative solution
//        if (n==0) return 1;
//        return n<0?1/myPowHelper(x, -n):myPowHelper(x, n);
    }

    private double myPowHelper(double x, int n) {
        if (n==1) return x;
        int cnt = 1;
        double temp = x;
        while (cnt * 2 <n) {
            cnt += cnt;
            x *= x;
        }
        return x * myPow(temp, n - cnt);
    }

    public static void main(String[] args) {
        ImplementPow p = new ImplementPow();
        System.out.println(p.myPow(2, -10));
    }
}
