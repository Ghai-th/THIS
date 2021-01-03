package client.util;

import client.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.Operate;

import java.io.*;
import java.net.Socket;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * 向服务器传送单指令、指令加对象
 * 接受服务器的 对象 list
 */
public class ClientUtil {

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
            host = properties.getProperty("server.host");
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
     * 发送对象加指令
     *
     * @param object 发送的对象
     * @param clazz  反射
     * @param <T>    对象
     */
    public static <T> void sendInfo(Object object, Class<T> clazz) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        T t = objectMapper.convertValue(object, clazz);
        objectOutputStream.writeObject(t);
    }

    /**
     * 发送搜索框信息
     *
     * @param string 查询字符串
     */
    public static void sendSearchInfo(String string) throws IOException {
        objectOutputStream.writeObject(string);
    }

    /**
     * 向服务器发送单指令
     *
     * @param operate 指令对象
     */
    public static void sendOperate(Operate operate) throws IOException {
        objectOutputStream.writeObject(operate);
    }

    /**
     * 获取服务器返回的信息
     *
     * @return 返回信息的list
     */
    public static List acceptList() throws IOException, ClassNotFoundException {
        return Collections.unmodifiableList((List) objectInputStream.readObject());
    }

    /**
     * 获取服务器发送的对象
     *
     * @param <T>   泛型
     * @param clazz 反射
     * @return 返回对象
     */
    public static <T> T acceptInfo(Class<T> clazz) throws IOException, ClassNotFoundException {
        ObjectMapper objectMapper = new ObjectMapper();
        T t = (T) objectInputStream.readObject();
        return objectMapper.convertValue(t, clazz);
    }

}
