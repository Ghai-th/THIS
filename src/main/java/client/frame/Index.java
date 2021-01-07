package client.frame;

import client.conf.IndexConf;
import client.entity.Article;
import client.entity.Class;
import client.entity.User;
import client.frame.modle.label.RankLabel;
import client.frame.modle.panel.ClassPanel;
import client.frame.modle.panel.NavigationBarPanel;
import client.frame.modle.panel.TranslucenceJPanel;
import client.util.ClientUtil;
import server.controller.ServerOperate;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * 论坛首页界面
 * 分类导航，用户排行榜，文章排行榜，分类概览
 */

public class Index extends JPanel implements IndexConf {

    public static User MeUser;
    public JPanel centerPanel, westPanel; // 三个大边界板块
    public static final String[] classification = new String[]
            {"C语言", "数据结构", "C++", "数据库", "Java", "Golang", "linux", "区块链", "人工智能", "软件安全"};
    public JPanel mainPanel;
    public JScrollPane scrollPane;
    public JPanel CCPanel;
    public User user;

    /**
     * 初始化界面
     */
    public Index(User user) {
        super(new GridLayout(2, 1));
        this.user = user;
        this.setLayout(new BorderLayout());
        initNorth();
        initWest();
        initCenter();
    }

    public Index(int x) {
        super(new GridLayout(2, 1));
        User user = new User();
        user.setUid("0000");
        this.user = user;
        this.setLayout(new BorderLayout());
        initNorth();
    }

    public Index() {
        super(new GridLayout(2, 1));
        User user = new User();
        user.setUid("0000");
        this.user = user;
        this.setLayout(new BorderLayout());
        initNorth();
        initWest();
        initCenter();
    }

    public void initNorth() {
        NavigationBarPanel navigationBarPanel = new NavigationBarPanel(this);
        this.add(navigationBarPanel, BorderLayout.NORTH);
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
        person = new RankLabel("用户活跃度排行", JLabel.CENTER, this);
        person.setFont(new Font("宋体", Font.BOLD, 20));
        rankingListPerson.add(person);

        //等级前十的用户
        ArrayList<User> userTopTenArrayList = new ArrayList<>();
        User userTopTen = new User();int x;
        userTopTen.operate = ServerOperate.SELECT_LIMIT_USERS;
        try {
            ClientUtil.sendInfo(userTopTen, User.class);x = 1;
            userTopTenArrayList.addAll(ClientUtil.acceptList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int i = 1;
        for (User userTop : userTopTenArrayList) {
            person = new RankLabel(this, userTop, i + "    " + userTop.getName());
            person.setOpaque(true);
            person.addMouseListener(person);
            person.setFont(new Font("宋体", Font.BOLD, 15));
            rankingListPerson.add(person);
            i++;
        }

        JPanel rankingListArticle = new JPanel(new GridLayout(11, 1));
        rankingListArticle.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
        RankLabel article;
        article = new RankLabel("热门文章排行", JLabel.CENTER, this);
        article.setFont(new Font("宋体", Font.BOLD, 20));
        rankingListArticle.add(article);

        //热度前十的文章
        ArrayList<Article> articleTopTenArrayList = new ArrayList<>();
        Article articleTopTen = new Article();
        articleTopTen.operate = ServerOperate.GET_ARTICLE_TOP_TEN;
        try {
            ClientUtil.sendInfo(articleTopTen, Article.class);
            articleTopTenArrayList.addAll(ClientUtil.acceptList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int j = 1;
        for (Article articleTop : articleTopTenArrayList) {
            article = new RankLabel(this, articleTop, j + "    " + articleTop.getTitle());
            article.setOpaque(true);
            article.addMouseListener(article);
            article.setFont(new Font("宋体", Font.BOLD, 15));
            rankingListArticle.add(article);
            j++;
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

        ArrayList<Class> classArrayList = new ArrayList<>();

        // 分类 lis
        Class clazz = new Class();
        clazz.operate = ServerOperate.SELECT_ALL_CLASS;
        try {
            ClientUtil.sendInfo(clazz, Class.class);
            classArrayList.addAll(ClientUtil.acceptList());
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Class aClass : classArrayList) {
            Article article = new Article();
            ArrayList<Article> articles = new ArrayList<>();
            article.setCid(aClass.getCid());
            article.operate = ServerOperate.GET_CLASS_HOT_ARTICLE_TOP_EIGHT;
            try {
                ClientUtil.sendInfo(article, Article.class);
                articles.addAll(ClientUtil.acceptList());
            } catch (Exception e) {
                e.printStackTrace();
            }
            ClassPanel classPanel = new ClassPanel(articles, aClass, this);
            classPanel.addMouseListener(classPanel);
            center.add(classPanel);
        }


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
