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

    /**
     * 增加关注
     * @param attention
     * @return返回true或者false
     */
    @Override
    public boolean addAttention(Attention attention) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DBUtil.getConnection();
            statement = DBUtil.getStatement(connection);
            String sql = "insert into attention values ('"+attention.getUid()+"','"+attention.getFansId()+"')";
            return statement.executeUpdate(sql)!=0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
           DBUtil.closeResources(connection,statement);
        }
    }

    /**
     * 取消关注
     * @param attention
     * @return返回true或者false
     */
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

    /**
     * 根据id查询粉丝
     * @param attention
     * @return 返回粉丝列表
     */
    @Override
    public List<Attention> searchAttention(Attention attention) {
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from attention where uid = '"+attention.getUid()+"'";
            Statement statement = DBUtil.getStatement(connection);

            return DBUtil.executeGetMoreData(statement,sql,Attention.class);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            DBUtil.closeResources(connection,preparedStatement);
        }



    }

    /**
     * 根据粉丝id查询关注
     * @param attention
     * @return 返回关注
     */
    @Override
    public List<Attention> selectAttention(Attention attention) {
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from attention where fansid = '"+attention.getFansId()+"'";
            Statement statement = DBUtil.getStatement(connection);
            return DBUtil.executeGetMoreData(statement,sql,Attention.class);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            DBUtil.closeResources(connection,preparedStatement);
        }



    }

}
