package main.java.type;

/**
 * Created by wenyao on 4/6/17.
 */
public class StringCompare {
    public static void main(String[] args) {
        String a = "aaa";
        String b = "aaa";
        //this will give both true since aaa is still in memory cached
        System.out.println(a==b);
        System.out.println(a.equals(b));
        String c = new String ("aaa");
        System.out.println(a.equals(c));//true
        System.out.println(a==c);//false
    }
}
