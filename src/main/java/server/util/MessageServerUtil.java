package server.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.MessageInfo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
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
    public void sendMessageInfo(MessageInfo messageInfo) throws IOException {
        objectOutputStream.writeObject(messageInfo);
    }

    /**
     * 接受客户端发送的消息对象
     * @return 返回对象
     */
    public MessageInfo acceptMessageInfo() throws IOException, ClassNotFoundException {
        return (MessageInfo) objectInputStream.readObject();
    }

}
