package server.dao.impl;

import client.entity.Message;
import server.dao.IMessageDao;
import server.util.DBUtil;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class MessageDaoImpl implements IMessageDao {
    @Override
    public void addMessage(Message message) throws SQLException {
        updateMessageState(message,"1");
        Connection connection = DBUtil.getConnection();
        String sql = "insert into message values(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,message.getSendId());
        preparedStatement.setString(2,message.getAcceptId());
        preparedStatement.setString(3,"#"+message.getText());
        preparedStatement.setString(4,
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message.getTime()));
        preparedStatement.setString(5,message.getState());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message.getTime()));
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
        updateMessageState(message,"1");
        System.out.println("执行了");
        Message mymessage = selectOneMessage(message);
        String text = mymessage.getText();
        text = text+"#"+message.getText();
        String sql = "update message set text=? where sendid=? and acceptid=?";
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,text);
        preparedStatement.setString(2,message.getSendId());
        preparedStatement.setString(3,message.getAcceptId());
        preparedStatement.executeUpdate();
        DBUtil.closeResources(connection,preparedStatement);
    }

    @Override
    public List<Message> selectMessage(Message message) throws SQLException {
        List<Message> messageList;
        Connection connection = DBUtil.getConnection();
        Statement statement = connection.createStatement();
        String id = message.getAcceptId();
        String sql = "select * from message where acceptid='"+id+"'";
        messageList = DBUtil.executeGetMoreData(statement,sql,Message.class);
        updateMessageState(message,"0");
        statement.close();
        connection.close();
        return messageList;
    }

    @Override
    public Message selectOneMessage(Message message) throws SQLException {
        Connection connection = DBUtil.getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from message where sendid='"+message.getSendId()+"' and acceptid='"+message.getAcceptId()+"'";
        message = DBUtil.executeGetData(statement,sql,Message.class);
        return message;
    }

    @Override
    public Boolean emptyMessage(Message message) throws SQLException {
        Message message1 = selectOneMessage(message);
        if(message1==null){
            return true;
        }else
        return false;
    }

    @Override
    public void updateMessageState(Message message,String n) throws SQLException {
        String sql = "update message set state='"+n+"' where sendid='"+message.getSendId()+"' and acceptid='"+message.getAcceptId()+"'";
        System.out.println(sql);
        Connection connection = DBUtil.getConnection();
        Statement statement = connection.createStatement();
        DBUtil.executeChange(statement,sql);
        DBUtil.closeResources(connection,statement);
    }

}
