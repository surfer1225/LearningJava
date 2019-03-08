package main.java.pattern.Composite;

/**
 * Created by Ryan on 8/5/18.
 */
public class CompositeDemo {
    public static void main(String[] args) {
        Employee CEO = new Employee("apple", "Sales", 10000);
        Employee CTO = new Employee("pear", "IT", 9000);
        Employee CFO = new Employee("lemon", "Finance", 9000);

        CEO.add(CFO);
        CEO.add(CTO);

        Employee dev = new Employee("peach", "IT", 3000);
        Employee qa = new Employee("orange", "IT", 3000);

        CTO.add(qa);
        CTO.add(dev);
    }
}
