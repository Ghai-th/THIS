package client.frame;

import client.entity.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Message extends JFrame {

    public static User meUser;
    public ArrayList userList;
    private JPanel northPanel,centerPanel,southPanel;

    public Message(ArrayList list) throws HeadlessException {
        this.userList = list;
        init();
    }

    public void init() {
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setLocation(1500,200);
        this.setSize(new Dimension(314,707));
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

        nameLabel.setFont(new Font("黑体",Font.BOLD,19));
        synopsisLabel.setFont(new Font("宋体",Font.PLAIN,14));
        synopsisLabel.setForeground(Color.gray);
        levelLabel.setFont(new Font("宋体",Font.BOLD,9));

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

    public static void main(String[] args) {
        meUser = User.initUser();
        //// 直接从数据库拉
        ArrayList userList = new ArrayList<User>();
        for (int i = 0 ;i < 12; i++) {
            userList.add(User.initUser());
        }
        new Message(userList);
    }

}
