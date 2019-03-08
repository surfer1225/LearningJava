package main.java.Concepts;

public class Derived extends Base {
    public void print() {
        System.out.println("Derived print");
    }

    public static void main(String[] args) {
        Derived d = new Derived();
        d.print();
    }
}
