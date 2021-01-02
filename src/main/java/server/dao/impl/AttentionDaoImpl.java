package server.dao.impl;

import client.entity.Attention;
import client.entity.User;
import server.dao.IAttentionDao;
import server.util.DBUtil;
import sun.security.pkcs11.Secmod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class AttentionDaoImpl implements IAttentionDao {
    //点击关注后，我被加入别人的粉丝中
    @Override
    public void addAttention(User user, String id) throws Exception{
        Connection connection = DBUtil.getConnection();
        Statement statement = DBUtil.getStatement(connection);
        String sql = "insert into attention values ('"+id+"','"+user.getUid()+"')";
        System.out.println(sql);
        statement.executeUpdate(sql);
        statement.close();
        connection.close();
    }
    //取消关注
    @Override
    public boolean deleteAttention(User user, String id) throws Exception {
        Connection connection = DBUtil.getConnection();
        String sql = "delete from attention where uid=?,fansid = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,user.getUid());
        preparedStatement.setString(2,id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        return false;
    }
    //查询我的粉丝
    @Override
    public List<Attention> searchAttention(User user) throws Exception{
        Connection connection = DBUtil.getConnection();
        String sql = "select fansid from attention where uid = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,user.getUid());
        preparedStatement.close();
        connection.close();
        return DBUtil.executeGetMoreData(preparedStatement,sql,Attention.class);
    }
    //查询我的关注
    @Override
    public List<Attention> selectAttention(User user) throws Exception {
        Connection connection = DBUtil.getConnection();
        String sql = "select uid from attention where fansid = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,user.getUid());
        preparedStatement.close();
        connection.close();
        return DBUtil.executeGetMoreData(preparedStatement,sql,Attention.class);
    }

}
