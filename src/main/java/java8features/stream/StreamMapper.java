package main.java.java8features.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wenyao on 4/10/17.
 */
public class StreamMapper {

    public static void main(String[] args) {

        List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> l2 = Arrays.asList(2, 4, 6);
        List<Integer> l3 = Arrays.asList(3, 5, 7);

        List<List<Integer>> list = Arrays.asList(l1, l2, l3);
        list.stream()
                .map(s -> s.size())
                .forEach(System.out::println);//7 3 3 is the result

        //TODO: flatmap implementation
    }
}
