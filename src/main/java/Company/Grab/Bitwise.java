package main.java.Company.Grab;

/**
 * Created by Ryan on 4/7/17.
 */
public class Bitwise {
    public static void main(String[] args) {
        System.out.println(7&3);

        // flip the 3rd bit of an integer
        int bit = 1;
        int flippingBit = bit << 2;
        System.out.println(flippingBit);
        System.out.println(12 ^ flippingBit);

    }
}
