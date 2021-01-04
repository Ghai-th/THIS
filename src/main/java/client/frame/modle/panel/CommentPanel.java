package client.frame.modle.panel;

import client.entity.User;

import javax.swing.*;
import java.awt.*;

public class CommentPanel extends JPanel {
    private User myUser,otherUser;
    public CommentPanel(User myUser){
        this.myUser = myUser;
        init();
    }
    public CommentPanel(User myUser,User otherUser){
        this.myUser = myUser;
        this.otherUser = otherUser;
        init();
    }
    public void init(){
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(800,800));
        MembercommentPanel membercommentPanelone = new MembercommentPanel(myUser,otherUser);
        MembercommentPanel membercommentPanelotwo = new MembercommentPanel(myUser,otherUser);
        MembercommentPanel membercommentPanelthree = new MembercommentPanel(myUser,otherUser);
        add(membercommentPanelone);
        add(membercommentPanelotwo);
        add(membercommentPanelthree);
    }
}
