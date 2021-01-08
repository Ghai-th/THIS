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
    JTextArea jTextArea;
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
        jTextArea = new JTextArea();
        jTextArea.setPreferredSize(new Dimension(800,5));
        jTextArea.append("666");
        jTextArea.setBackground(new Color(242,242,242));
        jTextArea.setForeground(new Color(242,242,242));
        jTextArea.setEditable(false);
        add(jTextArea);

        System.out.println(commentList.size());
        setPreferredSize(new Dimension(800,250*commentList.size()));
        System.out.println("高为"+250*commentList.size());
        Iterator iterator = commentList.iterator();
        int i = 1;
        while(iterator.hasNext()) {
            MembercommentPanel membercommentPanel = new MembercommentPanel(myUser, (Comment) iterator.next());
            /*if(i==1){
                jTextArea = membercommentPanel.mainJTextArea;
            }*/
            add(membercommentPanel);
            i++;
        }
        jTextArea.setCaretPosition(0);
    }
}
