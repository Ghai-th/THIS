package client.frame.modle.panel;

import javax.swing.*;
import java.awt.*;

/**
 * 封装用户面板中的第三行用的JPanel
 */
public class MemberNoColorPanel extends TranslucenceJPanel {
    JLabel upJLabel;//上部label
    JLabel downJLabel;//下部label
    public MemberNoColorPanel(String up, String down){
        upJLabel = new JLabel(up,JLabel.CENTER);
        downJLabel = new JLabel(down,JLabel.CENTER);
        downJLabel.setFont(new Font("宋体",Font.PLAIN,20));
        upJLabel.setFont(new Font("宋体",Font.PLAIN,20));
        downJLabel.setForeground(Color.lightGray);
        upJLabel.setForeground(Color.white);
        setLayout(new GridLayout(2,1));
        add(upJLabel);
        add(downJLabel);
    }
}
