package main.java.type;

/**
 * Created by wenyao on 4/6/17.
 */
public class Boxing {
    public static void main(String[] args) {
        Integer a = new Integer(1);
        Integer b = a;
        //this will give true for both == and equal
        System.out.println(a==b);
        System.out.println(a.equals(b));

        a++;
        //this will give false for both
        System.out.println("value of a: " + a + " and value of b: " + b
                + " a==b is: " + (a==b));
        System.out.println("value of a: " + a + " and value of b: " + b
                + " a==b is: " + (a.equals(b)));
    }
}
