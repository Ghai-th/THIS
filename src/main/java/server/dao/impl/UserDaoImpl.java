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
    public void addUser(User user) {
        String sql = "insert into user(uid,password) values('"+user.getUid()+"','"+user.getPassword()+"')";
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            DBUtil.executeChange(statement,sql);
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteUser(User user) {
        String sql = "delete from user where uid = '"+user.getUid()+"'";
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            DBUtil.executeChange(statement,sql);
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateUserlevel(User user) {
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            int level =( user.getActive()+user.getArticleNum()+user.getAttentionNum()+user.getFansNum()+user.getVisitorNum())/5;
            String sql = "update user set level = '"+level+"'where uid = '"+user.getUid()+"'";
            DBUtil.executeChange(statement,sql);
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserFansNum(User user) {
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            String sql = "update user set fansnum = '"+(user.getFansNum()+1)+"' where uid = '"+user.getUid() +"'";
            DBUtil.executeChange(statement,sql);
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserAttentionnum(User user) {
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            String sql = "update user set attentionnum = '"+(user.getAttentionNum()+1)+"' where uid = '"+user.getUid()+"'";
            DBUtil.executeChange(statement,sql);
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserVisitorNum(User user) {
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            String sql1 = "update user set visitornum = '"+(user.getVisitorNum()+1)+"' where uid = '"+user.getUid()+"'";
            DBUtil.executeChange(statement,sql1);
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserArticleNum(User user) {
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            String sql1 = "update user set articlenum = '"+(user.getArticleNum()+1)+"' where uid = '"+user.getUid()+"'";
            DBUtil.executeChange(statement,sql1);
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserLastLogin(User user) {
        String sql = "update user set lastlogin = ? where uid = ?";
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            preparedStatement.setString(2,user.getUid());
            preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserActive(User user) {
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            String sql = "update user set active = '"+(user.getActive()+1)+"' where uid = '"+user.getUid()+"'";
            DBUtil.executeChange(statement,sql);
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
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
            preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> selectUsers() {
        String sql = "select * from user";
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            users = DBUtil.executeGetMoreData(statement,sql,User.class);
            connection.close();
            statement.close();
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
