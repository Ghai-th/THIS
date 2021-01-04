package server.controller;

import client.entity.Message;
import server.dao.IMessageDao;
import server.service.IMessageService;
import server.service.impl.MessageServiceImpl;

public class MessageOperate {
    IMessageService iMessageService = new MessageServiceImpl();
    public MessageOperate(){

    }
}
