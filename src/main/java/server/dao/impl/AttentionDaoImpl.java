package server.dao.impl;

import client.entity.Attention;
import server.dao.IAttentionDao;
import server.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AttentionDaoImpl implements IAttentionDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    //点击关注后，我被加入别人的粉丝中
    @Override
    public boolean addAttention(Attention attention) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DBUtil.getConnection();
            statement = DBUtil.getStatement(connection);
            String sql = "insert into attention values ('"+attention.getFansId()+"','"+attention.getUid()+"')";
            return statement.executeUpdate(sql)!=0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
           DBUtil.closeResources(connection,statement);
        }
    }
    //取消关注
    @Override
    public boolean deleteAttention(Attention attention) {
        try {
            connection = DBUtil.getConnection();
            String sql = "delete from attention where uid=?,fansid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, attention.getUid());
            preparedStatement.setString(2, attention.getFansId());
            return preparedStatement.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.closeResources(connection,preparedStatement);
        }

    }
    //查询我的粉丝
    @Override
    public List<Attention> searchAttention(Attention attention) {
        try {
            connection = DBUtil.getConnection();
            String sql = "select fansid from attention where uid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,attention.getUid());
            return DBUtil.executeGetMoreData(preparedStatement,sql,Attention.class);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            DBUtil.closeResources(connection,preparedStatement);
        }



    }
    //查询我的关注
    @Override
    public List<Attention> selectAttention(Attention attention) {
        try {
            connection = DBUtil.getConnection();
            String sql = "select uid from attention where fansid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,attention.getUid());
            return DBUtil.executeGetMoreData(preparedStatement,sql,Attention.class);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            DBUtil.closeResources(connection,preparedStatement);
        }



    }

}
