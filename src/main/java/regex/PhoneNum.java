package main.java.regex;

public class PhoneNum {
    public static void main( String args[] ) {
        String regex = "^[+]?([0-9-]+)";
        String intRegex = "\\d+";

        System.out.println("8-6-9".matches(regex));
        System.out.println("88".matches(intRegex));
    }
}
