package server.Thread;

import client.entity.User;
import server.util.MessageServerUtil;

import java.io.IOException;

public class MessageServer extends  Thread{

    public User user;

    public MessageServer(User user) {
        this.user = user;
    }

    @Override
    public void run() {

        MessageServerUtil messageServerUtil;
        try {
            messageServerUtil = new MessageServerUtil();
        } catch (IOException e) {
            e.printStackTrace();
        }

        super.run();
    }
}
