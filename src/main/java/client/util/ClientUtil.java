package client.util;

import client.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.Socket;
import java.util.Collections;
import java.util.List;

/**
 * 向服务器传送单指令、指令加对象
 * 接受服务器的 对象 list
 */
public class ClientUtil {

    public static Socket socket;
    public static OutputStream outputStream;
    public static ObjectOutputStream objectOutputStream;
    public static InputStream inputStream;
    public static ObjectInputStream objectInputStream;

    static {
        try {
            socket = new Socket("localhost",2222);
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
     * @param object 发送的对象
     * @param clazz 反射
     * @param <T> 对象
     */
    public static <T> void sendInfo(Object object, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
         T t = objectMapper.convertValue(object, clazz);
        try {
            objectOutputStream.writeObject(t);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送搜索框信息
     * @param string 查询字符串
     */
    public static void sendSearchInfo(String string) {
        try {
            objectOutputStream.writeObject(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取服务器返回的信息
     * @return 返回信息的list
     */
    public static List acceptList() {
        try {
             return Collections.unmodifiableList((List) objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取服务器发送的对象
     * @param <T> 泛型
     * @param clazz 反射
     * @return 返回对象
     */
    public static <T> T acceptInfo(Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
             T t = (T) objectInputStream.readObject();
            return objectMapper.convertValue(t,clazz);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        System.out.println(ClientUtil.acceptInfo(User.class));
    }

}
