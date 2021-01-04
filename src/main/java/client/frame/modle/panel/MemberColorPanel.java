package client.frame.modle.panel;

import client.entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 封装用户面板中的第二行用的JPanel
 */

public class MemberColorPanel extends TranslucenceJPanel {
    JLabel upJLabel;//上部label
    JLabel downJLabel;//下部label
    String up;
    String down;
    public User myUser,otherUser;
    public MemberColorPanel(User myUser){
        this.myUser = myUser;
        init();
    }
    public MemberColorPanel(User myUser,User otherUser){
        this.myUser = myUser;
        this.otherUser = otherUser;
    }
    public void init(){
        upJLabel = new JLabel(up,JLabel.CENTER);
        downJLabel = new JLabel(down,JLabel.CENTER);
        downJLabel.setFont(new Font("宋体",Font.PLAIN,20));
        downJLabel.setForeground(Color.white);
        upJLabel.setFont(new Font("宋体",Font.PLAIN,20));
        upJLabel.setForeground(Color.white);
        //为下部label设置鼠标监听器，当鼠标移入是变成手
        downJLabel.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {

            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {
                downJLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//设置鼠标移入是光标变成手指
                downJLabel.setForeground(new Color(255,29,0));//设置鼠标移入后字体颜色
            }

            public void mouseExited(MouseEvent e) {
                downJLabel.setForeground(Color.white);
            }
        });
        setLayout(new GridLayout(2,1));
        add(upJLabel);
        add(downJLabel);
    }

}
