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
        for (Article article : articleDao.selectTopLimitArticle(10)) {
            System.out.println(article);
        }
    }
    User u = new User("123","666");
    @Test
    public void testAddUser(){
        IUserService userService = new UserServiceImpl();
        userService.addUser(u);
    }
    @Test
    public void testDeleteUser(){
        IUserService userService = new UserServiceImpl();
        userService.deleteUser(u);
    }
    @Test
    public void testUpdateUserFansNum(){
        IUserService userService = new UserServiceImpl();
        userService.updateUserFansNum(u);
    }
    @Test
    public void testUpdateUserAttentionnum(){
        IUserService userService = new UserServiceImpl();
        userService.updateUserAttentionnum(u);
    }
    @Test
    public void testUpdateUserVisitorNum(){
        IUserService userService = new UserServiceImpl();
        userService.updateUserVisitorNum(u);
    }
    @Test
    public void testUpdateUserArticleNum(){
        IUserService userService = new UserServiceImpl();
        userService.updateUserArticleNum(u);
    }

    @Test
    public void testUpdateUserActive(){
        IUserService userService = new UserServiceImpl();
        userService.updateUserActive(u);
    }
    @Test
    public void testUpdateUser(){
        IUserService userService = new UserServiceImpl();
        userService.updateUser(u);
    }
//    @Test
//    public void testUpdateUserLastLogin(){
//        IUserService userService = new UserServiceImpl();
//        userService.updateUserLastLogin("123");
//    }
    @Test
    public void testSelectUsers(){
        IUserService userService = new UserServiceImpl();
        for(User u:userService.selectUsers()){
            System.out.println(u);
        }
    }
//    @Test
//    public void testUpdateUserlevel(){
//        IUserService userService = new UserServiceImpl();
//        userService.updateUserlevel("123");
//    }

    @Test
    public void testInsertMessage() throws SQLException {
        Message message = new Message("2222","李四","cnm","1","1","0");
        IMessageDao iMessageDao = new MessageDaoImpl();
        if(iMessageDao.emptyMessage(message)){
            iMessageDao.addMessage(message);
        }else{
            System.out.println("不为空");
            iMessageDao.updateMessage(message);
        }
        //iMessageDao.updateMessageSendNotice(message,"1");
        List<Message> messageList = iMessageDao.selectMessage(message);
        Iterator<Message> iterator = messageList.iterator();
        while(iterator.hasNext()){
            Message message1 = iterator.next();
            System.out.println(message1.getSendId()+"对"+message1.getAcceptId()+"说"+message1.getText()+"...."+message1.getState());
        }
    }

}
