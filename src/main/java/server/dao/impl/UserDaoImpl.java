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
    User user;
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
    public void deleteUser(String userId) {
        String sql = "delete from user where uid = '"+userId+"'";
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
    public void updateUserName(String uid,String name) {
        String sql = "update user set name = '" + name + "' where uid = '"+uid+"'";
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
    public void updateUserlevel(String uid) {
        try {
            String sql1 = "select * from user where uid = '"+uid+"'";
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            user = DBUtil.executeGetData(statement,sql1,User.class);
            int level =( user.getActive()+user.getArticleNum()+user.getAttentionNum()+user.getFansNum()+user.getVisitorNum())/5;
            String sql = "update user set level = '"+level+"'where uid = '"+uid+"'";
            DBUtil.executeChange(statement,sql);
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updateUserPassword(String uid,String password) {
        String sql = "update user set password = '" + password + "' where uid = '"+uid+"'";
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
    public void updateUserGender(String uid,Integer gender) {
        String sql = "update user set gender = '" + gender + "' where uid = '"+uid+"'";
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
    public void updateUserFansNum(String uid) {
        String sql = "select * from user where uid = '"+uid+"'";
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            user = DBUtil.executeGetData(statement,sql,User.class);
            String sql1 = "update user set fansnum = '"+(user.getFansNum()+1)+"' where uid = '"+uid+"'";
            DBUtil.executeChange(statement,sql1);
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserAttentionnum(String uid) {
        String sql = "select * from user where uid = '"+uid+"'";
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            user = DBUtil.executeGetData(statement,sql,User.class);
            String sql1 = "update user set attentionnum = '"+(user.getAttentionNum()+1)+"' where uid = '"+uid+"'";
            DBUtil.executeChange(statement,sql1);
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserVisitorNum(String uid) {
        String sql = "select * from user where uid = '"+uid+"'";
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            user = DBUtil.executeGetData(statement,sql,User.class);
            String sql1 = "update user set visitornum = '"+(user.getVisitorNum()+1)+"' where uid = '"+uid+"'";
            DBUtil.executeChange(statement,sql1);
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserArticleNum(String uid) {
        String sql = "select * from user where uid = '"+uid+"'";
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            user = DBUtil.executeGetData(statement,sql,User.class);
            String sql1 = "update user set articlenum = '"+(user.getArticleNum()+1)+"' where uid = '"+uid+"'";
            DBUtil.executeChange(statement,sql1);
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void updateUserLastLogin(String uid) {
        String sql = "update user set lastlogin = ? where uid = ?";
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            preparedStatement.setString(2,uid);
            preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserSynopsis(String uid,String synopsis) {
        String sql = "update user set synopsis = '" + synopsis + "' where uid = '"+uid+"'";
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
    public void updateUserActive(String uid) {
        String sql = "select * from user where uid = '"+uid+"'";
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            user = DBUtil.executeGetData(statement,sql,User.class);
            String sql1 = "update user set active = '"+(user.getActive()+1)+"' where uid = '"+uid+"'";
            DBUtil.executeChange(statement,sql1);
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserMyKey(String uid,Integer mykey) {
        String sql = "update user set mykey = '" + mykey + "' where uid = '"+uid+"'";
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
