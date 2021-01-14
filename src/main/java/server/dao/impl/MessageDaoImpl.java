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

    /**
     * 增加私信
     * @param message
     * @param n
     * @throws SQLException
     */
    @Override
    public void addMessage(Message message,int n) throws SQLException {
        connection = DBUtil.getConnection();
        String sql = "insert into message values(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,message.getSendId());
        preparedStatement.setString(2,message.getAcceptId());
        preparedStatement.setString(3,message.getText());
        preparedStatement.setString(4,
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message.getTime()));
        preparedStatement.setString(5,String.valueOf(n));
        preparedStatement.setString(6,"1");
        preparedStatement.setString(7,message.getAcceptNotice());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message.getTime()));
        preparedStatement.executeUpdate();
        /*if(n==1){
            updateMessageState(message,"1",0);
        }else {
            updateMessageState(message,"0",0);
        }*/
        preparedStatement.close();
        connection.close();
    }

    /**
     * 根据发送者id删除私信
     * @param message
     * @throws SQLException
     */
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

    /**
     * 更新私信
     * @param message
     * @throws SQLException
     */
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
     * 根据接收者id查询对应的所有私信
     * @param message
     * @return私信内容列表
     * @throws SQLException
     */
    @Override
    public List<Message> selectAllMessage(Message message) throws SQLException {
        List<Message> messageList;
        connection = DBUtil.getConnection();
        statement = connection.createStatement();
        String acceptId = message.getAcceptId();
        String sendId = message.getSendId();
        String sql = "select * from message where acceptid='"+acceptId+"'";
        messageList = DBUtil.executeGetMoreData(statement,sql,Message.class);
        System.out.println(messageList);
        updateMessageState(message,"0",0);
        statement.close();
        connection.close();
        return messageList;
    }

    /**
     * 拉取接收者对应发送者具体的聊天记录
     * @param message
     * @return二者所有私信记录
     * @throws SQLException
     */
    @Override
    public List<Message> selectMessage(Message message) throws SQLException {
        List<Message> messageList;
        connection = DBUtil.getConnection();
        statement = connection.createStatement();
        String acceptId = message.getAcceptId();
        String sendId = message.getSendId();
        String sql = "select * from message where (acceptid='"+acceptId+"' and sendid='"+sendId+"') or (acceptid='"+sendId+"' and sendid='"+acceptId+"')";
        System.out.println("输出的sql语句为");
        System.out.println(sql);
        messageList = DBUtil.executeGetMoreData(statement,sql,Message.class);
        updateMessageState(message,"0",0);
        statement.close();
        connection.close();
        return messageList;
    }

    /**
     * 根据接收者id查询其所有私信内容
     * @param message
     * @return私信内容
     */
    @Override
    public HashMap<String, String> selectMapMessage(Message message) {
        HashMap<String,String> otherMap = new HashMap<String,String>();
        String sql = "select * from message where acceptid='"+message.getAcceptId()+"'";
        //System.out.println(sql);
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

    /**
     * 根据发送者id和接收者id查询对应的私信内容
     * @param message
     * @return二者的私信内容
     * @throws SQLException
     */
    @Override
    public Message selectOneMessage(Message message) throws SQLException {
        connection = DBUtil.getConnection();
        statement = connection.createStatement();
        String sql = "select * from message where sendid='"+message.getSendId()+"' and acceptid='"+message.getAcceptId()+"'";
        message = DBUtil.executeGetData(statement,sql,Message.class);
        return message;
    }

    /**
     * 私信内容置空
     * @param message
     * @return返回true或者false
     * @throws SQLException
     */
    @Override
    public Boolean emptyMessage(Message message) throws SQLException {
        Message message1 = selectOneMessage(message);
        if(message1==null){
            return true;
        }else
            return false;
    }

    /**
     *根据发送者和接收者的id更新私信内容
     * @param message
     * @param n
     * @param judge
     * @throws SQLException
     */
    @Override
    public void updateMessageState(Message message,String n,int judge) throws SQLException {
        String sql = null;
        if(judge==0){
            sql = "update message set state='"+n+"' where acceptid='"+message.getAcceptId()+"'";
        }
        System.out.println(sql);
        connection = DBUtil.getConnection();
        statement = connection.createStatement();

        DBUtil.executeChange(statement,sql);
        DBUtil.closeResources(connection,statement);
    }

    /**
     * 根据发送者id更新发送者的窗口
     * @param message
     * @param n
     * @return返回true或者false
     */
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
        //return false;

    }

    /**
     * 根基接收者id更新接收者的窗口
     * @param message
     * @param n
     * @return返回true或者false
     */
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
