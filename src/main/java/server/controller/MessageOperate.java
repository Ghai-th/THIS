package server.controller;

import client.entity.Message;
import client.entity.User;
import server.Thread.UserSocketGather;
import server.dao.IMessageDao;
import server.service.IMessageService;
import server.service.impl.MessageServiceImpl;
import server.util.MessageServerUtil;
import server.util.ServerUtil;

import java.sql.SQLException;
import java.util.List;

public class MessageOperate {
    public Message message;
    public MessageServerUtil messageServerUtil;
    IMessageService iMessageService = new MessageServiceImpl();
    public MessageOperate(Message message, MessageServerUtil messageServerUtil) throws SQLException {
        this.messageServerUtil = messageServerUtil;
        this.message = message;
        selectOperate();
    }
    public void selectOperate() throws SQLException {
        switch ((message.getOperate())){
            case ServerOperate.TEST_MESSAGE:
                testMessage();break;

            case ServerOperate.ONLINE_MESSAGE:
                onlineMessage();break;

            case ServerOperate.WINDING_MESSAGE:
                windingMessage();break;

            case ServerOperate.SEND_MESSAGE:
                sendMessage();break;

            case ServerOperate.ACCEPT_MESSAGE:
                acceptMessage();break;

        }
    }

    /**
     * 用户打开聊天窗体后发送上线消息，将该用户加入到上线集合中
     */
    public void onlineMessage(){
        User user = new User();
        user.setUid(message.getSendId());
        UserSocketGather.addUserServerUtilMap(user,messageServerUtil);
    }

    /**
     * 判断用户是都有新消息
     */
    public void testMessage() throws SQLException {
        if(iMessageService.newMessage(message)){

        }else {

        }
    }

    /**
     * 发送消息
     */
    public void sendMessage() throws SQLException {
        int n = 0;
        User user = new User();
        user.setUid(message.getAcceptId());
        //if()
        if(iMessageService.newMessage(message)){
            n = 1;
        }
        iMessageService.addMessage(message,n);
    }

    /**
     * 拉取消息列表
     */
    public void acceptMessage(){
        List<Message> messageList = iMessageService.selectMessage(message);

    }

    /**
     * 用户下线时执行将该用户从上线集合中去除
     */
    public void windingMessage(){
        User user = new User();
        user.setUid(message.getSendId());
        UserSocketGather.deleteUserServerUtilMap(user);
    }

}
