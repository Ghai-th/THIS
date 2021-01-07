package client.frame.modle.panel;

import client.conf.IndexConf;
import client.entity.*;
import client.frame.Index;
import client.util.ClientUtil;
import data.Operate;
import server.controller.ServerOperate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleDetailsPanel extends JPanel implements IndexConf {

    public Article article;
    public User author; // 作者信息
    public JPanel articleDetailNorthPanel, articleDetailCenterPanel, articleDetailSouthPanel;
    public JTextPane writeCommentPane;
    public JLabel publishLabel;
    public Index index;
    public Date date;
    public ArrayList<Comment> commentArrayList;
    private List commentList;
    private List storeList;
    public JPanel commentListPanel;
    public JPanel borderLimit;
    public Comment comment;
    private JLabel reportLabel;
    private List articleList;

    public void init() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(1200, 2600));
        this.articleList = new ArrayList<User>();
        initInfo();
        initCenter();
        initSouth();
        initNorth();
    }


    public void initNorth() {

        final JLabel authorNameLabel, writeTimeLabel, viewNumLabel, collectionLabel, classLabel;

        articleDetailNorthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        articleDetailNorthPanel.setPreferredSize(new Dimension(1200, 160));
        articleDetailNorthPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK));
        JLabel articleTittle = new JLabel(article.getTitle(), JLabel.CENTER);
        articleTittle.setFont(new Font("宋体", Font.BOLD, 30));
        articleTittle.setPreferredSize(new Dimension(1200, 100));
        articleDetailNorthPanel.add(articleTittle);

        reportLabel = new JLabel("举报");
        authorNameLabel = new JLabel(author.getName());
        writeTimeLabel = new JLabel(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(article.getCreate()));
        viewNumLabel = new JLabel(String.valueOf(article.getVisitorNum()));
        collectionLabel = new JLabel(String.valueOf(article.getCollectNum()));
        classLabel = new JLabel(article.getCid()); // 数据库查询
        JLabel viewEyeLabel = new JLabel(new ImageIcon("src/main/resources/articleReadEyes.png"));
        JLabel collectionIconLabel = new JLabel(new ImageIcon("src/main/resources/tobarCollectionActive.png"));
        JLabel articleClassLabel = new JLabel(Index.classification[Integer.parseInt(article.getCid()) - 1000]);

        initLabel(authorNameLabel);
        initLabel(writeTimeLabel);
        initLabel(viewNumLabel);
        initLabel(collectionLabel);
        initLabel(classLabel);
        initLabel(reportLabel);
        initLabel(articleClassLabel);

        writeTimeLabel.setPreferredSize(new Dimension(240, 50));
        authorNameLabel.setFont(new Font("黑体", Font.BOLD, 22));
        authorNameLabel.setForeground(new Color(121, 86, 102));

        reportLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ///////  举报文章对应的事件
                Report report = new Report();
                report.operate = ServerOperate.ADD_REPORT_ARTICLE;
                report.setAid(article.getAid());
                report.setReportNum(0);
                try {
                    ClientUtil.sendInfo(report,Report.class);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(null,"举报成功");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                reportLabel.setForeground(new Color(255, 77, 77));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                reportLabel.setForeground(new Color(252, 25, 68));
                super.mouseExited(e);
            }
        });

        authorNameLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                index.removeAll();
                index.add(new AllPanel(author,User.copyUser(Index.MeUser),index,commentList,storeList,articleList));
                index.repaint();
                index.updateUI();
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

        articleDetailNorthPanel.add(authorNameLabel);
        articleDetailNorthPanel.add(writeTimeLabel);
        articleDetailNorthPanel.add(viewEyeLabel);
        articleDetailNorthPanel.add(viewNumLabel);
        articleDetailNorthPanel.add(collectionIconLabel);
        articleDetailNorthPanel.add(collectionLabel);
        articleDetailNorthPanel.add(articleClassLabel);
//        articleDetailNorthPanel.add(classLabel);
        articleDetailNorthPanel.add(reportLabel);

        this.add(articleDetailNorthPanel, BorderLayout.NORTH);
    }

    public void initCenter() {
        JPanel textSynopsisPanel, textPortPanel;
        JLabel  textSynopsisLabel;
        JTextPane textPortPane;

        articleDetailCenterPanel = new JPanel(new BorderLayout());

        textSynopsisPanel = new JPanel(new BorderLayout());
        textSynopsisPanel.setPreferredSize(new Dimension(1200, 225));
        textSynopsisPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        textSynopsisLabel = new JLabel("简介");
        textSynopsisLabel.setText(article.getSynopsis());
        textSynopsisLabel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
        textSynopsisLabel.setFont(new Font("宋体",Font.PLAIN,17));
        textSynopsisLabel.setForeground(Color.gray);
        textSynopsisLabel.setPreferredSize(new Dimension(1200, 225));
        textSynopsisLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
        textSynopsisPanel.add(textSynopsisLabel, BorderLayout.WEST);

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
        //评论列表
        commentArrayList = new ArrayList<>();
        comment = new Comment();
        comment.setAid(article.getAid());
        comment.operate = ServerOperate.QUERY_ALL_COMMENT_BY_AID;
        try {
            ClientUtil.sendInfo(comment, Comment.class);
            commentList = ClientUtil.acceptList();
            commentArrayList.addAll(commentList);
        } catch (Exception e) {
            e.printStackTrace();
        }

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
                //鼠标点击后发表 并刷新评论列表
                Comment com = new Comment();
                com.setCreate(new Date());
                System.out.println(com);
                Comment comm = new Comment();
                ArrayList<Comment> commentArray = new ArrayList<>();
                com.setAid(article.getAid());
                /////////////////////////////////////////////////////////////////
                com.setUid(article.getUid()); // 获得User的id
                /////////////////////////////////////////////////////////////////
                com.setText(writeCommentPane.getText());
                com.operate = ServerOperate.SELECT_ALL_COMMENT_NUM;
                comm.setAid(article.getAid());
                comm.operate = ServerOperate.QUERY_ALL_COMMENT_BY_AID;
                try {
                    ClientUtil.sendInfo(com, Comment.class);
                    ClientUtil.sendInfo(comm, Comment.class);
                    commentArray.addAll(ClientUtil.acceptList());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                writeCommentPane.setText("");

                commentListPanel.removeAll();
                commentListPanel.setVisible(false);
                commentListPanel = new JPanel(new GridLayout(commentArray.size(),1));
                commentListPanel.setPreferredSize(new Dimension(1200,commentArray.size() * 105));
                for (Comment comments : commentArray) {
                    ArticleDetailsCommentPanel articleDetailsCommentPanel = new ArticleDetailsCommentPanel(comments);
                    commentListPanel.add(articleDetailsCommentPanel);
                }
                commentListPanel.setVisible(true);
                commentListPanel.repaint();
                updateUI();
                articleDetailSouthPanel.add(commentListPanel,BorderLayout.CENTER);
                borderLimit.add(articleDetailSouthPanel, BorderLayout.SOUTH);

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

        commentListPanel = new JPanel(new GridLayout(commentArrayList.size(),1));int x;
        commentListPanel.setPreferredSize(new Dimension(1200,commentArrayList.size() * 105));
        for (Comment comments : commentArrayList) {
            System.out.println(comments);
            ArticleDetailsCommentPanel articleDetailsCommentPanel = new ArticleDetailsCommentPanel(comments);
            commentListPanel.add(articleDetailsCommentPanel);
        }
        articleDetailSouthPanel.add(commentListPanel,BorderLayout.CENTER);
        this.add(articleDetailSouthPanel, BorderLayout.SOUTH);
}

    public void initInfo() {
        // 从根据作者的id从数据库拉去作者信息
        author = new User();
        author.setUid(article.getUid());
        author.operate = ServerOperate.SELECT_USER;
        try {
            ClientUtil.sendInfo(author,User.class);
            author = ClientUtil.acceptInfo(User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Article article = new Article();
        article.setUid(this.article.getUid());
        article.operate = ServerOperate.GET_ARTICLE_BY_UID;
        try {
            ClientUtil.sendInfo(article,Article.class);
            articleList = ClientUtil.acceptList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Store store = new Store();
        store.operate = ServerOperate.SELECT_STORE;
        store.setUid(article.getUid());
        try {
            ClientUtil.sendInfo(store,Store.class);
            storeList = ClientUtil.acceptList();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void initLabel(JLabel label) {
        label.setFont(new Font("宋体", Font.BOLD, 20));
        label.setForeground(Color.gray);
        label.setPreferredSize(new Dimension(100, 50));
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label.setOpaque(true);
    }

    public ArticleDetailsPanel(Article article, Index index, JPanel borderLimit) {
        this.borderLimit = borderLimit;
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
