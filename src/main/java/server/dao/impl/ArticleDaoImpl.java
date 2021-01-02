package server.dao.impl;

import client.entity.Article;
import server.dao.IArticleDao;
import server.util.DBUtil;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class ArticleDaoImpl implements IArticleDao {

    private Statement statement = null;
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    @Override
    public boolean addArticle(Article article) {
        int num = 0;
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
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(article.getUpdate()));
            preparedStatement.setInt(9,article.getVisitorNum());
            preparedStatement.setInt(10,article.getLikeNum());
            preparedStatement.setInt(11,article.getCollectNum());
            preparedStatement.setBlob(12,article.getImage());
            num = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResources(connection,preparedStatement);
            return num != 0;
        }
    }

    @Override
    public boolean deleteArticle(String aid) {
        return false;
    }
}
