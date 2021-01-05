package server.controller;

import client.entity.Message;
import server.dao.IMessageDao;
import server.service.IMessageService;
import server.service.impl.MessageServiceImpl;
import server.util.ServerUtil;

import java.sql.SQLException;

public class MessageOperate {
    public Message message;
    public ServerUtil serverUtil;
    IMessageService iMessageService = new MessageServiceImpl();
    public MessageOperate(Message message, ServerUtil serverUtil){
        this.serverUtil = serverUtil;
        this.message = message;
        selectOperate();
    }
    public void selectOperate(){
        switch ((message.getOperate())){
            case ServerOperate.SEND_MESSAGE:
                sendMessage();
        }
    }
    public void sendMessage(){
        try {
            if(iMessageService.emptyMessage(message)){
                iMessageService.addMessage(message);
            }else{
                System.out.println("不为空");
                iMessageService.updateMessage(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void noticeMessage(){

    }
    public void closeMessage(){

    }
}
