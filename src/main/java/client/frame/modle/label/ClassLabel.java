package client.frame.modle.label;

import client.entity.Article;
import client.frame.Index;
import client.frame.modle.panel.ArticleListPanel;
import client.util.ClientUtil;
import data.Operate;
import server.controller.ServerOperate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 大分类的label 封装
 * 点击进入相应的分类主页
 */
public class ClassLabel extends JLabel {
    public Index index;
    public ArrayList arrayList;

    public ClassLabel(Index index) {
        super();
        this.index = index;
        init();
    }

    public void init() {
        this.setOpaque(true);
        this.setFont(new Font("宋体" , Font.BOLD,20));
        this.setBorder(BorderFactory.createEmptyBorder(0,8,0,8));

        this.addMouseListener(new MouseListener() {
            // 发送对应的请求 更新文章列表
            public void mouseClicked(MouseEvent mouseEvent) {

                switch (getText()) {
                    case "收藏":
                        System.out.println("进入收藏");
                        break;
                    case "消息":
                        System.out.println("进入消息");
                        break;
                    case "发表文章":
                        System.out.println("创作界面");
                        break;
                    case "C语言":
                        System.out.println("C语言");
                        break;
                    case "数据结构":
                        System.out.println("数据结构");
                        break;
                    case "C++":
                        System.out.println("C++");
                        break;
                    case "数据库":
                        System.out.println("数据库");
                        break;
                    case "Java":
                        System.out.println("Java");
                        break;
                    case "Golang":
                        System.out.println("Golang");
                        break;
                    case "linux":
                        System.out.println("linux");
                        break;
                    case "区块链":
                        System.out.println("区块链");
                        break;
                    case "人工智能":
                        System.out.println("人工智能");
                        break;
                    case "软件安全":
                        System.out.println("软件安全");
                        arrayList = new ArrayList();
                        Article article = new Article();
                        article.setCid("1009");
                        try {
                            ClientUtil.sendInfo(article,Article.class);
                            arrayList.addAll(ClientUtil.acceptList());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                }

                index.mainPanel.removeAll();
                index.mainPanel.add(new ArticleListPanel(arrayList,index), BorderLayout.CENTER); /// 新建出 文章列表面板
                updateUI();
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {
                setBackground(Color.GRAY);
            }

            public void mouseExited(MouseEvent e) {
                setBackground(new Color(238, 238, 238));
            }
        });

    }
}
