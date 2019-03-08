package main.java.Concurrency;

/**
 * Created by Ryan on 30/7/17.
 */
class ExampleThread extends Thread {
    private volatile int testValue;
    public ExampleThread(String str){
        super(str);
    }
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println(getName() + " : "+i);
                if (getName().equals("Thread 1"))
                {
                    testValue = 10;
                }
                if (getName().equals("Thread 2"))
                {
                    System.out.println( "Test Value : " + testValue);
                }
                Thread.sleep(1000);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }
}
