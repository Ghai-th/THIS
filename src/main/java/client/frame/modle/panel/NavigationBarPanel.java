package client.frame.modle.panel;

import client.conf.IndexConf;
import client.entity.Article;
import client.entity.Comment;
import client.entity.Store;
import client.entity.User;
import client.frame.Index;
import client.frame.Login;
import client.frame.modle.border.RoundBorder;
import client.frame.modle.label.ClassLabel;
import client.util.ClientUtil;
import server.controller.ServerOperate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NavigationBarPanel extends JPanel implements IndexConf {

    public final String[] personAction = new String[]{"收藏", "消息", "发表文章"};
    public JTextField searchTextField;
    public JLabel searchLabel;
    public JLabel headImage;
    public Index index;
    public User user;

    public NavigationBarPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public NavigationBarPanel(LayoutManager layout) {
        super(layout);
    }

    public NavigationBarPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public NavigationBarPanel(Index index) {
        this.index = index;
        init();
    }

    public NavigationBarPanel(Index index, User user) {
        this.index = index;
        this.user = user;
        init();
    }


    public void init() {
        this.setPreferredSize(new Dimension(WIDE, HIGH * 53 / 1050));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));

        final JLabel iconLabel = new JLabel();
        iconLabel.setText("图片THIS");
        iconLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                index.removeAll();
                index.setVisible(false);
                index.add(new Index());
                index.setVisible(true);
            }
        });
        this.add(iconLabel);

        ClassLabel classLabel;
        for (String string : Index.classification) {
            classLabel = new ClassLabel(index);
            classLabel.setText(string);
            this.add(classLabel);
        }

        JPanel searchPanel;
        searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        searchPanel.setPreferredSize(new Dimension(WIDE * 5 / 16, HIGH / 35));
        searchTextField = new JTextField();
        searchTextField.setPreferredSize(new Dimension(WIDE * 5 / 32, HIGH / 35));
        searchPanel.add(searchTextField);
        searchLabel = new JLabel("搜索",JLabel.CENTER);
        searchLabel.setPreferredSize(new Dimension(WIDE * 5 / 192, HIGH * 29 / 1050));
        searchLabel.setOpaque(true);
        searchLabel.setBackground(new Color(188, 16, 3, 240));
        searchLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                searchLabel.setBackground(new Color(255, 142, 141));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                searchLabel.setBackground(new Color(188, 16, 3, 240));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                ArrayList<Article> articles = new ArrayList<Article>();
                index.mainPanel.removeAll();
                String searchText = null;
                Article article = new Article();
                try {
                    searchText = searchTextField.getText();
                    article.setTitle(searchText);
                    article.setOperate(ServerOperate.GET_ARTICLE_BY_TITTLE);
                    ClientUtil.sendInfo(article,Article.class);
                    articles.addAll(ClientUtil.acceptList());
                } catch (Exception ex) {
                    System.out.println("不可为空");
                }

                if (articles.get(0).operate == ServerOperate.NONE_ARTICLE) {
                    showMessage("无查询结果");
                    return;
                }

                index.mainPanel.add(new ArticleListPanel(articles, index), BorderLayout.CENTER); /// 新建出 文章列表面板
                updateUI();

                System.out.println("点击搜索" + searchText);
            }
        });
        searchPanel.add(searchLabel);
        this.add(searchPanel);

        headImage = new JLabel("登录");
        headImage.setFont(new Font("黑体",Font.PLAIN,19));
        if (Index.MeUser != null) {
            //// 头像改为用户的头像
            headImage.setText(Index.MeUser.getName());
        } else {
            headImage.setText("登录");
        }
        headImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (Index.MeUser == null) {
                    super.mousePressed(e);
                    index.removeAll();
                    index.add(new Login(index));
                } else {
                    index.removeAll();
                    try {
                        Comment comment = new Comment(null,Index.MeUser.getUid(),null,null);
                        comment.setOperate(ServerOperate.QUERY_ALL_COMMENT_BY_UID);
                        ClientUtil.sendInfo(comment,Comment.class);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    java.util.List<Comment> commentList = null;
                    try {
                        commentList= (List) ClientUtil.acceptList();
                        if (commentList.size() == 0) {
                            commentList = null;
                        }
                    } catch (IOException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    /**
                     * 获取此用户的所有收藏信息
                     */
                    List<Store> storeList = new ArrayList<>();
                    Store store = new Store();
                    store.operate = ServerOperate.SELECT_STORE;
                    store.setUid(Index.MeUser.getUid());
                    try {
                        ClientUtil.sendInfo(store,Store.class);
                        storeList.addAll(ClientUtil.acceptList());
                    } catch (IOException | ClassNotFoundException ee) {
                        ee.printStackTrace();
                    }
                    //获取我的文章所有信息
                    Article article = new Article();
                    List<Article> articleList = new ArrayList<>();
                    article.operate = ServerOperate.GET_ARTICLE_BY_UID;
                    article.setUid(Index.MeUser.getUid());
                    try {
                        ClientUtil.sendInfo(article,Article.class);
                        articleList.addAll(ClientUtil.acceptList());
                    } catch (IOException | ClassNotFoundException eee) {
                        eee.printStackTrace();
                    }

                    index.add(new AllPanel(Index.MeUser,null,index,commentList,storeList,articleList));
                    index.updateUI();
                    index.repaint();
                }
            }

            // 下面俩实现弹窗
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
            }
        });
        headImage.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 20));
        this.add(headImage);

        for (String string : personAction) {
            classLabel = new ClassLabel(index);
            classLabel.setText(string);
            this.add(classLabel);
        }
    }

    public void showMessage(String str) {
        JOptionPane.showMessageDialog(null,str);
    }
}
