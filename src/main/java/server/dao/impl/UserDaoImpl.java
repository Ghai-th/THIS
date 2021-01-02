package server.dao.impl;

import client.entity.User;
import server.dao.IUserDao;
import server.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;


public class UserDaoImpl implements IUserDao {
    @Override
    public void addUser(User user) {
        String sql = "insert into User values('"+user.getUid()+"','"+user.getPassword()+"')";
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
        String sql = "delete from User where uid = '"+userId+"'";
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
    public void updateUserName(String name) {
        String sql = "update User set name = '" + name + "'";
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
    public void updateUserPassword(String password) {
        String sql = "update User set password = '" + password + "'";
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
    public void updateUserGender(Integer gender) {
        String sql = "update User set gender = '" + gender + "'";
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
    public void updateUserImage(Byte[] image) {
        String sql = "update User set image = '" + image + "'";
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
    public void updateUserFansNum(Integer fansNum) {
        String sql = "update User set fansnum = '" + fansNum + "'";
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
    public void updateUserAttentionnum(Integer attentionNum) {
        String sql = "update User set attentionNum = '" + attentionNum + "'";
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
    public void updateUserVisitorNum(Integer visitorNum) {
        String sql = "update User set visitornum = '" + visitorNum + "'";
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
    public void updateUserArticleNum(Integer articleNum) {
        String sql = "update User set articlenum = '" + articleNum + "'";
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
    public void updateUserCreate(Date create) {
        String sql = "update User set create = '" + create + "'";
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
    public void updateUserUpdate(Date update) {
        String sql = "update User set update = '" + update + "'";
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
    public void updateUserSynopsis(String synopsis) {
        String sql = "update User set synopsis = '" + synopsis + "'";
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
    public void updateUserActive(Integer active) {
        String sql = "update User set active = '" + active + "'";
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
        String sql = "select * form User";
        try {
            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
            List<User> users = DBUtil.executeGetMoreData(statement,sql,User.class);
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
