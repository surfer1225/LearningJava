package main.java.pattern.DI.impl;

import main.java.pattern.DI.MessageService;

/**
 * Created by Ryan on 30/7/17.
 */
public class EmailServiceImpl implements MessageService {

    @Override
    public void sendMessage(String msg, String rec) {
        //logic to send email
        System.out.println("Email sent to "+rec+ " with Message="+msg);
    }

}
