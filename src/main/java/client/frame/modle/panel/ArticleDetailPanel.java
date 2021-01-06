package client.frame.modle.panel;

import client.entity.Article;
import client.entity.Comment;
import client.frame.Index;
import client.util.ClientUtil;
import server.controller.ServerOperate;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ArticleDetailPanel extends JPanel {
    public JPanel articleDetailPanel;
    public Article article;
    public JPanel articleDetailNorthPanel,articleDetailCenterPanel, articleDetailSouthPanel;
    public ArrayList<Comment> commentArrayList;
    public Comment comment;
    private List commentList;
    private JLabel reportLabel;
    public JPanel commentListPanel;

    public ArticleDetailPanel(Article article, JPanel articleDetailPanel){
        this.articleDetailPanel = articleDetailPanel;
        this.article = article;
        this.articleDetailPanel.setLayout(new BorderLayout());
        this.articleDetailPanel.setPreferredSize(new Dimension(1200, 2600));
        initNorth();
        initCenter();
        initSouth();
        initWestEast();
    }

    private void initWestEast() {

        JPanel westJpanel, EastJpanel;
        westJpanel = new JPanel();
        EastJpanel = new JPanel();
        westJpanel.setPreferredSize(new Dimension(430, 2400));
        EastJpanel.setPreferredSize(new Dimension(430, 2400));
        this.articleDetailPanel.add(westJpanel, BorderLayout.WEST);
        this.articleDetailPanel.add(EastJpanel, BorderLayout.EAST);
    }

    public void initNorth() {

        JLabel authorNameLabel, writeTimeLabel, viewNumLabel, collectionLabel, classLabel;

        JLabel articleTittle = new JLabel(article.getTitle(), JLabel.CENTER);
        articleTittle.setFont(new Font("宋体", Font.BOLD, 30));
        articleTittle.setPreferredSize(new Dimension(1850, 100));
        articleDetailNorthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        articleDetailNorthPanel.setPreferredSize(new Dimension(0, 160));

        articleDetailNorthPanel.add(articleTittle);

        authorNameLabel = new JLabel(article.getUid());
        writeTimeLabel = new JLabel(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(article.getCreate()));
        viewNumLabel = new JLabel(String.valueOf(article.getVisitorNum()));
        collectionLabel = new JLabel(String.valueOf(article.getCollectNum()));
        classLabel = new JLabel(article.getCid()); // 数据库查询
        JLabel viewEyeLabel = new JLabel(new ImageIcon("src/main/resources/articleReadEyes.png"));
        JLabel collectionIconLabel = new JLabel(new ImageIcon("src/main/resources/tobarCollectionActive.png"));
        JLabel articleClassLabel = new JLabel(Index.classification[Integer.parseInt(article.getCid()) - 1000]);

        reportLabel = new JLabel("举报");

        initLabel(authorNameLabel);
        initLabel(writeTimeLabel);
        initLabel(viewNumLabel);
        initLabel(collectionLabel);
        initLabel(classLabel);
        initLabel(reportLabel);
        initLabel(articleClassLabel);

        writeTimeLabel.setPreferredSize(new Dimension(240, 50));
        authorNameLabel.setFont(new Font("宋体", Font.BOLD, 22));
        authorNameLabel.setForeground(new Color(121, 86, 102));

        articleDetailNorthPanel.add(authorNameLabel);
        articleDetailNorthPanel.add(writeTimeLabel);
        articleDetailNorthPanel.add(viewEyeLabel);
        articleDetailNorthPanel.add(viewNumLabel);
        articleDetailNorthPanel.add(collectionIconLabel);
        articleDetailNorthPanel.add(collectionLabel);
        articleDetailNorthPanel.add(articleClassLabel);
        articleDetailNorthPanel.add(classLabel);
        articleDetailNorthPanel.add(reportLabel);

        this.articleDetailPanel.add(articleDetailNorthPanel, BorderLayout.NORTH);
    }

    public void initCenter() {
        JPanel textSynopsisPanel, textPortPanel;
        JLabel textSynopsisImageLabel, textSynopsisLabel;
        JTextPane textPortPane;

        articleDetailCenterPanel = new JPanel(new BorderLayout());

        textSynopsisPanel = new JPanel(new BorderLayout());
        textSynopsisPanel.setPreferredSize(new Dimension(1000, 225));
        textSynopsisPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        textSynopsisImageLabel = new JLabel("图片");
        textSynopsisLabel = new JLabel("简介");
        textSynopsisLabel.setText(this.article.getSynopsis());
        textSynopsisLabel.setFont(new Font("宋体",Font.PLAIN,17));
        textSynopsisLabel.setForeground(Color.gray);
        textSynopsisImageLabel.setPreferredSize(new Dimension(300, 225));
        textSynopsisLabel.setPreferredSize(new Dimension(700, 225));
        textSynopsisLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
        textSynopsisPanel.add(textSynopsisLabel, BorderLayout.WEST);
        textSynopsisPanel.add(textSynopsisImageLabel, BorderLayout.EAST);

        textPortPanel = new JPanel();
        textPortPanel.setPreferredSize(new Dimension(1000, 500));
        textPortPane = new JTextPane();
        textPortPane.setText(this.article.getText());
        textPortPane.setPreferredSize(new Dimension(1000, 500));
        textPortPane.setEditable(false);
        textPortPane.setBackground(new Color(238, 238, 238));
        textPortPane.setFont(new Font("宋体", Font.BOLD, 22));

        textPortPane.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.BLACK));
        textPortPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        textPortPanel.add(textPortPane, BorderLayout.CENTER);

        articleDetailCenterPanel.add(textSynopsisPanel, BorderLayout.NORTH);
        articleDetailCenterPanel.add(textPortPanel, BorderLayout.CENTER);
        this.articleDetailPanel.add(articleDetailCenterPanel, BorderLayout.CENTER);
    }

    public void initSouth() {
        //评论列表
        commentArrayList = new ArrayList<>();
        comment = new Comment();
        comment.setAid(this.article.getAid());
        comment.operate = ServerOperate.QUERY_ALL_COMMENT_BY_AID;
        try {
            ClientUtil.sendInfo(comment, Comment.class);
            commentList = ClientUtil.acceptList();
            commentArrayList.addAll(commentList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        articleDetailSouthPanel = new JPanel(new BorderLayout());
        commentListPanel = new JPanel(new GridLayout(commentArrayList.size(),1));
        commentListPanel.setPreferredSize(new Dimension(1200,commentArrayList.size() * 105));
        for (Comment comments : commentArrayList) {
            ArticleDetailsCommentPanel articleDetailsCommentPanel = new ArticleDetailsCommentPanel(comments);
            commentListPanel.add(articleDetailsCommentPanel);
        }

        JPanel seatJpanel = new JPanel();
        seatJpanel.setPreferredSize(new Dimension(330, commentArrayList.size() * 105));

        articleDetailSouthPanel.add(seatJpanel, BorderLayout.WEST);
        articleDetailSouthPanel.add(commentListPanel,BorderLayout.CENTER);
        this.articleDetailPanel.add(articleDetailSouthPanel, BorderLayout.SOUTH);
    }

    public void initLabel(JLabel label) {
        label.setFont(new Font("宋体", Font.BOLD, 20));
        label.setForeground(Color.gray);
        label.setPreferredSize(new Dimension(100, 50));
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label.setOpaque(true);
    }

}
