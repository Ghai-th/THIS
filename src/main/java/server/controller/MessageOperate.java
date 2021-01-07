package server.controller;

import client.entity.Message;
import client.entity.User;
import server.Thread.UserSocketGather;
import server.dao.IMessageDao;
import server.service.IMessageService;
import server.service.impl.MessageServiceImpl;
import server.util.MessageServerUtil;
import server.util.ServerUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class MessageOperate {
    public Message message;
    public MessageServerUtil messageServerUtil;
    IMessageService iMessageService = new MessageServiceImpl();
    public MessageOperate(Message message, MessageServerUtil messageServerUtil) throws SQLException {
        this.messageServerUtil = messageServerUtil;
        this.message = message;
        selectOperate();
    }

    /**
     * 执行操作
     * @throws SQLException
     */
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

            case ServerOperate.ACCEPT_MAP_MESSAGE:
                acceptMapMessage();break;

            case  ServerOperate.ACCEPT_LIST_MESSAGE:
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
        Iterator iterator = UserSocketGather.userMessageServerUtilMap.entrySet().iterator();
        System.out.println("目前上线集合中的元素有:");
        while(iterator.hasNext()){
            Map.Entry<User,MessageServerUtil> entry = (Map.Entry<User, MessageServerUtil>) iterator.next();
            System.out.println(entry.getKey());
        }
        System.out.println("到此结束");
    }

    /**
     * 判断用户是都有新消息
     */
    public void testMessage() throws SQLException {
        if(iMessageService.newMessage(message)){
            //给客户端回发有新消息时的操作
            message.setSendNotice("10");
            try {
                messageServerUtil.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            //给客户端回发没有新消息时的操作
            message.setSendNotice("0");
            try {
                messageServerUtil.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发送消息
     */
    public void sendMessage() throws SQLException {
        int n = 0;
        User user = new User();
        user.setUid(message.getAcceptId());
        //if()d
        Map.Entry<User,MessageServerUtil> entry = UserSocketGather.getUserMessageServerUtil(user);
        if(entry!=null){
            n = 0;
            //调用entry里的socket向客户端发送消息
            try {
                entry.getValue().sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            n = 1;
        }
        iMessageService.addMessage(message,n);
    }

    /**
     * 拉取消息列表
     */
    public void acceptMessage() throws SQLException {
        List<Message> messageList = iMessageService.selectMessage(message);
        if(messageList==null){
            messageList = new ArrayList<Message>();
        }
        try {
            messageServerUtil.sendMessageList(messageList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 拉取哈希map
     */
    public void acceptMapMessage(){
        HashMap<String,String> otherMap = iMessageService.selectMapMessage(message);
        if(otherMap == null){
            otherMap = new HashMap<String, String>();
        }
        try {
            messageServerUtil.sendMessageHashMap(otherMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
