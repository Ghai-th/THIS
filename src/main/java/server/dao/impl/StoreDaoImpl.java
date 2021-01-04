package server.dao.impl;

import client.entity.Store;
import server.dao.IStoreDao;
import server.util.DBUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoreDaoImpl implements IStoreDao {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    /**
     * 添加收藏
     * @param store
     * @return 添加成功返回true，添加失败返回false
     */
    @Override
    public boolean addStore(Store store) {
        try {
            String sql = "insert into store values(???)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,store.getUid());
            preparedStatement.setString(2,store.getAid());
            preparedStatement.setDate(3, (Date) store.getTime());
            return  preparedStatement.executeUpdate()!=0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            DBUtil.closeResources(connection,preparedStatement);
        }


    }

    /**
     * 删除收藏
     * @param store
     * @return 删除成功返回true，删除失败返回false
     */
    @Override
    public boolean deleteStore(Store store) {
        try {
            String sql = "delete from store where uid = ? and aid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,store.getUid());
            preparedStatement.setString(2,store.getAid());
            return preparedStatement.executeUpdate()!=0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            DBUtil.closeResources(connection,preparedStatement);
        }

    }
}
