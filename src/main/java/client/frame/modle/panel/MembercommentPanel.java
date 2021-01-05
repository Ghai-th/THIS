package client.frame.modle.panel;

import client.entity.Comment;
import client.entity.User;

import javax.swing.*;
import java.awt.*;

public class MembercommentPanel extends JPanel {
    JLabel topicJLabel;
    JTextArea mainJTextArea;
    User myUser,otherUser;
    Comment comment;
    public MembercommentPanel(User myUser, Comment comment){
        this.comment = comment;
        this.myUser = myUser;
        init();
    }
    public MembercommentPanel(User myUser,User otherUser,Comment comment){
        this.comment = comment;
        this.myUser = myUser;
        this.otherUser = otherUser;
        init();
    }
    public void init(){
        topicJLabel = new JLabel("头像"+myUser.getName()+"----"+comment.getCreate()+"----"+comment.getAid());
        mainJTextArea = new JTextArea();
        mainJTextArea.setEditable(false);
        mainJTextArea.setPreferredSize(new Dimension(800,50));
        topicJLabel.setFont(new Font("宋体",Font.BOLD,25));
        topicJLabel.setForeground(Color.black);
        topicJLabel.setBackground(new Color(251,251,253));
        mainJTextArea.append(comment.getText());
        mainJTextArea.setFont(new Font("宋体",Font.PLAIN,20));
        //mainJTextArea.setForeground(Color.white);
        setLayout(new GridLayout(2,1));
        setPreferredSize(new Dimension(800,200));
        add(topicJLabel);
        add(mainJTextArea);
        //setBorder(BorderFactory.createLineBorder(Color.black));
        setBorder(BorderFactory.createMatteBorder(1,0,0,0,Color.black));
    }
}
