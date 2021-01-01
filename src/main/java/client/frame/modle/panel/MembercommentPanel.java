package client.frame.modle.panel;

import javax.swing.*;
import java.awt.*;

public class MembercommentPanel extends JPanel {
    JLabel topicJLabel;
    JTextArea mainJTextArea;
    public MembercommentPanel(){
        topicJLabel = new JLabel("头像：名字---时间---主题帖名字");
        mainJTextArea = new JTextArea();
        mainJTextArea.setEditable(false);
        mainJTextArea.setPreferredSize(new Dimension(800,50));
        topicJLabel.setFont(new Font("宋体",Font.BOLD,25));
        topicJLabel.setForeground(Color.black);
        topicJLabel.setBackground(new Color(251,251,253));
        mainJTextArea.append("谢谢支持，互相学习");
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
