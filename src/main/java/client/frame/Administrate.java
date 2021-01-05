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
    public JLabel deleteUser;
    public JLabel welcomeLable;
    public JScrollPane mainPane;
    public JTabbedPane tabbedPane;
    public JTable table;

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
        mainPane =  new JScrollPane(
                table,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        mainPane.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.RED));

        JLabel userLabel = new JLabel();
        JLabel articleLabel = new JLabel();
        JLabel commentLabel = new JLabel();

        JPanel userJpanel = new JPanel();
        userJpanel.setLayout(new GridLayout(1,1));
        userJpanel.add(mainPane);


        JPanel articleJpanel = new JPanel();
        articleJpanel.setLayout(new GridLayout(1,1));
        articleJpanel.add(mainPane);

        JPanel commentJpanel = new JPanel();
        commentJpanel.setLayout(new GridLayout(1,1));
        commentJpanel.add(mainPane);

        userJpanel.add(userLabel);
        articleJpanel.add(articleLabel);
        commentJpanel.add(commentLabel);

        tabbedPane.addTab("用户管理", userJpanel);
        tabbedPane.addTab("文章管理", articleJpanel);
        tabbedPane.addTab("评论管理", commentJpanel);
        tabbedPane.setFont(new Font("宋体", Font.BOLD, 20));






        JPanel deleteJpanel = new JPanel(new FlowLayout(FlowLayout.LEFT,30,10));

        deleteUser = new JLabel("删除用户");
        deleteUser.setFont(new Font("宋体", Font.BOLD, 20));
        deleteUser.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.BLACK));
        deleteJpanel.add(deleteUser);
        deleteJpanel.setPreferredSize(new Dimension(WIDTH / 6, HIGH * 53 / 1050));

        deleteUser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                deleteUser.setForeground(Color.RED);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                deleteUser.setForeground(Color.BLACK);
            }
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("删除用户");
            }
        });

        centerPanel = new JPanel(new BorderLayout());



        centerPanel.add(tabbedPane, BorderLayout.CENTER);
        centerPanel.add(deleteJpanel, BorderLayout.SOUTH);

        this.add(centerPanel, BorderLayout.CENTER);
    }

}
