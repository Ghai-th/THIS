package server.util;

import client.entity.User;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerUtil {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(2222);
        Socket socket = serverSocket.accept();
//        InputStream inputStream = socket.getInputStream();
//        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
//        System.out.println(objectInputStream.readObject());
        OutputStream outputStream = socket.getOutputStream();
        User user = new User();
        User.initUser(user);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(user);

    }
}
