package server.dao;

import client.entity.Message;

import java.sql.SQLException;
import java.util.List;

public interface IMessageDao {
    /**
     * 向message中添加元素
     * @param message
     * @throws SQLException
     */
    void addMessage(Message message) throws SQLException;

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
     * 拉出接收者接收消息的列表
     * @param message
     * @return
     * @throws SQLException
     */
    List<Message> selectMessage(Message message) throws SQLException;

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
