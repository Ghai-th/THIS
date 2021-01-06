package server.util;

import client.entity.Message;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class MessageServerUtil {

    public static Integer port;
    public static String host;
    public static ServerSocket serverSocket;
    public Socket socket;
    public OutputStream outputStream;
    public ObjectOutputStream objectOutputStream;
    public InputStream inputStream;
    public ObjectInputStream objectInputStream;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("db.properties")));
            port = Integer.parseInt(properties.getProperty("server.port"));
            host = properties.getProperty("message.host");
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MessageServerUtil() throws IOException {
        socket = serverSocket.accept();
        outputStream = socket.getOutputStream();
        inputStream = socket.getInputStream();
        objectOutputStream = new ObjectOutputStream(outputStream);
        objectInputStream = new ObjectInputStream(inputStream);
    }

    /**
     * 向客户端发送消息对象包含时间和内容
     */
    public void sendMessage(Message message) throws IOException {
        objectOutputStream.writeObject(message);
    }

    /**
     * 接受客户端发送的消息对象
     * @return 返回对象
     */
    public Message acceptMessage() throws IOException, ClassNotFoundException {
        return (Message) objectInputStream.readObject();
    }


    public void sendMessageHashMap(HashMap hashMap) throws IOException {
        objectOutputStream.writeObject(hashMap);
    }

    public void sendMessageList(List list) throws IOException {
        objectOutputStream.writeObject(list);
    }
}
