package server.utiles;

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
     *
     * @return
     * @throws SQLException
     */
    public static Statement getStatement(Connection conn) throws SQLException {
        return conn.createStatement();
    }

    /**
     * 通用DML操作工具方法
     *
     * @param stat
     * @param sql
     * @return
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
     *
     * @param <T>
     * @param stat
     * @param sql
     * @param clz
     * @return
     */
    public static <T> T executeGetData(Statement stat, String sql, Class<T> clz) {
        try {
            // 拿到当前JavaBean对象的所有属性
            Field[] fields = clz.getDeclaredFields();
            // 查询数据库数据
            ResultSet set = stat.executeQuery(sql);
            // 根据数据库数据设置值
            if (set.next()) {
                // 通过反射构建JavaBean对象
                T t = clz.newInstance();
                for (int i = 0; i < fields.length; i++) {
                    Field field = fields[i];
//                    System.out.println(field.getName());
                    field.setAccessible(true);
                    Object object = set.getObject(field.getName());
//                    System.out.println(object);
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
     * 通用DQL操作工具方法 查询多条数据
     *
     * @param <T>
     * @param stat
     * @param sql
     * @param clz
     * @return
     */
    public static <T> List<T> executeGetMoreData(Statement stat, String sql, Class<T> clz) {
        List<T> list = new ArrayList<T>();
        try {
            // 拿到当前JavaBean对象的所有属性
            Field[] fields = clz.getDeclaredFields();
            // 查询数据库数据
            ResultSet set = stat.executeQuery(sql);
            // 根据数据库数据设置值
            while (set.next()) {
                // 通过反射构建JavaBean对象
                T t = clz.newInstance();
                for (int i = 0; i < fields.length; i++) {
                    Field field = fields[i];
                    if (field.getName().equals("cart")) {
                        continue;
                    }
                    field.setAccessible(true);
                    field.set(t, set.getObject(field.getName()));
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return list;
    }


    /**
     * 关闭SQL操作类型的有关资源
     *
     * @param conn
     * @param stat
     */
    public static void closeResources(Connection conn, Statement stat, ResultSet set) {
        if (set != null) {
            try {
                set.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

    /**
     * 关闭SQL操作类型的有关资源
     *
     * @param conn
     * @param stat
     */
    public static void closeResources(Connection conn, Statement stat) {
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}
