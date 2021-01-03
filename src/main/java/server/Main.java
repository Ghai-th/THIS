package server;

import server.controller.Execute;
import server.util.ServerUtil;

import java.io.IOException;

public class Main {

    public static <T> void main(String[] args) throws IOException {
        while (true) {

            ServerUtil serverUtil = new ServerUtil();
            new Execute<>(serverUtil).start();
        }
    }
}
