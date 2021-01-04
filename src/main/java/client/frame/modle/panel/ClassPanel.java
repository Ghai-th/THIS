package client.frame.modle.panel;

import client.conf.IndexConf;
import client.entity.Article;
import client.entity.Class;
import client.frame.Index;
import client.frame.modle.label.ArticleTittleLabel;
import client.util.ClientUtil;
import server.controller.ServerOperate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 类板块的panel分装
 * 传入 有8个文章信息的arrayList
 * 分类当前分类的信息
 */
public class ClassPanel extends JPanel implements MouseListener, IndexConf {

    public Class className;
    public JLabel tittleLabel;
    public ArrayList articleLists;
    public ArticleTittleLabel articleTittleLabel;
    public Index index;

    public ClassPanel(ArrayList articleLists, Class className, Index  index) {
        this.index = index;
        this.articleLists = articleLists;
        this.className = className;
        init();
    }

    public ClassPanel(Index index) {
        this.index = index;
        init();
    }

    public void init() {
        this.setOpaque(true);
        this.setLayout(new BorderLayout());

        JLabel demoLabel = new JLabel();
        demoLabel.setPreferredSize(new Dimension(INDEX_INTERVAL, INDEX_INTERVAL));
        JPanel north = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 10));
        north.setPreferredSize(new Dimension(WIDE * 5 / 8, HIGH * 2 / 21));
        north.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        north.add(demoLabel);
        tittleLabel = new JLabel(className.getName());
        tittleLabel.setOpaque(true);
        tittleLabel.setFont(new Font("宋体", Font.BOLD, 37));
        tittleLabel.setPreferredSize(new Dimension(WIDE * 5 / 64 + 20 , HIGH * 11 / 210));
        north.add(tittleLabel);
        north.add(demoLabel);
        JLabel synopsis = new JLabel();
        synopsis.setText(className.getSynopsis());
        synopsis.setOpaque(true);
        synopsis.setFont(new Font("宋体", Font.BOLD, 18));
        synopsis.setForeground(Color.gray);
        north.add(synopsis);
        this.add(north, BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(2, 4));
        center.setPreferredSize(new Dimension(WIDE * 43 / 96, HIGH * 2 / 7));

        for (Object articleList : articleLists) {
            articleTittleLabel = new ArticleTittleLabel((Article) articleList,index);
            articleTittleLabel.addMouseListener(articleTittleLabel);
            center.add(articleTittleLabel);
        }

        this.add(center, BorderLayout.CENTER);

        JPanel west = new JPanel();
        west.setPreferredSize(new Dimension(WIDE * 5 / 32, RANK_HIGH));
        west.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.BLACK));
        this.add(west, BorderLayout.EAST);
    }

    public void mouseClicked(MouseEvent e) {
        index.mainPanel.setVisible(false);
        index.mainPanel.remove(index.CCPanel);
        System.out.println(11);
        //// 从数据库拉取文章列表
        ArrayList<Article> arrayList = new ArrayList<Article>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(Article.initArticle());
        }

        index.mainPanel.add(new ArticleListPanel(arrayList,index), BorderLayout.CENTER); /// 新建出 文章列表面板
        index.mainPanel.setVisible(true);
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
