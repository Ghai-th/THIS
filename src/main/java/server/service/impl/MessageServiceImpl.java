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
