import client.Client;
import client.entity.*;
import client.util.ClientUtil;
//import com.sun.org.apache.xml.internal.security.keys.storage.StorageResolverException;
import org.junit.Test;
import server.controller.ServerOperate;
import server.dao.IArticleDao;
import server.dao.IUserDao;
import server.dao.IMessageDao;
import server.dao.impl.ArticleDaoImpl;
import server.dao.impl.UserDaoImpl;
import server.service.IAttentionService;
import server.service.ICommentService;
import server.service.IStoreService;
import server.service.IUserService;
import server.service.impl.AttentionServiceImpl;
import server.service.impl.CommentServiceImpl;
import server.service.impl.StoreServiceImpl;
import server.service.impl.UserServiceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.util.*;

import server.dao.impl.MessageDaoImpl;
import server.util.DBUtil;

import java.sql.SQLException;


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
//            iMessageDao.addMessage(message);
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
    @Test
    public void testAttention(){
        IAttentionService attentionService = new AttentionServiceImpl();
        List<Attention> list = new ArrayList<>();
        Attention attention = new Attention();
        attention.setUid("123456");
        attention.setFansId("6666666");
        //attentionService.addAttention(attention);
        list = attentionService.selectAttention(attention);
        System.out.println(list.size());
    }
    @Test
    public void testStore(){
        Store store = new Store();
        store.setUid("88888");
        store.setAid("555555");
        store.setTime(new Date(10));
        IStoreService storeService = new StoreServiceImpl();

        List<Store> list = new ArrayList<>();
        list .addAll(storeService.selectStore(store));
        System.out.println(list.size());
    }

    @Test
    public void testDate() throws SQLException {
        Connection connection = DBUtil.getConnection();
        Statement statement = DBUtil.getStatement(connection);
        String sql = "select * from user where uid = '123'";
        System.out.println(DBUtil.executeGetSomeUserData(statement, sql, User.class));
    }
    @Test
    public void testComment(){
        Comment comment = new Comment();
        comment.setCid("10001");
        ICommentService commentService = new CommentServiceImpl();
        commentService.deleteComment(comment);
    }

    @Test
    public void testReport() {
        Report report = new Report();
        report.setAid("123");
        report.setReportNum(1);
        report.operate = ServerOperate.ADD_REPORT_ARTICLE;

        try {
            ClientUtil.sendInfo(report,Report.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
