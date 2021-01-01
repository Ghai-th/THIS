package client.frame.modle.panel;

import client.entity.Comment;
import client.entity.User;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class ArticleDetailsCommentPanel extends JPanel {

    public Comment comment;
    public User commenter;

    public JLabel commenterNameLabel,dateTimeLabel;
    public JTextPane commentPane;

    public void init() {
        this.setLayout(null);
        commenterNameLabel = new JLabel(commenter.getName());
        dateTimeLabel = new JLabel(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(comment.getCreate()));
        commentPane = new JTextPane();

        commenterNameLabel.setFont(new Font("宋体",Font.BOLD,22));
        dateTimeLabel.setFont(new Font("宋体",Font.PLAIN,16));
        dateTimeLabel.setForeground(Color.gray);
        commentPane.setFont(new Font("宋体",Font.BOLD,22));
        commentPane.setEditable(false);

        commenterNameLabel.setBounds(30,20,120,40);
        commentPane.setBounds(150,20,1020,40);
        commentPane.setText(comment.getText());
        commentPane.setForeground(new Color(85, 86, 102));
        dateTimeLabel.setBounds(950,70,300,20);

        this.add(commenterNameLabel);
        this.add(commentPane);
        this.add(dateTimeLabel);
    }

    /**
     *改为从数据库拉取
     */
    public void initInfo() {
        this.commenter = new User();
        User.initUser(this.commenter);
    }


    public ArticleDetailsCommentPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
        initInfo();
        init();
    }

    public ArticleDetailsCommentPanel(LayoutManager layout) {
        super(layout);
        initInfo();
        init();
    }

    public ArticleDetailsCommentPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
        initInfo();
        init();
    }

    public ArticleDetailsCommentPanel(Comment comment) {
        this.comment = comment;
        initInfo();
        init();
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(1216,139);
        jFrame.add(new ArticleDetailsCommentPanel(Comment.initComment()));
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
