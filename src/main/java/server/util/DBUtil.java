package server.util;

import client.entity.Article;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBUtil {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    /**
     * 静态代码块提前加载数据库驱动
     */
    static {
        // 定义一个Map集合--Properties
        Properties properties = new Properties();
        try {
            // 使用Properties集合的load方法加载配置文件
            properties.load(new FileInputStream(new File("db.properties")));
            driver = properties.getProperty("jdbc.driver");
            url = properties.getProperty("jdbc.url");
            user = properties.getProperty("jdbc.user");
            password = properties.getProperty("jdbc.password");
            // 加载驱动
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取链接方法
     * @return 返回链接对象
     * @throws SQLException 数据库异常
     */
    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    /**
     * 获取执行sql对象的方法
     * @return 返回连接对象
     * @throws SQLException 异常
     */
    public static Statement getStatement(Connection conn) throws SQLException {
        return conn.createStatement();
    }

    /**
     * 通用DML操作工具方法
     * @param stat 查询对象
     * @param sql sql
     * @return 返回 查询集合
     */
    public static int executeChange(Statement stat, String sql) {
        int executeUpdate = 0;
        try {
            executeUpdate = stat.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return executeUpdate;
    }

    /**
     * 通用DQL操作工具方法 查询单条
     * @param <T> 泛型
     * @param stat 查寻界面
     * @param sql 语句
     * @param clz class对象
     * @return 查询结果
     */
    public static <T> T executeGetData(Statement stat, String sql, Class<T> clz) {
        try {
            Field[] fields = clz.getDeclaredFields();
            ResultSet set = stat.executeQuery(sql);
            if (set.next()) {
                T t = clz.newInstance();
                for (int i = 0; i < fields.length; i++) {
                    Field field = fields[i];
                    field.setAccessible(true);
                    if (field.getName().equals("operate")) {
                        continue;
                    }
                    if (field.getName().equals("serialVersionUID")) {
                        continue;
                    }
                    Object object = set.getObject(field.getName());
                    field.set(t, object);
                }
                return t;
            }
            return null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return null;
    }

    /**
     * 通用DQL操作工具方法 查询多条数
     * @param <T> 泛型
     * @param stat 查询对象
     * @param sql sql
     * @param clz class对象
     * @return 返回查询集合
     */
    public static <T> List<T> executeGetMoreData(Statement stat, String sql, Class<T> clz) {
        List<T> list = new ArrayList<T>();
        try {
            Field[] fields = clz.getDeclaredFields();
            ResultSet set = stat.executeQuery(sql);
            while (set.next()) {
                T t = clz.newInstance();
                for (int i = 0; i < fields.length; i++) {
                    Field field = fields[i];
                    if (field.getName().equals("operate")) {
                        continue;
                    }
                    if (field.getName().equals("serialVersionUID")) {
                        continue;
                    }
                    field.setAccessible(true);
                    field.set(t, set.getObject(field.getName()));
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 关闭SQL操作类型的有关资源
     * @param conn 连接对象
     * @param stat 查询对象
     */
    public static void closeResources(Connection conn, Statement stat, ResultSet set) {
        if (set != null) {
            try {
                set.close();int x;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stat != null) {
            try {
                int y;
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 关闭SQL操作类型的有关资源
     *
     * @param conn 连接对象
     * @param stat 查询对象
     */
    public static void closeResources(Connection conn, Statement stat) {
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public static <T> List<T> executeGetSomeUserData(Statement stat, String sql, Class<T> clz) {
        List<T> list = new ArrayList<T>();
        try {
            Field[] fields = clz.getDeclaredFields();
            ResultSet set = stat.executeQuery(sql);
            while (set.next()) {
                T t = clz.newInstance();
                for (int i = 0; i < fields.length; i++) {
                    Field field = fields[i];
                    if (field.getName().equals("operate")) {
                        continue;
                    }
                    if (field.getName().equals("serialVersionUID")) {
                        continue;
                    }
                    if (field.getName().equals("password")) {
                        continue;
                    }
                    if (field.getName().equals("image")) {
                        continue;
                    }
                    if (field.getName().equals("mykey")) {
                        continue;
                    }
                    field.setAccessible(true);
                    field.set(t, set.getObject(field.getName()));
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static <T> List<T> executeGetSomeReportData(Statement stat, String sql, Class<T> clz) {
        List<T> list = new ArrayList<T>();
        try {
            Field[] fields = clz.getDeclaredFields();
            ResultSet set = stat.executeQuery(sql);
            while (set.next()) {
                T t = clz.newInstance();
                for (int i = 0; i < fields.length; i++) {
                    Field field = fields[i];
                    if (field.getName().equals("operate")) {
                        continue;
                    }
                    if (field.getName().equals("serialVersionUID")) {
                        continue;
                    }
                    if (field.getName().equals("aid")) {
                        continue;
                    }
                    field.setAccessible(true);
                    field.set(t, set.getObject(field.getName()));
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static <T> List<T> executeGetSomeArticleData(Statement statement, String sql, Class<T> articleClass) {
        List<T> list = new ArrayList<T>();
        try {
            Field[] fields = articleClass.getDeclaredFields();
            ResultSet set = statement.executeQuery(sql);
            while (set.next()) {
                T t = articleClass.newInstance();
                for (int i = 0; i < fields.length; i++) {
                    Field field = fields[i];
                    if (field.getName().equals("operate")) {
                        continue;
                    }
                    if (field.getName().equals("serialVersionUID")) {
                        continue;
                    }
                    if (field.getName().equals("image")) {
                        continue;
                    }
                    field.setAccessible(true);
                    field.set(t, set.getObject(field.getName()));
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
