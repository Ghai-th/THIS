package server.dao.impl;

import client.entity.User;
import server.dao.IUserDao;
import server.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class UserDaoImpl implements IUserDao {
    Connection connection = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    List<User> users;
    @Override
    public boolean addUser(User user) {
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUid());
            preparedStatement.setString(2,user.getName());
            preparedStatement.setInt(3,user.getLevel());
            preparedStatement.setString(4,user.getPassword());
            preparedStatement.setInt(5,user.getGender());
            preparedStatement.setBytes(6,user.getImage());
            preparedStatement.setInt(7,user.getFansNum());
            preparedStatement.setInt(8,user.getAttentionNum());
            preparedStatement.setInt(9,user.getVisitorNum());
            preparedStatement.setInt(10,user.getArticleNum());
            preparedStatement.setString(11,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(user.getCreate()));
            preparedStatement.setString(12,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(user.getLastlogin()));
            preparedStatement.setString(13,user.getSynopsis());
            preparedStatement.setInt(14,user.getActive());
            preparedStatement.setInt(15,user.getMyKey());
            return preparedStatement.executeUpdate()!=0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            DBUtil.closeResources(connection,preparedStatement);
        }

    }

    @Override
    public boolean deleteUser(User user) {
        String sql = "delete from user where uid = '" + user.getUid() + "'";
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            return DBUtil.executeChange(statement, sql) != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.closeResources(connection, statement);
        }

    }

    @Override
    public boolean updateUserlevel(User user) {
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            int level =( user.getActive()+user.getArticleNum()+user.getAttentionNum()+user.getFansNum()+user.getVisitorNum())/5;
            String sql = "update user set level = '"+level+"'where uid = '"+user.getUid()+"'";
            return DBUtil.executeChange(statement,sql) != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            DBUtil.closeResources(connection,statement);
        }
    }

    @Override
    public boolean updateUserFansNum(User user) {
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            String sql = "update user set fansnum = '"+(user.getFansNum()+1)+"' where uid = '"+user.getUid() +"'";
            return DBUtil.executeChange(statement,sql) != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            DBUtil.closeResources(connection,statement);
        }
    }

    @Override
    public boolean updateUserAttentionnum(User user) {
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            String sql = "update user set attentionnum = '"+(user.getAttentionNum()+1)+"' where uid = '"+user.getUid()+"'";
            return DBUtil.executeChange(statement,sql) != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            DBUtil.closeResources(connection,statement);
        }
    }

    @Override
    public boolean updateUserVisitorNum(User user) {
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            String sql = "update user set visitornum = '"+(user.getVisitorNum()+1)+"' where uid = '"+user.getUid()+"'";
            return DBUtil.executeChange(statement,sql) != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return  false;
        }finally {
            DBUtil.closeResources(connection,statement);
        }
    }

    @Override
    public boolean updateUserArticleNum(User user) {
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            String sql = "update user set articlenum = '"+(user.getArticleNum()+1)+"' where uid = '"+user.getUid()+"'";
            return DBUtil.executeChange(statement,sql) != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            DBUtil.closeResources(connection,statement);
        }
    }

    @Override
    public boolean updateUserLastLogin(User user) {
        String sql = "update user set lastlogin = ? where uid = ?";
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            preparedStatement.setString(2,user.getUid());
            return preparedStatement.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            DBUtil.closeResources(connection,preparedStatement);
        }
    }

    @Override
    public boolean updateUserActive(User user) {
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            String sql = "update user set active = '"+(user.getActive()+1)+"' where uid = '"+user.getUid()+"'";
            return DBUtil.executeChange(statement,sql) != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            DBUtil.closeResources(connection,statement);
        }
    }

    @Override
    public boolean updateUser(User user) {
        String sql = "update user set name = ?,password = ?,gender = ?,synopsis = ?,mykey = ? where uid = ?";
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setInt(3,user.getGender());
            preparedStatement.setString(4,user.getSynopsis());
            preparedStatement.setInt(5,user.getMyKey());
            preparedStatement.setString(6,user.getUid());
            return preparedStatement.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            DBUtil.closeResources(connection,preparedStatement);
        }
    }

    @Override
    public List<User> selectUsers() {
        String sql = "select * from user";
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            users = DBUtil.executeGetMoreData(statement,sql,User.class);
            DBUtil.closeResources(connection,statement);
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
