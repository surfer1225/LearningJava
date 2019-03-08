package main.java.java8features.stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by wenyao on 4/17/17.
 */
public class StreamReduction {

    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5).stream();
        Integer sum = stream.reduce(0, (num1, num2) -> num1 + num2);
        System.out.println(sum);
    }

}
