package server.Thread;

import client.entity.User;
import server.util.MessageServerUtil;

import java.io.IOException;

public class MessageServer extends  Thread{

    //public User user;

    public MessageServer() {

    }

    @Override
    public void run() {
        MessageServerUtil messageServerUtil;
        while (true){
            try {
                messageServerUtil = new MessageServerUtil();
                Thread thread = new Thread(new readThread(messageServerUtil));
                thread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }

            super.run();
        }


    }
}
