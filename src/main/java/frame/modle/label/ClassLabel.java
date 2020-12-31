package frame.modle.label;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 大分类的label 封装
 * 点击进入相应的分类主页
 */
public class ClassLabel extends JLabel {
    public ClassLabel() {
        super();
        init();
    }

    public void init() {
        this.setOpaque(true);
        this.setFont(new Font("宋体" , Font.BOLD,20));
        this.setBorder(BorderFactory.createEmptyBorder(0,8,0,8));
        this.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {

            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {
                setBackground(Color.GRAY);
            }

            public void mouseExited(MouseEvent e) {
                setBackground(new Color(214, 217, 223));
            }
        });

    }
}
