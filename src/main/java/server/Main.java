package server;

import client.entity.*;
import server.controller.ArticleOperate;
import server.util.ServerUtil;

import java.io.IOException;
import java.lang.Class;

public class Main {



    public static <T> void main(String[] args) throws IOException {
//        while (true) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
                    ServerUtil serverUtil = new ServerUtil();
                    T t = null;
                    try {
                        serverUtil.init();
                        t = (T) serverUtil.objectInputStream.readObject();
                        System.out.println(t);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (t instanceof Article) {
                        new ArticleOperate((Article) t,serverUtil);
                    } else if (t instanceof Attention) {

                    } else if (t instanceof Class) {

                    } else if (t instanceof Comment) {

                    } else if (t instanceof Message) {

                    } else if (t instanceof Store) {

                    } else if (t instanceof User) {

                    }
                    while (true) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
//            }).start();
//        }
//    }
}
