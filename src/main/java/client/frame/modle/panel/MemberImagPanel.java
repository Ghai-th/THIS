package client.frame.modle.panel;



import client.entity.User;

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

        super(new GridLayout(2, 1));
    }
    public MemberImagPanel(String left,String right){
        super(new GridLayout(2, 1));
        this.left = left;
       this.right = right;
        init();
    }
    public void init(){
        leftJLabel = new JLabel(left);
        rightJLabel = new JLabel(right);
        leftJLabel.setFont(new Font("宋体",Font.PLAIN,20));
        rightJLabel.setFont(new Font("宋体",Font.PLAIN,20));
        rightJLabel.setForeground(Color.white);
        leftJLabel.setForeground(Color.white);
        setLayout(new GridLayout(1,2));
        add(leftJLabel);
        add(rightJLabel);
    }
}
