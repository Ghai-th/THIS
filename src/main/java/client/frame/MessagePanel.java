package client.frame;

import client.entity.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MessagePanel extends JPanel {

    public static User meUser;
    public ArrayList userList;
    private JPanel northPanel,centerPanel,southPanel;

    public MessagePanel(ArrayList list) throws HeadlessException {
        this.userList = list;
        init();
        setBackground(new Color(61,61,61));
    }

    public void init() {
        this.setLayout(new BorderLayout());
        this.setBounds(0,0,1920/6,864);
        initNorth();
        initCenter();
        this.setVisible(true);
    }

    public void initNorth() {
        northPanel = new JPanel(null);
        northPanel.setPreferredSize(new Dimension(300,120));

        JLabel imageLabel,nameLabel,synopsisLabel,levelLabel;

        imageLabel = new JLabel("头像");
        nameLabel = new JLabel(meUser.getName());
        synopsisLabel = new JLabel(meUser.getSynopsis());
        levelLabel = new JLabel(String.valueOf(meUser.getLevel()));
        imageLabel.setForeground(Color.white);

        nameLabel.setFont(new Font("黑体",Font.BOLD,19));
        synopsisLabel.setFont(new Font("宋体",Font.PLAIN,14));
        synopsisLabel.setForeground(Color.gray);
        levelLabel.setFont(new Font("宋体",Font.BOLD,9));
        nameLabel.setForeground(Color.white);

        imageLabel.setBounds(30,20,50,50);
        synopsisLabel.setBounds(100,60,180,20);
        levelLabel.setBounds(175,35,20,12);
        nameLabel.setBounds(100,30,80,25);

        northPanel.add(imageLabel);
        northPanel.add(nameLabel);
        northPanel.add(synopsisLabel);
        northPanel.add(levelLabel);

        northPanel.updateUI();
        northPanel.setVisible(true);
        northPanel.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        this.add(northPanel,BorderLayout.NORTH);

    }

    public void initCenter() {


        centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(300,userList.size() * 70));



        //// 随运行定义长度， 放入滚动面板




        this.add(centerPanel,BorderLayout.CENTER);
    }

}


