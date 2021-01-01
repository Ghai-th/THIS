package frame;

import conf.IndexConf;
import frame.modle.label.RankLabel;
import frame.modle.panel.ClassPanel;
import frame.modle.panel.NavigationBarPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 论坛首页界面
 * 分类导航，用户排行榜，文章排行榜，分类概览
 */

public class Index extends JPanel implements IndexConf {

    public JPanel  centerPanel, westPanel; // 三个大边界板块
    public static final  String[] classification = new String[] //首页分类 整体从数据库获取
            {"C语言", "数据结构", "C++", "数据库", "Java", "Golang", "linux", "区块链", "人工智能", "软件安全"};
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

    public  void initNorth() {
        NavigationBarPanel navigationBarPanel = new NavigationBarPanel(this);
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
