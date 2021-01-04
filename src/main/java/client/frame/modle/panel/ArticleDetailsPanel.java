package client.frame.modle.panel;

import client.conf.IndexConf;
import client.entity.Article;
import client.entity.Comment;
import client.entity.User;
import client.frame.Index;
import client.util.ClientUtil;
import server.controller.ServerOperate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ArticleDetailsPanel extends JPanel implements IndexConf {

    public Article article;
    public User author; // 作者信息
    public JPanel articleDetailNorthPanel, articleDetailCenterPanel, articleDetailSouthPanel;
    public JTextPane writeCommentPane;
    public JLabel publishLabel;
    public Index index;


    public void init() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(1200, 2600));
        initAuthor();
        initNorth();
        initCenter();
        initSouth();
    }


    public void initNorth() {

        final JLabel authorNameLabel, writeTimeLabel, viewNumLabel, collectionLabel, classLabel;

        articleDetailNorthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        articleDetailNorthPanel.setPreferredSize(new Dimension(1200, 150));
        articleDetailNorthPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        JLabel articleTittle = new JLabel(article.getTitle(), JLabel.CENTER);
        articleTittle.setFont(new Font("宋体", Font.BOLD, 30));
        articleTittle.setPreferredSize(new Dimension(1200, 100));
        articleTittle.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        articleDetailNorthPanel.add(articleTittle);

        authorNameLabel = new JLabel(author.getName());
        writeTimeLabel = new JLabel(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(article.getCreate()));
        viewNumLabel = new JLabel(String.valueOf(article.getVisitorNum()));
        collectionLabel = new JLabel(String.valueOf(article.getCollectNum()));
        classLabel = new JLabel(article.getCid()); // 数据库查询

        initLabel(authorNameLabel);
        initLabel(writeTimeLabel);
        initLabel(viewNumLabel);
        initLabel(collectionLabel);
        initLabel(classLabel);

        writeTimeLabel.setPreferredSize(new Dimension(240, 50));
        authorNameLabel.setFont(new Font("宋体", Font.BOLD, 22));
        authorNameLabel.setForeground(new Color(121, 86, 102));
        authorNameLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("文章详情进入作者首页");
                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                authorNameLabel.setForeground(Color.red);
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                authorNameLabel.setForeground(new Color(121, 86, 102));
                super.mouseExited(e);
            }
        });


        JLabel viewEyeLabel = new JLabel(new ImageIcon("src/main/resources/articleReadEyes.png"));
        JLabel collectionIconLabel = new JLabel(new ImageIcon("src/main/resources/tobarCollectionActive.png"));
        JLabel articleClassLabel = new JLabel("文章分类");
        initLabel(articleClassLabel);

        articleDetailNorthPanel.add(authorNameLabel);
        articleDetailNorthPanel.add(writeTimeLabel);
        articleDetailNorthPanel.add(viewEyeLabel);
        articleDetailNorthPanel.add(viewNumLabel);
        articleDetailNorthPanel.add(collectionIconLabel);
        articleDetailNorthPanel.add(collectionLabel);
        articleDetailNorthPanel.add(articleClassLabel);
        articleDetailNorthPanel.add(classLabel);

        this.add(articleDetailNorthPanel, BorderLayout.NORTH);
    }

    public void initCenter() {
        JPanel textSynopsisPanel, textPortPanel;
        JLabel textSynopsisImageLabel, textSynopsisLabel;
        JTextPane textPortPane;

        articleDetailCenterPanel = new JPanel(new BorderLayout());

        textSynopsisPanel = new JPanel(new BorderLayout());
        textSynopsisPanel.setPreferredSize(new Dimension(1200, 225));
        textSynopsisPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        textSynopsisImageLabel = new JLabel("图片");
        textSynopsisLabel = new JLabel("简介");
        textSynopsisImageLabel.setPreferredSize(new Dimension(400, 225));
        textSynopsisLabel.setPreferredSize(new Dimension(800, 225));
        textSynopsisLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
        textSynopsisPanel.add(textSynopsisLabel, BorderLayout.WEST);
        textSynopsisPanel.add(textSynopsisImageLabel, BorderLayout.EAST);

        textPortPanel = new JPanel();
        textPortPanel.setPreferredSize(new Dimension(1200, 500));
        textPortPane = new JTextPane();
        textPortPane.setText(article.getText());
        textPortPane.setPreferredSize(new Dimension(1200, 500));
        textPortPane.setEditable(false);
        textPortPane.setBackground(new Color(238, 238, 238));
        textPortPane.setFont(new Font("宋体", Font.BOLD, 22));

        textPortPane.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.BLACK));
        textPortPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        textPortPanel.add(textPortPane, BorderLayout.CENTER);

        articleDetailCenterPanel.add(textSynopsisPanel, BorderLayout.NORTH);
        articleDetailCenterPanel.add(textPortPanel, BorderLayout.CENTER);
        this.add(articleDetailCenterPanel, BorderLayout.CENTER);
    }

    public void initSouth() {
        /**
         * 数据库拉取 评论区列表
         */
        ////////////////////////////////
        ArrayList<Comment> commentArrayList = new ArrayList<>();
        Comment comment1 = new Comment();
        comment1.setAid(article.getAid());
        comment1.operate = ServerOperate.QUERY_ALL_COMMENT_BY_AID;
        try {
            ClientUtil.sendInfo(comment1, Comment.class);
            commentArrayList.addAll(ClientUtil.acceptList());
        } catch (Exception e) {
            e.printStackTrace();
        }

        ////////////////////////////////

        articleDetailSouthPanel = new JPanel(new BorderLayout());

        writeCommentPane = new JTextPane();
        writeCommentPane.setFont(new Font("宋体", Font.BOLD, 22));

        publishLabel = new JLabel("发表");
        publishLabel.setOpaque(true);
        publishLabel.setFont(new Font("宋体", Font.BOLD, 22));
        publishLabel.setBackground(new Color(255, 77, 77));
        publishLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("BB赖赖");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                publishLabel.setBackground(new Color(252, 19, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                publishLabel.setBackground(new Color(255, 77, 77));
            }
        });

        writeCommentPane.setPreferredSize(new Dimension(800, 120));
        publishLabel.setPreferredSize(new Dimension(100, 150));

        JPanel writePanel = new JPanel(new BorderLayout());


        writePanel.add(writeCommentPane, BorderLayout.CENTER);
        writePanel.add(publishLabel, BorderLayout.EAST);
        articleDetailSouthPanel.add(writePanel,BorderLayout.NORTH);

        JPanel commentListPanel = new JPanel(new GridLayout(10,1));
        commentListPanel.setPreferredSize(new Dimension(1200,commentArrayList.size() * 145));

        for (Comment comment : commentArrayList) {
            ArticleDetailsCommentPanel articleDetailsCommentPanel = new ArticleDetailsCommentPanel(comment);
            commentListPanel.add(articleDetailsCommentPanel);
        }

        updateUI();

        articleDetailSouthPanel.add(commentListPanel,BorderLayout.CENTER);
        this.add(articleDetailSouthPanel, BorderLayout.SOUTH);

    }

    public void initAuthor() {
        // 从根据作者的id从数据库拉去作者信息
        this.author = new User();
        User.initUser(this.author);
    }

    public void initLabel(JLabel label) {
        label.setFont(new Font("宋体", Font.BOLD, 20));
        label.setForeground(Color.gray);
        label.setPreferredSize(new Dimension(100, 50));
    }

    public ArticleDetailsPanel(Article article, Index index) {
        this.index = index;
        this.article = article;
        init();
    }

    public ArticleDetailsPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
        init();

    }

    public ArticleDetailsPanel(LayoutManager layout) {
        super(layout);
        init();
    }

    public ArticleDetailsPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
        init();
    }


}
