package frame.modle.label;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 排行榜label封装类
 * 实现鼠标监听接口
 */
public class RankLabel extends JLabel implements MouseListener {

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        System.out.println("文章详情");
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        setForeground(Color.RED);

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

    public RankLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }
}
