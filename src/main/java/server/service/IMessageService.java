package server.service;

import client.entity.Message;

import java.sql.SQLException;
import java.util.List;

public interface IMessageService {
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
