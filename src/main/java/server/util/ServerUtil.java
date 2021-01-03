package server.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.Operate;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Properties;

public class ServerUtil {

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
            host = properties.getProperty("server.host");
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() throws IOException {
        socket = serverSocket.accept();
        outputStream = socket.getOutputStream();
        inputStream = socket.getInputStream();
        objectOutputStream = new ObjectOutputStream(outputStream);
        objectInputStream = new ObjectInputStream(inputStream);
    }

    /**
     * 向客户端发送信息列表
     * @param list 信息
     */
    public void sendInfoList(List list) throws IOException {
        objectOutputStream.writeObject(list);

    }

    /**
     * 向客户端发送对象
     * @param object 对象
     * @param clazz 反射
     * @param <T> 泛型
     */
    public <T> void sendInfo(Object object, Class<T> clazz) throws IOException {
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
    public <T> T acceptInfo(Class<T> clazz) throws IOException, ClassNotFoundException {
        ObjectMapper objectMapper = new ObjectMapper();
        T t = (T) objectInputStream.readObject();
        return objectMapper.convertValue(t,clazz);

    }

    /**
     * 接收搜索框数据
     * @return 返回搜索字符串
     */
    public String acceptSearchInfo() throws IOException, ClassNotFoundException {
        return (String) objectInputStream.readObject();
    }

    /**
     * 接受客户端发送单指令的操作
     * @return 返回操作指令对象
     */
    public Operate acceptOperate() throws IOException, ClassNotFoundException {
        return (Operate) objectInputStream.readObject();
    }

    /**
     * 向客户发送单指令
     * @param operate 指令对象
     */
    public void sendOperate(Operate operate) throws IOException {
        objectOutputStream.writeObject(operate);
    }

}
