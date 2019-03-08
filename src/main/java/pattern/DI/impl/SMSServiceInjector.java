package main.java.pattern.DI.impl;

import main.java.pattern.DI.Consumer;
import main.java.pattern.DI.MessageServiceInjector;

/**
 * Created by Ryan on 30/7/17.
 */
public class SMSServiceInjector implements MessageServiceInjector {

    @Override
    public Consumer getConsumer() {
        return new MyDIApplication(new SMSServiceImpl());
    }

}
