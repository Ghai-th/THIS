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
    @Override
    public void addUser(User user) {
        String sql = "insert into user(uid,password) values('"+user.getUid()+"','"+user.getPassword()+"')";
        try {
            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
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
            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
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
            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
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
            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
            User user = DBUtil.executeGetData(statement,sql1,User.class);
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
            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
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
            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
            DBUtil.executeChange(statement,sql);
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updateUserFansNum(String uid,Integer fansNum) {
        String sql = "update user set fansnum = '" + fansNum + "' where uid = '"+uid+"'";
        try {
            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
            DBUtil.executeChange(statement,sql);
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserAttentionnum(String uid,Integer attentionNum) {
        String sql = "update user set attentionNum = '" + attentionNum + "' where uid = '"+uid+"'";
        try {
            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
            DBUtil.executeChange(statement,sql);
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserVisitorNum(String uid,Integer visitorNum) {
        String sql = "update user set visitornum = '" + visitorNum + "' where uid = '"+uid+"'";
        try {
            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
            DBUtil.executeChange(statement,sql);
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserArticleNum(String uid,Integer articleNum) {
        String sql = "update user set articlenum = '" + articleNum + "' where uid = '"+uid+"'";
        try {
            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
            DBUtil.executeChange(statement,sql);
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
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
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
            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
            DBUtil.executeChange(statement,sql);
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserActive(String uid,Integer active) {
        String sql = "update user set active = '"+(active + 1)+"' where uid = '"+uid+"'";
        try {
            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
            DBUtil.executeChange(statement,sql);
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
            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
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
            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
            List<User> users = DBUtil.executeGetMoreData(statement,sql,User.class);
            connection.close();
            statement.close();
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
