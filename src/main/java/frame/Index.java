package frame;

import conf.IndexConf;
import frame.modle.label.ClassLabel;
import frame.modle.label.RankLabel;
import frame.modle.panel.ClassPanel;
import frame.modle.panel.NavigationBarPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 论坛首页界面
 * 分类导航，用户排行榜，文章排行榜，分类概览
 */

public class Index extends JPanel implements IndexConf {

    public JPanel northPanel, centerPanel, westPanel; // 三个大边界板块
    public static final  String[] classification = new String[] //首页分类 整体从数据库获取
            {"C语言", "数据结构", "C++", "数据库", "Java", "Golang", "linux", "区块链", "人工智能", "软件安全"};
    public final  String[] personAction = new String[]{"收藏", "消息", "发表文章"};
    public JTextField searchTextField;
    public JLabel searchLabel;
    public JLabel headImage;
    public JPanel mainPanel;
    public JScrollPane scrollPane;
    public JPanel CCPanel;

    /**
     * 初始化界面
     */
    public Index() {
        this.setLayout(new BorderLayout());
        initNorth();
        initWest();
        initCenter();
    }

    /**
     * 初始化north Panel
     */
//    public void initNorth() {
//        northPanel = new JPanel();
//        northPanel.setPreferredSize(new Dimension(WIDE, HIGH * 53 / 1050));
//        northPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
//        northPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
//
//        ClassLabel iconClassLabel = new ClassLabel();
//        iconClassLabel.setText("图片THIS");
//        northPanel.add(iconClassLabel);
//
//        ClassLabel classLabel;
//        for (String string : classification) {
//            classLabel = new ClassLabel();
//            classLabel.setText(string);
//            northPanel.add(classLabel);
//        }
//
//        JPanel searchPanel;
//        searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
//        searchPanel.setPreferredSize(new Dimension(WIDE * 5 / 16, HIGH / 35));
//        searchTextField = new JTextField();
//        searchTextField.setPreferredSize(new Dimension(WIDE * 5 / 32, HIGH / 35));
//        searchPanel.add(searchTextField);
//        searchLabel = new JLabel("搜索");
//        searchLabel.setPreferredSize(new Dimension(WIDE * 5 / 192, HIGH * 29 / 1050));
//        searchLabel.setOpaque(true);
//        searchLabel.setBackground(new Color(188, 16, 3, 240));
//        searchLabel.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                searchLabel.setBackground(new Color(255, 142, 141));
//                super.mouseEntered(e);
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                searchLabel.setBackground(new Color(188, 16, 3, 240));
//                super.mouseExited(e);
//            }
//        });
//        searchPanel.add(searchLabel);
//        northPanel.add(searchPanel);
//
//        headImage = new JLabel("头像");
//        headImage.addMouseListener(new MouseAdapter() {
//            // 进入个人中心
//            @Override
//            public void mousePressed(MouseEvent e) {
//                super.mousePressed(e);
//                System.out.println("个人中心");
//            }
//
//            // 下面俩实现弹窗
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                super.mouseEntered(e);
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                super.mouseExited(e);
//            }
//        });
//        headImage.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 20));
//        northPanel.add(headImage);
//
//        for (String string : personAction) {
//            classLabel = new ClassLabel();
//            classLabel.setText(string);
//            northPanel.add(classLabel);
//        }
//
//        this.add(northPanel, BorderLayout.NORTH);
//    }

    public  void initNorth() {
        NavigationBarPanel navigationBarPanel = new NavigationBarPanel();
        this.add(navigationBarPanel,BorderLayout.NORTH);
    }

    /**
     * 初始化west Panel
     */
    public void initWest() {
        westPanel = new JPanel(new GridLayout(2, 1));
        westPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        JPanel rankingListPerson = new JPanel(new GridLayout(11, 1));
        rankingListPerson.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        RankLabel person;
        person = new RankLabel("用户活跃度排行", JLabel.CENTER);
        person.setFont(new Font("宋体", Font.BOLD, 20));
        rankingListPerson.add(person);
        for (int i = 1; i <= 10; i++) {
            person = new RankLabel(i + "  " + "这里写活跃排行需要从数据库选取", JLabel.CENTER);
            person.setOpaque(true);
            person.addMouseListener(person);
            person.setFont(new Font("宋体", Font.BOLD, 15));
            rankingListPerson.add(person);
        }

        JPanel rankingListArticle = new JPanel(new GridLayout(11, 1));
        rankingListArticle.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
        RankLabel article;
        article = new RankLabel("热门文章排行", JLabel.CENTER);
        article.setFont(new Font("宋体", Font.BOLD, 20));
        rankingListArticle.add(article);
        for (int i = 1; i <= 10; i++) {
            article = new RankLabel(i + "    " + "这里写文章需要从数据库选取", JLabel.CENTER);
            article.setOpaque(true);
            article.addMouseListener(article);
            article.setFont(new Font("宋体", Font.BOLD, 15));
            rankingListArticle.add(article);
        }

        westPanel.add(rankingListPerson);
        westPanel.add(rankingListArticle);
        westPanel.setPreferredSize(new Dimension(384, 1050));
        this.add(westPanel, BorderLayout.WEST);
    }

    /**
     * 初始化center Panel
     * center 本身也是一个边界布局
     * 设置滚动面板
     */
    public void initCenter() {
        centerPanel = new JPanel(new GridLayout(1, 1));
        mainPanel = new JPanel(); // 放置 大组件最后通过这个面板放如滚动面板中
        centerPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        CCPanel = new JPanel(new BorderLayout());

        JPanel center, west, east, north, south;
        east = new JPanel();
        east.setPreferredSize(new Dimension(WIDE * 5 / 64, (classification.length + 1) * RANK_HIGH));
        CCPanel.add(east, BorderLayout.EAST);

        south = new JPanel();
        south.setPreferredSize(new Dimension(WIDE * 4 / 5, HIGH / 21));
        CCPanel.add(south, BorderLayout.SOUTH);

        north = new JPanel();
        north.setPreferredSize(new Dimension(WIDE * 4 / 5, HIGH / 21));
        CCPanel.add(north, BorderLayout.NORTH);

        west = new JPanel();
        west.setPreferredSize(new Dimension(WIDE * 5 / 64, classification.length * RANK_HIGH));
        CCPanel.add(west, BorderLayout.WEST);

        center = new JPanel(new GridLayout(classification.length, 1));
        center.setPreferredSize(new Dimension(WIDE * 5 / 8, classification.length * RANK_HIGH));

        //// 后面从数据库拉取 使用二参构造函数 传入对应的文章 list 和 分类对象
        for (int i = 0; i < 10; i++) {
            ClassPanel classPanel = new ClassPanel(this);
            classPanel.addMouseListener(classPanel);
            center.add(classPanel);
        }
        ////

        CCPanel.add(center, BorderLayout.CENTER);
        mainPanel.add(CCPanel, BorderLayout.CENTER);
        scrollPane = new JScrollPane(
                mainPanel,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        centerPanel.add(scrollPane);

        this.add(centerPanel, BorderLayout.CENTER);
    }
}
