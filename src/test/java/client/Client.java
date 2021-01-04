package client;

import client.frame.Index;
import entity.User;
import org.junit.Test;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",9000);
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(User.initUser());
        outputStream.close();
        objectOutputStream.close();
        socket.close();
    }
    @Test
    public void test(){

        JFrame jFrame = new JFrame("test");
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        Login index = new Login(jFrame);
//        jFrame.add(index);
        Index index = new Index();
        jFrame.add(index);
        jFrame.setLocationRelativeTo(null);

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }
}
