import client.entity.Article;
import client.entity.Message;
import client.entity.User;
import client.util.ClientUtil;
import org.junit.Test;
import server.dao.IArticleDao;
import server.dao.IMessageDao;
import server.dao.impl.ArticleDaoImpl;
import server.dao.impl.MessageDaoImpl;

import java.sql.SQLException;
import java.util.Date;


public class TestSql {
    @Test
    public void testAddArticle() {
        IArticleDao articleDao = new ArticleDaoImpl();
        articleDao.addArticle(Article.initArticle());
    }

    @Test
    public void testDeleteArticle() {
        IArticleDao articleDao = new ArticleDaoImpl();
        articleDao.deleteArticle(Article.initArticle().getAid());
    }

    @Test
    public void testUpdateArticle() {
        IArticleDao articleDao = new ArticleDaoImpl();
        articleDao.updateArticle(Article.initArticle());
    }

    @Test
    public void testSelectArticle() {
        IArticleDao articleDao = new ArticleDaoImpl();
        System.out.println(articleDao.selectArticleByAid(Article.initArticle().getAid()));
    }

    @Test
    public void testSelectTopTen() {
        IArticleDao articleDao = new ArticleDaoImpl();
        for (Article article : articleDao.selectTopTenArticle()) {
            System.out.println(article);
        }
    }

    @Test
    public void testInsertMessage() throws SQLException {
        Message message = new Message("4","2","1",1);
        IMessageDao iMessageDao = new MessageDaoImpl();
        iMessageDao.addMessage(message);
    }

}
