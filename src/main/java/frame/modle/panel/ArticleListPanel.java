package frame.modle.panel;

import conf.IndexConf;
import entity.Article;
import frame.Index;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ArticleListPanel extends JPanel implements MouseListener, IndexConf { // 文章 面板

    public ArrayList articles;
    public JPanel panel;
    public Index index;

    public ArticleListPanel(ArrayList<Article> articles, Index index) {
        this.articles = articles;
        this.index = index;
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,70));
        panel.setPreferredSize(new Dimension(WIDE * 5 / 8,this.articles.size() * HIGH * 181 / 1050));
        init();
        this.setOpaque(true);
    }

    private void init() {
        for (Object article : articles) {
            ArticleSynopsisPanel articleSynopsisPanel = new ArticleSynopsisPanel((Article) article, index);
            articleSynopsisPanel.addMouseListener(articleSynopsisPanel);
            panel.add(articleSynopsisPanel);
        }
        this.add(panel);
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
