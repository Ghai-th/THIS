package server.dao.impl;

import client.entity.Message;
import server.dao.IMessageDao;
import server.util.DBUtil;

import java.sql.*;
import java.util.List;

public class MessageDaoImpl implements IMessageDao {
    @Override
    public void addMessage(Message message) throws SQLException {
        Connection connection = DBUtil.getConnection();
        String sql = "insert into Message values(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,message.getSendId());
        preparedStatement.setString(2,message.getAcceptId());
        preparedStatement.setString(3,message.getText());
        preparedStatement.setDate(4, (Date) message.getTime());
        preparedStatement.setInt(5,message.getState());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    @Override
    public void deleteMessage(Message message) throws SQLException {
        Connection connection = DBUtil.getConnection();
        String sql = "delete from massage where sendid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,message.getSendId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    @Override
    public void updateMessage(Message message) throws SQLException {

    }

    @Override
    public List<Message> selectMessage(Message message) throws SQLException {
        List<Message> messageList;
       Connection connection = DBUtil.getConnection();
        Statement statement = connection.createStatement();
        String id = message.getAcceptId();
        String sql = "select * from Message where acceptid=id";
        messageList = DBUtil.executeGetMoreData(statement,sql,Message.class);
        statement.close();
        connection.close();
        return messageList;
    }
}
