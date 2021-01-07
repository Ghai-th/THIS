package client.frame.modle.label;

import client.entity.Article;
import client.entity.User;
import client.frame.Index;
import client.frame.Login;
import client.frame.modle.panel.AllPanel;
import client.frame.modle.panel.ArticleDetailsPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 排行榜label封装类
 * 实现鼠标监听接口
 */
public class RankLabel extends JLabel implements MouseListener {
    public Index index;
    public User user;
    public Article article;

    public void mouseClicked(MouseEvent e) {
        index.mainPanel.removeAll();
        JPanel borderLimit = new JPanel(new BorderLayout());
        if (user != null) {
            if (Index.MeUser == null) {
                index.removeAll();
                index.add(new Login(index));
            } else {
                index.removeAll();
                index.add(new AllPanel(index,user,User.copyUser(Index.MeUser)));
                index.repaint();
                index.updateUI();
            }
        } else if (article != null){
            borderLimit.add(new ArticleDetailsPanel(article,index,borderLimit),BorderLayout.CENTER);
            index.mainPanel.add(borderLimit,BorderLayout.CENTER);
        }

        updateUI();
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        setForeground(Color.RED);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    }

    public void mouseExited(MouseEvent e) {
        setForeground(Color.BLACK);
    }

    public RankLabel(String text) {
        super(text);
    }

    public RankLabel(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
    }

    public RankLabel(Icon image) {
        super(image);
    }

    public RankLabel() {
    }

    public RankLabel(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
    }

    public RankLabel(String text, int horizontalAlignment,Index index) {
        super(text, horizontalAlignment);
        this.index = index;
    }

    public RankLabel(Index index, User user, String str) {
        super(str,JLabel.CENTER);
        this.index = index;
        this.user = user;
    }

    public RankLabel(Index index, Article article ,String str) {
        super(str,JLabel.CENTER);
        this.index = index;
        this.article = article;
    }
}
