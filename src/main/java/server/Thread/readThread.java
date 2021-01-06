package server.Thread;

import client.entity.*;
import client.entity.Class;
import server.controller.*;
import server.util.MessageServerUtil;

import java.sql.SQLException;

public class readThread<T> implements Runnable {
    MessageServerUtil messageServerUtil;
    T t = null;

    public readThread(MessageServerUtil messageServerUtil) {
        this.messageServerUtil = messageServerUtil;
    }

    public void selectClass() throws SQLException {
        if (t instanceof Message) {
            new MessageOperate((Message) t, messageServerUtil);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                t = (T) messageServerUtil.objectInputStream.readObject();
                System.out.println(t);
                selectClass();
            } catch (Exception e) {
                try {
                    messageServerUtil.closeResource();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
