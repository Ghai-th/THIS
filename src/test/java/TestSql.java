import client.entity.Article;
import client.entity.User;
import client.util.ClientUtil;
import org.junit.Test;
import server.dao.IArticleDao;
import server.dao.IUserDao;
import server.dao.impl.ArticleDaoImpl;
import server.dao.impl.UserDaoImpl;
import server.service.IUserService;
import server.service.impl.UserServiceImpl;

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
    public void testAddUser(){
        IUserService userService = new UserServiceImpl();
        User u = new User("123","555");
        userService.addUser(u);
    }
    @Test
    public void testDeleteUser(){
        IUserService userService = new UserServiceImpl();
        userService.deleteUser("123");
    }
    @Test
    public void testUpdateUserName(){
        IUserService userService = new UserServiceImpl();
        userService.updateUserName("123","ahhaha");
    }
    @Test
    public void testUpdateUserPassword(){
        IUserService userService = new UserServiceImpl();
        userService.updateUserPassword("123","666");
    }
    @Test
    public void testUpdateUserGender(){
        IUserService userService = new UserServiceImpl();
        userService.updateUserGender("123",5);
    }
    @Test
    public void testUpdateUserFansNum(){
        IUserService userService = new UserServiceImpl();
        userService.updateUserFansNum("123",15);
    }
    @Test
    public void testUpdateUserAttentionnum(){
        IUserService userService = new UserServiceImpl();
        userService.updateUserAttentionnum("123",20);
    }
    @Test
    public void testUpdateUserVisitorNum(){
        IUserService userService = new UserServiceImpl();
        userService.updateUserVisitorNum("123",25);
    }
    @Test
    public void testUpdateUserArticleNum(){
        IUserService userService = new UserServiceImpl();
        userService.updateUserArticleNum("123",30);
    }
    @Test
    public void testUpdateUserSynopsis(){
        IUserService userService = new UserServiceImpl();
        userService.updateUserSynopsis("123","啦啦啦");
    }
    @Test
    public void testUpdateUserActive(){
        IUserService userService = new UserServiceImpl();
        userService.updateUserActive("123",15);
    }
    @Test
    public void testUpdateUserKey(){
        IUserService userService = new UserServiceImpl();
        userService.updateUserMyKey("123",12);
    }
    @Test
    public void testUpdateUserLastLogin(){
        IUserService userService = new UserServiceImpl();
        userService.updateUserLastLogin("123");
    }
    @Test
    public void testSelectUsers(){
        IUserService userService = new UserServiceImpl();
        for(User u:userService.selectUsers()){
            System.out.println(u);
        }
    }
    @Test
    public void testUpdateUserlevel(){
        IUserService userService = new UserServiceImpl();
        userService.updateUserlevel("123");
    }
}
