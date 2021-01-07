package server.dao.impl;

import client.entity.Article;
import client.entity.Class;
import client.entity.Report;
import server.dao.IReportDao;
import server.util.DBUtil;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ReportDaoImpl implements IReportDao {
    private Connection connection = null;
    private Statement statement = null;
    ResultSet re = null;
    List<Report> list;

    /**
     *添加举报文章
     */
    @Override
    public void addReportArticle(Report report) {
        try{
            String sql = "insert into report values ('" + report.getAid()+ "' ,'" +report.getReportNum() + "')";
            connection = DBUtil.getConnection();
            statement = DBUtil.getStatement(connection);
            DBUtil.executeChange(statement, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeResources(connection, statement, re);
        }
    }
    /**
     *根据文章id删除举报文章
     */
    @Override
    public void deleteReportArticleByAid(String aid) {
        try {
            String sql = "delete from report where aid = '" + aid+ "'";
            connection = DBUtil.getConnection();
            statement = DBUtil.getStatement(connection);
            DBUtil.executeChange(statement,sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeResources(connection,statement,re);
        }
    }

    /**
     *根据文章id更新举报文章举报次数
     */
    @Override
    public void updateReportArticle(Report report) {
        try {
            String sql = "update from report set reportNum  ='" + report.getReportNum() +"'where aid = '"+ report.getAid() + "'";
            connection = DBUtil.getConnection();
            statement = DBUtil.getStatement(connection);
            DBUtil.executeChange(statement,sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeResources(connection,statement,re);
        }
    }
    /**
     * 根据文章id查找被举报文章
     */
    @Override
    public Report selectReportArticleByAid(String aid) {
        try {
            String sql = "select from report where aid= '" + aid +"'";
            connection = DBUtil.getConnection();
            statement = DBUtil.getStatement(connection);
            return DBUtil.executeGetData(statement,sql,Report.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeResources(connection,statement,re);
        }
        return null;
    }

    /**
     *查找所有被举报的文章
     */
    @Override
    public List<Report> selectReportArticle() {
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from report";
            statement = DBUtil.getStatement(connection);
            list = DBUtil.executeGetSomeReportData(statement,sql,Report.class);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResources(connection,statement,re);
        }
        return null;
    }

}
