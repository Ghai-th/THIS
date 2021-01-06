package server.dao.impl;

import client.entity.Message;
import server.dao.IMessageDao;
import server.util.DBUtil;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageDaoImpl implements IMessageDao {
    Connection connection = null;
    Statement statement = null;
    @Override
    public void addMessage(Message message) throws SQLException {
        updateMessageState(message,"1",0);
        connection = DBUtil.getConnection();
        String sql = "insert into message values(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,message.getSendId());
        preparedStatement.setString(2,message.getAcceptId());
        preparedStatement.setString(3,"#"+message.getText());
        preparedStatement.setString(4,
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message.getTime()));
        preparedStatement.setString(5,message.getState());
        preparedStatement.setString(6,"1");
        preparedStatement.setString(7,message.getAcceptNotice());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message.getTime()));
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    @Override
    public void deleteMessage(Message message) throws SQLException {
        connection = DBUtil.getConnection();
        String sql = "delete from massage where sendid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,message.getSendId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    @Override
    public void updateMessage(Message message) throws SQLException {
        updateMessageState(message,"1",0);
        System.out.println("执行了");
        Message mymessage = selectOneMessage(message);
        String text = mymessage.getText();
        text = text+"#"+message.getText();
        String sql = "update message set text=? where sendid=? and acceptid=?";
        connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,text);
        preparedStatement.setString(2,message.getSendId());
        preparedStatement.setString(3,message.getAcceptId());
        preparedStatement.executeUpdate();
        DBUtil.closeResources(connection,preparedStatement);
    }

    /**
     * 拉取接收者对应发送者具体的聊天记录
     * @param message
     * @return
     * @throws SQLException
     */
    @Override
    public List<Message> selectMessage(Message message) throws SQLException {
        List<Message> messageList;
        connection = DBUtil.getConnection();
        statement = connection.createStatement();
        String acceptId = message.getAcceptId();
        String sendId = message.getSendId();
        String sql = "select * from message where acceptid='"+acceptId+"' and sendid='"+sendId+"'";
        messageList = DBUtil.executeGetMoreData(statement,sql,Message.class);
        updateMessageState(message,"0",1);
        statement.close();
        connection.close();
        return messageList;
    }

    @Override
    public HashMap<String, String> selectMapMessage(Message message) {
        HashMap<String,String> otherMap = new HashMap<String,String>();
        String sql = "select * from message where acceptid='"+message.getAcceptId()+"'";
        try {
            connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(sql);
            while(set.next()){
                otherMap.put(set.getString("sendid"),null);
            }
            return otherMap;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Message selectOneMessage(Message message) throws SQLException {
        connection = DBUtil.getConnection();
        statement = connection.createStatement();
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
    public void updateMessageState(Message message,String n,int judge) throws SQLException {
        String sql = null;
        if(judge==0){
            sql = "update message set state='"+n+"' where sendid='"+message.getSendId()+"' and acceptid='"+message.getAcceptId()+"'";
        }
        if(judge==1){
            sql = "update message set state='"+n+"' where sendid='"+message.getAcceptId()+"'";
        }
        connection = DBUtil.getConnection();
        statement = connection.createStatement();

        DBUtil.executeChange(statement,sql);
        DBUtil.closeResources(connection,statement);
    }

    @Override
    public boolean updateMessageSendNotice(Message message,String n) {
        String sql = "update message set notice='"+n+"' where sendid='"+message.getSendId()+"'";
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            return false;
        }finally {
            {
                DBUtil.closeResources(connection,statement);
            }
        }

    }

    @Override
    public boolean updateMessageAcceptNotice(Message message,String n) {
        String sql = "update message set notice='"+n+"' where acceptid='"+message.getAcceptId()+"'";
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            return false;
        }finally {
            {
                DBUtil.closeResources(connection,statement);
            }
        }
    }


}
