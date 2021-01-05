package client.frame.modle.panel;

import client.entity.Article;
import client.entity.Comment;
import client.entity.Store;
import client.entity.User;
import client.frame.Index;

import javax.swing.*;
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
        this.myUser = User.copyUser(myUser);
        this.otherUser = otherUser;
        this.index = index;
        init();
    }
    public void init(){
        setLayout(null);
        UserPanel userPanel = new UserPanel(myUser,otherUser,index,this,commentList,storeList,articleList);
        ImageIcon Image=new ImageIcon("src/main/resources/屏幕截图 2020-12-30 223025.png");
        j = new JLabel(Image);
        j.setBounds(0,0,1920,1080);
        setBounds(0,0,1920,1080);
        add(userPanel);
        add(j);
    }

}
