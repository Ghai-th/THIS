package server.service;

import client.entity.Message;
import server.dao.IMessageDao;
import server.dao.impl.MessageDaoImpl;

import java.sql.SQLException;
import java.util.List;

public interface IMessageService {
    /**
     * 向message表中增加数据
     */
    public boolean addMessage(Message message);

    /**
     * 删除message表中的元素
     */
    public boolean deleteMessage(Message message);

    /**
     * 更新message表中已有的元素
     */
    public boolean updaateMessage(Message message);

    /**
     * 将表中被发送者的所有聊天信息拖出为集合
     * @return
     */
    public List<Message> selectMessage(Message message);

    /**
     * 将表中唯一可以标识的一行message取出
     * @param message
     * @return
     */
    public Message selectOneMessage(Message message);

    /**
     * 将message表中对应的行的
     * @param message
     */
    public boolean updateMessageState(Message message,String n,int judge);
    /**
     *
     * @param message 传入一个信息发送对象，判断message表中是否存在这个对象
     * @return 结果返回true或false
     */
    boolean emptyMessage(Message message) throws SQLException;

    //判断拉出的List中的每一行的state是否为1，若不为1则抛出

    /**
     *
     * @param messageList 传入一个从数据库中拉出的List将该集合中所有state值为0的元素从集合中删除
     */
    void perfectList(List<Message> messageList);

}
