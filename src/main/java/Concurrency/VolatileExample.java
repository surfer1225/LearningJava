package main.java.Concurrency;

/**
 * Created by Ryan on 19/7/17.
 */
public class VolatileExample {
    public static void main(String args[]) {
        new ExampleThread("Thread 1").start();
        new ExampleThread("Thread 2").start();
    }
}
