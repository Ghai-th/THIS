package client.frame.modle.panel;

import client.entity.Article;
import client.entity.User;
import client.frame.Index;
import client.frame.modle.label.ArticleTittleLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ArticleSynopsisPanel extends JPanel implements MouseListener {

    public JPanel upPanel, downPanel;
    public Article article;
    public User user;
    public ArticleTittleLabel tittleLabel;
    public Index index;

    public ArticleSynopsisPanel(Article article, Index index) {
        super();
        this.article = article;
        this.index = index;
        /////添加数据库连接时 注释以下
//        this.article = Article.initArticle();
        init();
    }

    public void init() {
        this.setLayout(new BorderLayout());

        upPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        tittleLabel = new ArticleTittleLabel(article,index);
        tittleLabel.setFont(new Font("宋体", Font.BOLD, 25));
        upPanel.add(tittleLabel);

        downPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        initInfo();
        JLabel imageLabel = new JLabel("头像");
        JLabel userName = new JLabel(user.getName());
        JLabel synopsis = new JLabel();


        userName.setFont(new Font("宋体",Font.BOLD,22));
        userName.setForeground(Color.gray);
        synopsis.setText(article.getSynopsis());
        synopsis.setOpaque(true);
        synopsis.setFont(new Font("宋体", Font.BOLD, 18));
        synopsis.setForeground(Color.gray);

        imageLabel.setPreferredSize(new Dimension(50, 30));
        userName.setPreferredSize(new Dimension(150, 30));
        synopsis.setPreferredSize(new Dimension(670, 30));

//        synopsis.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));

        JPanel likePanel = new JPanel(new GridLayout(1, 6));
        JLabel likeImage, likeNum, viewImage, viewNum, collectImage, collectNum;
        likeImage = new JLabel("赞");
        likeNum = new JLabel(String.valueOf(article.getLikeNum()));
        viewImage = new JLabel("看");
        viewNum = new JLabel(String.valueOf(article.getVisitorNum()));
        collectImage = new JLabel("收");
        collectNum = new JLabel(String.valueOf(article.getCollectNum()));

        JPanel userInfo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        userInfo.setPreferredSize(new Dimension(900, 50));

        likePanel.add(likeImage);
        likePanel.add(likeNum);
        likePanel.add(viewImage);
        likePanel.add(viewNum);
        likePanel.add(collectImage);
        likePanel.add(collectNum);

        userInfo.add(imageLabel);
        userInfo.add(userName);
        userInfo.add(synopsis);
        likePanel.setPreferredSize(new Dimension(200, 30));
        downPanel.add(userInfo);
        downPanel.add(likePanel);

        upPanel.setPreferredSize(new Dimension(1200, 53));//1200 100

        upPanel.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK));
        downPanel.setBorder(BorderFactory.createMatteBorder(1,0,0,0,Color.BLACK));

        this.add(upPanel, BorderLayout.NORTH);
        this.add(downPanel, BorderLayout.CENTER);

        this.setPreferredSize(new Dimension(1200, 110));// 1200 200

    }

    /**
     * 根据文章作者id获取用户信息
     */
    public void initInfo() {
        this.user = new User();
        User.initUser(this.user);
    }

    public void mouseClicked(MouseEvent e) {
        index.mainPanel.removeAll();
        JPanel borderLimit = new JPanel(new BorderLayout());
        borderLimit.add(new ArticleDetailsPanel(article,index),BorderLayout.CENTER);
        index.mainPanel.add(borderLimit,BorderLayout.CENTER);
        updateUI();
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        tittleLabel.setForeground(Color.RED);
    }

    public void mouseExited(MouseEvent e) {
        tittleLabel.setForeground(Color.BLACK);
    }
}
