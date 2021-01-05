package server.service.impl;

import client.entity.Message;
import server.dao.IMessageDao;
import server.dao.impl.MessageDaoImpl;
import server.service.IMessageService;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class MessageServiceImpl implements IMessageService {
    IMessageDao iMessageDao = new MessageDaoImpl();

    @Override
    public boolean addMessage(Message message) {
        try {
            iMessageDao.addMessage(message);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteMessage(Message message) {
        try {
            iMessageDao.deleteMessage(message);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateMessage(Message message) {
        try {
            iMessageDao.updateMessage(message);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Message> selectMessage(Message message) {
        try {
            return iMessageDao.selectMessage(message);
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public Message selectOneMessage(Message message) {
        try {
            return iMessageDao.selectOneMessage(message);
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public boolean updateMessageState(Message message, String n, int judge) {
        try {
            iMessageDao.updateMessageState(message,n,judge);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateMessageSendNotice(Message message, String n) {
        return iMessageDao.updateMessageSendNotice(message,n);
    }

    @Override
    public boolean updateMessageAcceptNotice(Message message, String n) {
        return iMessageDao.updateMessageAcceptNotice(message,n);
    }

    @Override
    public boolean emptyMessage(Message message) throws SQLException {
        Message message1 = iMessageDao.selectOneMessage(message);
        if(message1==null){
            return true;
        }else
            return false;
    }

    @Override
    public void perfectList(List<Message> messageList) {
        Iterator<Message> iterator = messageList.iterator();
        while(iterator.hasNext()){
            Message message = iterator.next();
            if(message.getState().equals("0")){
                messageList.remove(message.getState());
            }
        }
    }
}
