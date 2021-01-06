package client.frame.modle.panel;

import client.entity.Article;
import client.entity.Comment;
import client.util.ClientUtil;
import server.controller.ServerOperate;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDetailPanel extends JPanel {
    public JPanel articleDetailPanel;
    public Article article;
    public JPanel articleDetailCenterPanel, articleDetailSouthPanel;
    public ArrayList<Comment> commentArrayList;
    public Comment comment;
    private List commentList;
    public JPanel commentListPanel;

    public ArticleDetailPanel(Article article, JPanel articleDetailPanel){
        this.articleDetailPanel = articleDetailPanel;
        this.article = article;
        this.articleDetailPanel.setLayout(new BorderLayout());
        this.articleDetailPanel.setPreferredSize(new Dimension(1200, 2600));

        initCenter();
        initSouth();
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
        textSynopsisLabel.setText(this.article.getSynopsis());
        textSynopsisLabel.setFont(new Font("宋体",Font.PLAIN,17));
        textSynopsisLabel.setForeground(Color.gray);
        textSynopsisImageLabel.setPreferredSize(new Dimension(400, 225));
        textSynopsisLabel.setPreferredSize(new Dimension(800, 225));
        textSynopsisLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
        textSynopsisPanel.add(textSynopsisLabel, BorderLayout.WEST);
        textSynopsisPanel.add(textSynopsisImageLabel, BorderLayout.EAST);

        textPortPanel = new JPanel();
        textPortPanel.setPreferredSize(new Dimension(1200, 500));
        textPortPane = new JTextPane();
        textPortPane.setText(this.article.getText());
        textPortPane.setPreferredSize(new Dimension(1200, 500));
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
        articleDetailSouthPanel.add(commentListPanel,BorderLayout.CENTER);
        this.articleDetailPanel.add(articleDetailSouthPanel, BorderLayout.SOUTH);
    }

}
