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
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//设置鼠标移入是光标变成手指

        this.addMouseListener(new MouseListener() {
            // 发送对应的请求 更新文章列表
            public void mouseClicked(MouseEvent mouseEvent) {

                switch (getText()) {
                    case "收藏":
                        System.out.println("进入收藏");
                        ///// 连接个人中心
                        return;
                    case "消息":
                        System.out.println("进入消息");
                        ///// 写写消息界面
                        return;
                    case "发表文章":
                        System.out.println("创作界面");
                        ///// 连接创作界面
                        return;
                    case "C语言":
                        initData("1000");
                        break;
                    case "数据结构":
                        initData("1001");
                        break;
                    case "C++":
                        initData("1002");
                        break;
                    case "数据库":
                        initData("1003");
                        break;
                    case "Java":
                        initData("1004");
                        break;
                    case "Golang":
                        initData("1005");
                        break;
                    case "linux":
                        initData("1006");
                        break;
                    case "区块链":
                        initData("1007");
                        break;
                    case "人工智能":
                        initData("1008");
                        break;
                    case "软件安全":
                        initData("1009");
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
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                setBackground(new Color(238, 238, 238));
            }
        });
    }

    public void initData(String cid) {
        arrayList = new ArrayList();
        Article article = new Article();
        article.setCid(cid);
        article.setOperate(ServerOperate.GET_ARTICLE_BY_CID);
        try {
            ClientUtil.sendInfo(article,Article.class);
            arrayList.addAll(ClientUtil.acceptList());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("classlabel");
        }
    }
}
