package server.Thread;

import client.entity.*;
import server.controller.ArticleOperate;
import server.util.ServerUtil;

import java.io.IOException;
import java.lang.Class;

class Execute<T> extends Thread {
    T t = null;
    ServerUtil serverUtil = null;

    public Execute(ServerUtil serverUtil) {
        this.serverUtil = serverUtil;
    }

    public void run() {
        try {
            System.out.println(2);
            new Thread(new Listener<>(serverUtil)).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Listener<T> implements Runnable {

    public ServerUtil serverUtil;
    public T t;

    public Listener(ServerUtil serverUtil) {
        this.serverUtil = serverUtil;
    }

    @Override
    public void run() {
        while (true) {
            try {
                t = (T) serverUtil.objectInputStream.readObject();
                System.out.println(1);
                selectClass();
            } catch (Exception e) {
                try {
                    serverUtil.closeResource();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public void selectClass() {
        if (t instanceof Article) {
            new ArticleOperate((Article) t, serverUtil);
        } else if (t instanceof Attention) {

        } else if (t instanceof Class) {

        } else if (t instanceof Comment) {

        } else if (t instanceof Message) {

        } else if (t instanceof Store) {

        } else if (t instanceof User) {
        }
    }
}

 public class ServerApplicationStart<T> {
    public ServerApplicationStart() {
        while (true) {
            ServerUtil serverUtil = null;
            try {
                serverUtil = new ServerUtil();
            } catch (IOException e) {
                e.printStackTrace();
            }
            new Execute<>(serverUtil).start();
        }
    }
}
