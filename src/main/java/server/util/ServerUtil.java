package server.util;

import client.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.Operate;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ServerUtil {

    public static Integer port;
    public static String host;
    public static ServerSocket serverSocket;
    public static Socket socket;
    public static OutputStream outputStream;
    public static ObjectOutputStream objectOutputStream;
    public static InputStream inputStream;
    public static ObjectInputStream objectInputStream;


    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("db.properties")));
            port = Integer.parseInt(properties.getProperty("server.port"));
            host = properties.getProperty("server.host");
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
            outputStream = socket.getOutputStream();
            inputStream = socket.getInputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectInputStream = new ObjectInputStream(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向客户端发送信息列表
     * @param list 信息
     */
    public static void sendInfoList(List list) throws IOException {
        objectOutputStream.writeObject(list);

    }

    /**
     * 向客户端发送对象
     * @param object 对象
     * @param clazz 反射
     * @param <T> 泛型
     */
    public static <T> void sendInfo(Object object, Class<T> clazz) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        T t = objectMapper.convertValue(object, clazz);
        objectOutputStream.writeObject(t);

    }

    /**
     * 获取客户端发送的对象
     * @param clazz 反射
     * @param <T> 泛型
     * @return 返回对象
     */
    public static <T> T acceptInfo(Class<T> clazz) throws IOException, ClassNotFoundException {
        ObjectMapper objectMapper = new ObjectMapper();
        T t = (T) objectInputStream.readObject();
        return objectMapper.convertValue(t,clazz);

    }

    /**
     * 接收搜索框数据
     * @return 返回搜索字符串
     */
    public static String acceptSearchInfo() throws IOException, ClassNotFoundException {
        return (String) objectInputStream.readObject();
    }

    /**
     * 接受客户端发送单指令的操作
     * @return 返回操作指令对象
     */
    public static Operate acceptOperate() throws IOException, ClassNotFoundException {
        return (Operate) objectInputStream.readObject();
    }

    /**
     * 向客户发送单指令
     * @param operate 指令对象
     */
    public static void sendOperate(Operate operate) throws IOException {
        objectOutputStream.writeObject(operate);
    }

}
