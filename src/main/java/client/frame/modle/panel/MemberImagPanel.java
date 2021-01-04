package client.frame.modle.panel;



import client.entity.User;

import javax.jws.soap.SOAPBinding;
import javax.swing.*;
import java.awt.*;

/**
 * 封装用户面板中的第一行用的JPanel
 */

public class MemberImagPanel extends TranslucenceJPanel {
    JLabel leftJLabel;
    JLabel rightJLabel;
    public User myUser,otherUser;
    String left;
    String right;
    public MemberImagPanel(){

    }
    public MemberImagPanel(User myUser){
        this.myUser = myUser;
        init();
    }
    public MemberImagPanel(User myUser,User otherUser){
        this.myUser = myUser;
        this.otherUser = otherUser;
        init();
    }
    public void init(){
        leftJLabel = new JLabel("头像");
        rightJLabel = new JLabel();
        leftJLabel.setFont(new Font("宋体",Font.PLAIN,20));
        rightJLabel.setFont(new Font("宋体",Font.PLAIN,20));
        rightJLabel.setForeground(Color.white);
        leftJLabel.setForeground(Color.white);
        setLayout(new GridLayout(1,2));
        add(leftJLabel);
        add(rightJLabel);
    }
}
