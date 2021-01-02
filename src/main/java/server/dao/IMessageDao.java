package server.dao;

import client.entity.Message;

import java.sql.SQLException;
import java.util.List;

public interface IMessageDao {
    void addMessage(Message message) throws SQLException;
    void deleteMessage(Message message) throws SQLException;
    void updateMessage(Message message) throws SQLException;
    List<Message> selectMessage(Message message) throws SQLException;
}
