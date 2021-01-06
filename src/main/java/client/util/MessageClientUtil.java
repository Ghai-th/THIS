package client.util;

import client.entity.Message;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Properties;

public class MessageClientUtil {
    public static int port;
    public static String host;
    public static Socket socket;
    public static OutputStream outputStream;
    public static ObjectOutputStream objectOutputStream;
    public static InputStream inputStream;
    public static ObjectInputStream objectInputStream;


    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File("db.properties")));
            port = Integer.parseInt(properties.getProperty("server.port"));
            host = properties.getProperty("message.host");
            socket = new Socket(host, port);
            outputStream = socket.getOutputStream();
            inputStream = socket.getInputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectInputStream = new ObjectInputStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向服务端发送消息对象包含时间和内容
     */
    public static void sendInfo(Message message) throws IOException {
        objectOutputStream.writeObject(message);
    }

    /**
     * 接受服务端发送的消息对象
     * @return 返回对象
     */
    public static Message acceptInfo() throws IOException, ClassNotFoundException {
        return (Message) objectInputStream.readObject();
    }

    public static HashMap accept() throws IOException, ClassNotFoundException {
        return (HashMap) objectInputStream.readObject();
    }

}
