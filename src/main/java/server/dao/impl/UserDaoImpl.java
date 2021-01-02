package server.dao.impl;

import client.entity.User;
import server.dao.IUserDao;
import server.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
    public void deleteUser(User user) {
        String sql = "delete from User where "
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void selectUser(User user) {

    }
}
