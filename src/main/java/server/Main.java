package server;

import server.controller.Execute;

import java.io.IOException;

public class Main {

    public static <T> void main(String[] args) throws IOException {
        while (true) {
            new Execute<>().start();
        }
    }
}
