package server.controller;

import client.entity.*;
import server.util.ServerUtil;

import java.io.IOException;
import java.lang.Class;

public class Execute<T> extends Thread {
    T t = null;
    ServerUtil serverUtil = null;
    public void run() {
        try {
            serverUtil = new ServerUtil();
            new Thread(new Listener<Article>(serverUtil)).start();

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
        try {
            T t = (T) serverUtil.objectInputStream.readObject();
            selectClass();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
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
