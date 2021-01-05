package server.dao.impl;

import client.entity.Article;
import server.dao.IArticleDao;
import server.util.DBUtil;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ArticleDaoImpl implements IArticleDao {

    private Statement statement = null;
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    @Override
    public boolean addArticle(Article article) {
        try {
            String sql = "insert into article values(?,?,?,?,?,?,?,?,?,?,?,?)";
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,article.getAid());
            preparedStatement.setString(2,article.getUid());
            preparedStatement.setString(3,article.getCid());
            preparedStatement.setString(4,article.getTitle());
            preparedStatement.setString(5,article.getSynopsis());
            preparedStatement.setString(6,article.getText());
            preparedStatement.setString(7,
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(article.getCreate()));
            preparedStatement.setString(8,
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(article.getRenewal()));
            preparedStatement.setInt(9,article.getVisitorNum());
            preparedStatement.setInt(10,article.getLikeNum());
            preparedStatement.setInt(11,article.getCollectNum());
            preparedStatement.setBlob(12,article.getImage());
            return  preparedStatement.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.closeResources(connection,preparedStatement);
        }
    }

    @Override
    public boolean deleteArticle(String aid) {
        try {
            String sql = "delete from article where aid = ?";
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,aid);
            return preparedStatement.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.closeResources(connection,preparedStatement);
        }
    }

    @Override
    public boolean updateArticle(Article article) {
        try {
            String sql = "update article set renewal = ?, visitornum = ?, likenum = ?,collectnum = ? where aid = ?";
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(article.getCreate()));
            preparedStatement.setInt(2,article.getVisitorNum());
            preparedStatement.setInt(3,article.getLikeNum());
            preparedStatement.setInt(4,article.getCollectNum());
            preparedStatement.setString(5,article.getAid());
            return preparedStatement.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.closeResources(connection, preparedStatement);
        }
    }

    @Override
    public Article selectArticleByAid(String aid) {
        try {
            String sql = "select * from article where aid = '" + aid + "'";
            connection = DBUtil.getConnection();
            statement = DBUtil.getStatement(connection);
            return DBUtil.executeGetData(statement, sql, Article.class);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeResources(connection,statement);
        }
    }

    @Override
    public List<Article> selectArticleByCid(String cid) {
        try {
            String sql = "select * from article where cid = '" + cid + "'";
            connection = DBUtil.getConnection();
            statement = DBUtil.getStatement(connection);
            return  DBUtil.executeGetMoreData(statement,sql,Article.class);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeResources(connection,statement);
        }
    }

    @Override
    public List<Article> selectArticleByTittle(String title) {
        try {
            String sql = "select * from article where title like '%" + title + "%'";
            connection = DBUtil.getConnection();
            statement = DBUtil.getStatement(connection);
            return DBUtil.executeGetMoreData(statement,sql,Article.class);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeResources(connection,statement);
        }
    }

    @Override
    public List<Article> selectArticleByUid(String uid) {
        try {
            String sql = "select * from article where uid = '" + uid + "'" ;
            connection = DBUtil.getConnection();
            statement = DBUtil.getStatement(connection);
            return DBUtil.executeGetMoreData(statement,sql,Article.class);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeResources(connection,statement);
        }
    }

    @Override
    public List<Article> selectTopLimitArticle(int limit) {
        try {
            List<Article> articles = new ArrayList<Article>();
            String sql = "select article.* from article order by (article.visitornum + article.likenum + article.collectnum) desc limit " + limit;
            connection = DBUtil.getConnection();
            statement = DBUtil.getStatement(connection);
            articles = DBUtil.executeGetMoreData(statement,sql,Article.class);
            return articles;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeResources(connection,statement);
        }
    }

    @Override
    public List<Article> selectTopLimitArticleByCid(String cid, int limit) {
        try {
            List<Article> articles = new ArrayList<Article>();
            String sql = "select article.* from article where cid = '" + cid + "' order by (article.visitornum + article.likenum + article.collectnum) desc limit " + limit;
            connection = DBUtil.getConnection();
            statement = DBUtil.getStatement(connection);
            articles = DBUtil.executeGetMoreData(statement,sql,Article.class);
            return articles;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeResources(connection,statement);
        }
    }

    @Override
    public int selectAllArticleNum(String uid) {
        int integer = 0;
        try {
            connection = DBUtil.getConnection();
            String sql = "select count(*) num from article";
            statement = DBUtil.getStatement(connection);
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                integer = resultSet.getInt("num");
            }
            return integer;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeResources(connection, statement,resultSet);
        }
        return 0;
    }
}
