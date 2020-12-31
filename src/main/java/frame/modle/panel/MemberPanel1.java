package test;

import exjpanel.TranslucenceJPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 封装用户面板中的第一行用的JPanel
 */

public class MemberPanel1 extends TranslucenceJPanel {
    JLabel leftJLabel;
    JLabel rightJLabel;
    public MemberPanel1(String imag,String sign){
        leftJLabel = new JLabel(imag);
        rightJLabel = new JLabel(sign);
        leftJLabel.setFont(new Font("宋体",Font.PLAIN,20));
        rightJLabel.setFont(new Font("宋体",Font.PLAIN,20));
        rightJLabel.setForeground(Color.white);
        leftJLabel.setForeground(Color.white);
        setLayout(new GridLayout(1,2));
        add(leftJLabel);
        add(rightJLabel);
    }
}
