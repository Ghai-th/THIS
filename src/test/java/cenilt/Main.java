package cenilt;

import entity.User;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",9000);
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(User.initUser());
        outputStream.close();
        objectOutputStream.close();
        socket.close();
    }
}
