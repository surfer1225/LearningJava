package main.java.pattern.DI.impl;

import main.java.pattern.DI.Consumer;
import main.java.pattern.DI.MessageService;

/**
 * Created by Ryan on 30/7/17.
 */
public class MyDIApplication implements Consumer {

    private MessageService service;

    public MyDIApplication(MessageService svc){
        this.service=svc;
    }

    @Override
    public void processMessages(String msg, String rec){
        //do some msg validation, manipulation logic etc
        this.service.sendMessage(msg, rec);
    }

}
