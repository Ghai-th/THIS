import client.entity.Article;
import client.entity.Message;
import client.entity.User;
import client.util.ClientUtil;
import org.junit.Test;
import server.dao.IArticleDao;
import server.dao.IUserDao;
import server.dao.IMessageDao;
import server.dao.impl.ArticleDaoImpl;
import server.dao.impl.UserDaoImpl;
import server.service.IUserService;
import server.service.impl.UserServiceImpl;

import java.util.Date;
import server.dao.impl.MessageDaoImpl;

import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


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
        userService.updateUserName("123","666");
    }
    @Test
    public void testUpdateUserPassword(){
        IUserService userService = new UserServiceImpl();
        userService.updateUserPassword("123","888");
    }
    @Test
    public void testUpdateUserGender(){
        IUserService userService = new UserServiceImpl();
        userService.updateUserGender("123",0);
    }
    @Test
    public void testUpdateUserFansNum(){
        IUserService userService = new UserServiceImpl();
        userService.updateUserFansNum("123");
    }
    @Test
    public void testUpdateUserAttentionnum(){
        IUserService userService = new UserServiceImpl();
        userService.updateUserAttentionnum("123");
    }
    @Test
    public void testUpdateUserVisitorNum(){
        IUserService userService = new UserServiceImpl();
        userService.updateUserVisitorNum("123");
    }
    @Test
    public void testUpdateUserArticleNum(){
        IUserService userService = new UserServiceImpl();
        userService.updateUserArticleNum("123");
    }
    @Test
    public void testUpdateUserSynopsis(){
        IUserService userService = new UserServiceImpl();
        userService.updateUserSynopsis("123","789789");
    }
    @Test
    public void testUpdateUserActive(){
        IUserService userService = new UserServiceImpl();
        userService.updateUserActive("123");
    }
    @Test
    public void testUpdateUserKey(){
        IUserService userService = new UserServiceImpl();
        userService.updateUserMyKey("123",13);
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

    @Test
    public void testInsertMessage() throws SQLException {
        Message message = new Message("张三","李四","cnm","1");
        IMessageDao iMessageDao = new MessageDaoImpl();
        if(iMessageDao.emptyMessage(message)){
            iMessageDao.addMessage(message);
        }else{
            System.out.println("不为空");
            iMessageDao.updateMessage(message);
        }
        List<Message> messageList = iMessageDao.selectMessage(message);
        Iterator<Message> iterator = messageList.iterator();
        while(iterator.hasNext()){
            Message message1 = iterator.next();
            System.out.println(message1.getSendId()+"对"+message1.getAcceptId()+"说"+message1.getText()+"...."+message1.getState());
        }
    }

}
