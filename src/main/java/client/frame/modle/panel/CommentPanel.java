package client.frame.modle.panel;

import client.entity.User;

import javax.swing.*;
import java.awt.*;

public class CommentPanel extends JPanel {
    public CommentPanel(User myUser){
        init();
    }
    public CommentPanel(User myUser,User otherUser){
        init();
    }
    public void init(){
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(800,800));
        MembercommentPanel membercommentPanelone = new MembercommentPanel();
        MembercommentPanel membercommentPanelotwo = new MembercommentPanel();
        MembercommentPanel membercommentPanelthree = new MembercommentPanel();
        add(membercommentPanelone);
        add(membercommentPanelotwo);
        add(membercommentPanelthree);
    }
}
