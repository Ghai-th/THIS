package client.frame;

import client.entity.User;

import javax.swing.*;
import java.awt.*;

public class Administrate extends JPanel {

    public User Administrator;
    public JPanel northPanel;

    public Administrate(User Administrator) {
        this.setLayout(new BorderLayout());
        this.Administrator = Administrator;
        initNorth();
        initCenter();
    }
    private void initNorth() {

        JLabel welcomeLable = new JLabel(Administrator.getName() + "你好");
        JLabel exitLable = new JLabel("退出");


        northPanel = new JPanel(new FlowLayout());
        northPanel.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK));

    }

    private void initCenter() {
    }



}
