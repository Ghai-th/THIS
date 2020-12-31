package frame.modle.label;

import entity.Article;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 文章标题标签分装类
 * 实现鼠标监听接口
 */
public class ArticleTittleLabel extends JLabel implements MouseListener {

    private Article article; // 此标题表示的文章的对象，方便查看详细信息

    public ArticleTittleLabel(Article article) {
        this.article = article;
        init();
    }


    public void init() {
        this.setOpaque(true);
        this.setText(article.getTitle());
        this.setFont(new Font("宋体",Font.BOLD,20));
    }


    public void mouseClicked(MouseEvent e) {
        System.out.println("文章详情");
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        setForeground(Color.red);
    }

    public void mouseExited(MouseEvent e) {
        setForeground(Color.black);
    }
}
