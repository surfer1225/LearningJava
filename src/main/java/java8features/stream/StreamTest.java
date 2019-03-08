package main.java.java8features.stream;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by wenyao on 4/9/17.
 */
public class StreamTest {
    /* Stream:
    1. an object that defines operations
    2. object which does not hold any data
    3. better not change the data it processes
    */
    public static void main(String[] args) {
        /*consumer is a functional interface with void accept method
        default method andThen to chain conditions

        Predicate interface with test boolean method
        default, or, and negate methods
         */
        Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
        Predicate<String> p1 = s -> s.length() > 3;
        Predicate<String> p2 = Predicate.isEqual("two");
        stream.filter(p1.or(p2)).forEach(s -> System.out.println("first stream " + s));
        /*
        lazy method, call is a declaration of operation, no data is processed

        an operation on a stream that returns a stream is called an intermediary operation

        */

        //stream.peek(s -> System.out.println(s));
        //will fail because there is already operation on it

        stream = Stream.of("one", "two", "three", "four", "five");
        stream.peek(System.out::println)//lazy
                .filter(p1)//lazy
                .forEach(s -> System.out.println("s in for each: " + s));//not lazy
        //peek and forEach happen together
        //for each is a final operation
        //peek is an intermediary
        //final operation will triger data operation

        /*
        first stream two
        first stream three
        first stream four
        first stream five
        one
        two
        three
        s in for each: three
        four
        s in for each: four
        five
        s in for each: five
         */
    }
}
