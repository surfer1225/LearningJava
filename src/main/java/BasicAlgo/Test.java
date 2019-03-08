package main.java.BasicAlgo;

/**
 * Created by Ryan on 26/11/17.
 */

public class Test {
    public static int minimalNumberOfPackages(int items, int availableLargePackages, int availableSmallPackages) {

        if (availableLargePackages * 5 + availableSmallPackages < items) return -1;
        int largePackages = items / 5;
        largePackages = Math.min(availableLargePackages, largePackages);
        return items - largePackages * 5 + largePackages;
    }

    public static void main(String[] args) {
        System.out.println(minimalNumberOfPackages(16, 2, 10));
    }
}

