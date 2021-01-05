package server.dao.impl;

import client.entity.Class;
import server.dao.IClassDao;
import server.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class ClassDaoImpl implements IClassDao {

    private Connection connection = null;
    private Statement statement = null;

    @Override
    public Class selectClassById(String cid) {
        String sql = "select * from class where cid =  '" + cid + "'";
        Class re = null;
        try {
            connection = DBUtil.getConnection();
            statement = DBUtil.getStatement(connection);
            return DBUtil.executeGetData(statement, sql, Class.class);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeResources(connection, statement);
        }
    }

    @Override
    public List selectAllClass() {
        try{
            String sql = "select * from class ";
            connection = DBUtil.getConnection();
            statement = DBUtil.getStatement(connection);
            return DBUtil.executeGetMoreData(statement,sql, Class.class);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }finally {
            DBUtil.closeResources(connection,statement);
        }
    }
}
