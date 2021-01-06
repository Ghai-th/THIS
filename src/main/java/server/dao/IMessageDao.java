package server.dao;

import client.entity.Message;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IMessageDao {
    /**
     * 向message中添加元素
     * @param message
     * @throws SQLException
     */
    void addMessage(Message message,int n) throws SQLException;

    /**
     * 删除message中的元素
     * @param message
     * @throws SQLException
     */
    void deleteMessage(Message message) throws SQLException;

    /**
     * 更改message中的元素
     * @param message
     * @throws SQLException
     */
    void updateMessage(Message message) throws SQLException;

    /**
     * 拉去接收者的所有的聊天记录
     * @param message
     * @return
     */
    List<Message> selectAllMessage(Message message) throws SQLException;

    /**
     * 拉取接收者对应发送者具体的聊天记录
     * @param message
     * @return
     * @throws SQLException
     */
    List<Message> selectMessage(Message message) throws SQLException;

    /**
     * 拉去接收者的所有有关的发送者id组成的哈希集合
     * @param message
     * @return
     */
    HashMap<String,String> selectMapMessage(Message message);

    /**
     * 拉出发送者和接收者所唯一标识的一行
     * @param message
     * @return
     * @throws SQLException
     */
    Message selectOneMessage(Message message) throws SQLException;

    /**
     * 判断该行是否为空
     * @param message
     * @return
     * @throws SQLException
     */
    Boolean emptyMessage(Message message) throws SQLException;

    /**
     * 更新message表中state的属性值
     * @param message
     * @param n
     * @param judge
     * @throws SQLException
     */
    void updateMessageState(Message message,String n,int judge) throws SQLException;

    /**
     * 更新message表中的sendnotice元素
     * @param message
     * @param n
     */
    boolean updateMessageSendNotice(Message message,String n);

    /**
     * 更新message表中的accpetnotice元素
     * @param message
     * @param n
     */
    boolean updateMessageAcceptNotice(Message message,String n);
}
