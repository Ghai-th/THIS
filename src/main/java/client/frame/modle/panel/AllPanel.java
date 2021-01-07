package client.frame.modle.panel;

import client.entity.Article;
import client.entity.Comment;
import client.entity.Store;
import client.entity.User;
import client.frame.Index;
import client.util.ClientUtil;
import server.controller.ServerOperate;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AllPanel extends JPanel{
    JLabel j;
    public Index index;
    User myUser,otherUser;
    List<Comment> commentList;
    List<Store> storeList;
    List<Article> articleList;
    public AllPanel(User myUser){
        this.myUser = myUser;
        init();
    }
    public AllPanel(User myUser,User otherUser){
        this.myUser = myUser;
        this.otherUser = otherUser;
        init();
    }
    public AllPanel(User myUser, User otherUser, Index index, List<Comment> commentList, List<Store> storeList, List<Article> articleList){
        this.commentList = commentList;
        this.storeList = storeList;
        this.articleList = articleList;
        this.myUser = myUser;
        this.otherUser = otherUser;
        this.index = index;
        init();
    }
    public void init(){
        setLayout(null);
        UserPanel userPanel = new UserPanel(myUser,otherUser,index,this,commentList,storeList,articleList);
//        Thread thread = new Thread(userPanel);
//        thread.start();
        ImageIcon Image=new ImageIcon("src/main/resources/屏幕截图 2020-12-30 223025.png");
        j = new JLabel(Image);
        j.setBounds(0,0,1920,1080);
        setBounds(0,0,1920,1080);
        add(userPanel);
        add(j);
    }

    public AllPanel(Index index, User myUser, User otherUser) {
        this.index = index;
        this.myUser = myUser;
        this.otherUser = otherUser;
        initInfo();
        init();
    }

    public void initInfo() {
        User user = otherUser;

        Comment comment = new Comment();
        comment.operate = ServerOperate.QUERY_ALL_COMMENT_BY_UID;
        comment.setUid(user.getUid());

        try {
            ClientUtil.sendInfo(comment,Comment.class);
            commentList = new ArrayList<>();
            commentList.addAll(ClientUtil.acceptList());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Store store = new Store();
        store.operate = ServerOperate.SELECT_STORE;
        store.setUid(user.getUid());
        try {
            ClientUtil.sendInfo(store,Store.class);
            storeList = new ArrayList<>();
            storeList.addAll(ClientUtil.acceptList());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Article article = new Article();
        article.operate = ServerOperate.GET_ARTICLE_BY_UID;
        article.setUid(user.getUid());

        try {
            ClientUtil.sendInfo(article,Article.class);
            articleList = new ArrayList<>();
            articleList.addAll(ClientUtil.acceptList());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
