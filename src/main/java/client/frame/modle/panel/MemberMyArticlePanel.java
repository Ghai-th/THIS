package client.frame.modle.panel;

import client.entity.User;

import javax.swing.*;

public class MemberMyArticlePanel extends JPanel {
    private JLabel title;
    private User myUser,otherUser;
    public MemberMyArticlePanel(User myUser){
        this.myUser = myUser;

    }
    public MemberMyArticlePanel(User myUser,User otherUser){
        this.myUser = myUser;
        this.otherUser = otherUser;
    }

}
