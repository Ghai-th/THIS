package server;

import client.entity.*;
import server.controller.ArticleOperate;
import server.controller.Execute;
import server.util.ServerUtil;

import java.io.IOException;
import java.lang.Class;

public class Main {



    public static <T> void main(String[] args) throws IOException {
        while (true) {
            new Execute<>().start();
        }
    }
}
