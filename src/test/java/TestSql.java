import client.entity.Article;
import org.junit.Test;
import server.dao.IArticleDao;
import server.dao.impl.ArticleDaoImpl;


public class TestSql {
    @Test
    public void testAddArticle() {
        IArticleDao articleDao = new ArticleDaoImpl();

        articleDao.addArticle(Article.initArticle());
    }
}
