package client.frame;

import client.conf.IndexConf;
import client.entity.Article;
import client.entity.User;
import client.frame.modle.panel.ArticleDetailPanel;
import client.frame.modle.table.ArticleTable;
import client.frame.modle.table.CommentTable;
import client.frame.modle.table.UserTable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class Administrate extends JPanel implements IndexConf {

    public User Administrator;
    public JPanel northPanel;
    public JPanel centerPanel;
    public JLabel exitLable;
    public JLabel signLabel;
    public JPanel northLeft, northRight;
    public JLabel deleteUser, deleteArticle, deleteComment, articleDetail, reportDetail;
    public JLabel welcomeLable;
    public JScrollPane mainPane;
    public JTabbedPane tabbedPane;
    public JTable table;
    public JPanel functionJPanel;
    public JPanel userJpanel, articleJpanel, commentJpanel;
    public JLabel userLabel, articleLabel, commentLabel;
    public JTable userTable, articleTable, commentTable;
    public JPanel articleDetailPanel;
    public JPanel aJPanel;
    public Article article;

    public Administrate(User Administrator) {
        this.setLayout(new BorderLayout());
        this.Administrator = Administrator;
        initNorth();
        initCenter();
    }
    public void initNorth() {
        signLabel = new JLabel("THIS");
        welcomeLable = new JLabel(Administrator.getName() + "你好");
        exitLable = new JLabel("退出");

        signLabel.setFont(new Font("宋体", Font.BOLD, 20));
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
                removeAll();
                Index index =  new Index(1);
                index.removeAll();
                index.add(new Login(index));
                Administrate.this.add(index);
                updateUI();
                repaint();
            }
        });

        northPanel = new JPanel(new GridLayout(1,2));
        northLeft = new JPanel(new FlowLayout(FlowLayout.LEFT,30,10));
        northRight = new JPanel(new FlowLayout(FlowLayout.RIGHT,70,10));

        northPanel.setPreferredSize(new Dimension(WIDTH, HIGH * 53 / 1050));
        northPanel.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK));

        northLeft.add(signLabel);
        northRight.add(welcomeLable);
        northRight.add(exitLable);
        northPanel.add(northLeft);
        northPanel.add(northRight);
        this.add(northPanel, BorderLayout.NORTH);
    }

    public void initCenter() {
        centerPanel = new JPanel(new BorderLayout());
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        functionJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,30,10));

        deleteUser = new JLabel("删除用户");
        deleteUser.setFont(new Font("宋体", Font.BOLD, 20));
        deleteArticle = new JLabel("删除文章");
        deleteArticle.setFont(new Font("宋体", Font.BOLD, 20));
        articleDetail = new JLabel("文章详情");
        articleDetail.setFont(new Font("宋体", Font.BOLD, 20));
        reportDetail = new JLabel("举报详情");
        reportDetail.setFont(new Font("宋体", Font.BOLD, 20));
        deleteComment = new JLabel("删除评论");
        deleteComment.setFont(new Font("宋体", Font.BOLD, 20));

        table = new JTable(){
            public boolean isCellEditable(int rowIndex, int ColIndex){
                return false;
            }
        } ;

        userTable = new UserTable(table);
        table.setPreferredSize(new Dimension(1900, ((UserTable) userTable).userLength * 30));
        mainPane =  new JScrollPane(
                table,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        userLabel = new JLabel();
        userJpanel = new JPanel();
        userJpanel.setLayout(new GridLayout(1,1));
        userJpanel.add(mainPane);
        tabbedPane.addTab("用户管理", userJpanel);

        articleLabel = new JLabel();
        articleJpanel = new JPanel();
        articleJpanel.setLayout(new GridLayout(1,1));
        articleJpanel.add(articleLabel);
        tabbedPane.addTab("文章管理", articleJpanel);

        commentLabel = new JLabel();
        commentJpanel = new JPanel();
        commentJpanel.setLayout(new GridLayout(1,1));
        commentJpanel.add(commentLabel);
        tabbedPane.addTab("评论管理", commentJpanel);

        tabbedPane.setFont(new Font("宋体", Font.BOLD, 20));

        functionJPanel.add(deleteUser);
        functionJPanel.setPreferredSize(new Dimension(WIDTH / 6, HIGH * 53 / 1050));

        deleteUser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                deleteUser.setForeground(Color.RED);
                deleteUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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

        deleteArticle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                deleteArticle.setForeground(Color.RED);
                deleteArticle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                deleteArticle.setForeground(Color.BLACK);
            }
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("删除文章");
            }
        });

        deleteComment.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                deleteComment.setForeground(Color.RED);
                deleteComment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                deleteComment.setForeground(Color.BLACK);
            }
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("删除评论");
            }
        });

        reportDetail.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                reportDetail.setForeground(Color.RED);
                reportDetail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                reportDetail.setForeground(Color.BLACK);
            }
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("举报详情");
            }
        });

        articleDetail.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                articleDetail.setForeground(Color.RED);
                articleDetail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                articleDetail.setForeground(Color.BLACK);
            }
            //////////////////////////////////////////////////////////////////////////////////////
            @Override
            public void mouseClicked(MouseEvent e){
                int i = table.getSelectedRow();
                int j = 0;
                article = new Article();
                Iterator articleIterator = ((ArticleTable) articleTable).articleArrayList.iterator();
                while(articleIterator.hasNext())
                {
                    if(i == j) {
                        article = (Article) articleIterator.next();
                        break;
                    }
                    j++;
                }
                articleJpanel.removeAll();
                articleDetailPanel = new JPanel();
                aJPanel = new ArticleDetailPanel(article, articleDetailPanel);
                mainPane =  new JScrollPane(
                        articleDetailPanel,
                        ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                articleJpanel.setLayout(new GridLayout(1,1));
                articleJpanel.add(mainPane);
                updateUI();
            }

        });
        /////////////////////////////////////////////////////////////////////













        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(((JTabbedPane)e.getSource()).getSelectedIndex() == 0){
                    functionJPanel.removeAll();
                    functionJPanel.add(deleteUser);

                    userJpanel.removeAll();
                    table = new JTable(){
                        public boolean isCellEditable(int rowIndex, int ColIndex){
                            return false;
                        }
                    } ;
                    userTable = new UserTable(table);
                    table.setPreferredSize(new Dimension(1900,((UserTable) userTable).userLength * 30));
                    mainPane = new JScrollPane(
                            table,
                            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                    userJpanel.setLayout(new GridLayout(1,1));
                    userJpanel.add(mainPane);
                    updateUI();
                }
                else if(((JTabbedPane)e.getSource()).getSelectedIndex() == 1){
                    functionJPanel.removeAll();
                    functionJPanel.add(deleteArticle);
                    functionJPanel.add(articleDetail);
                    functionJPanel.add(reportDetail);

                    articleJpanel.removeAll();
                    table = new JTable(){
                        public boolean isCellEditable(int rowIndex, int ColIndex){
                            return false;
                        }
                    } ;
                    articleTable = new ArticleTable(table);
                    ///////////////////////////////////////////////////////
                    //返回lit
                    table.setPreferredSize(new Dimension(1900,((ArticleTable) articleTable).articleArrayList.size() * 30));
                    ///////////////////////////////////////////////////////
                    mainPane =  new JScrollPane(
                            table,
                            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                    articleJpanel.setLayout(new GridLayout(1,1));
                    articleJpanel.add(mainPane);
                    updateUI();
                }
                else if(((JTabbedPane)e.getSource()).getSelectedIndex() == 2){
                    functionJPanel.removeAll();
                    functionJPanel.add(deleteComment);

                    commentJpanel.removeAll();
                    table = new JTable(){
                        public boolean isCellEditable(int rowIndex, int ColIndex){
                            return false;
                        }
                    } ;
                    commentTable = new CommentTable(table);
                    table.setPreferredSize(new Dimension(1900,((CommentTable) commentTable).commentLength * 30));
                    mainPane =  new JScrollPane(
                            table,
                            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                    commentJpanel.setLayout(new GridLayout(1,1));
                    commentJpanel.add(mainPane);
                    updateUI();
                }
            }
        });

        centerPanel.add(tabbedPane, BorderLayout.CENTER);
        centerPanel.add(functionJPanel, BorderLayout.SOUTH);
        this.add(centerPanel, BorderLayout.CENTER);
    }

}
