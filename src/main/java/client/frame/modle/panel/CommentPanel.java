package client.frame.modle.panel;

import client.entity.Comment;
import client.entity.User;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class CommentPanel extends JPanel {
    List commentList;
    private User myUser,otherUser;
    public CommentPanel(User myUser, List commentList){
        this.commentList = commentList;
        this.myUser = myUser;
        init();
    }
    public CommentPanel(User myUser, User otherUser, List commentList){
        this.commentList = commentList;
        this.myUser = myUser;
        this.otherUser = otherUser;
        init();
    }
    public void init(){
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(800,800));
        Iterator iterator = commentList.iterator();
        while(iterator.hasNext()) {
            MembercommentPanel membercommentPanel = new MembercommentPanel(myUser, (Comment) iterator.next());
            add(membercommentPanel);
        }
    }
}
