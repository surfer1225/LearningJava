package main.java.java8features.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by wenyao on 4/10/17.
 */
public class StreamFlatMap {
    public static void main(String[] args) {
        List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)) // Stream of List<Integer>
                .flatMap(l -> l.stream())//.flatMap(List::stream)
                .map(integer -> integer + 1)
                .collect(Collectors.toList());
        System.out.println(together);
        //(2, 3, 4, 5)

        List<String> collected = Stream.of("a", "b", "hello") // Stream of String
                .map(String::toUpperCase) // Returns a stream consisting of the results of applying the given function to the elements of this stream.
                .collect(Collectors.toList());
        //("A", "B", "HELLO")
    }
}
