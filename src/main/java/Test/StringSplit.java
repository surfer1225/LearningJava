package main.java.Test;

public class StringSplit {
    public static void main(String[] args) {
        String s = "a, ,c,";

        String[] arr = s.split(",");

        for (String str:arr) System.out.println(str);
    }
}
