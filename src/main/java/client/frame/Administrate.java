package client.frame;

import client.conf.IndexConf;
import client.entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Administrate extends JPanel implements IndexConf {

    public User Administrator;
    public JPanel northPanel;
    public JPanel centerPanel;
    public JLabel exitLable;
    public JLabel welcomeLable;
    public JScrollPane mainPane;
    JTabbedPane tabbedPane;

    public Administrate(User Administrator) {
        this.setLayout(new BorderLayout());
        this.Administrator = Administrator;
        initNorth();
        initCenter();
    }
    public void initNorth() {

        welcomeLable = new JLabel(Administrator.getName() + "你好");
        exitLable = new JLabel("退出");

        welcomeLable.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.BLACK));
        exitLable.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.BLACK));

        welcomeLable.setFont(new Font("宋体", Font.BOLD, 20));
        exitLable.setFont(new Font("宋体", Font.BOLD, 20));

        exitLable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitLable.setForeground(Color.RED);
                super.mouseEntered(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                exitLable.setForeground(Color.BLACK);
                super.mouseExited(e);
            }
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("退出");
            }
        });

        northPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,70,10));
        northPanel.setPreferredSize(new Dimension(WIDTH, HIGH * 53 / 1050));
        northPanel.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK));

        northPanel.add(welcomeLable);
        northPanel.add(exitLable);

        this.add(northPanel, BorderLayout.NORTH);
    }

    public void initCenter() {
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        mainPane = new JScrollPane(
                tabbedPane,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(mainPane, BorderLayout.CENTER);
        this.add(centerPanel, BorderLayout.CENTER);
    }

}
