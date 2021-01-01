package client.frame.modle.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MemberPanel5 extends JPanel {
    JLabel textJLabel;
    public MemberPanel5(final String text){
        textJLabel = new JLabel(text);
        setLayout(new GridLayout(1,1));
        textJLabel.setFont(new Font("宋体",Font.BOLD,20));
        add(textJLabel);
        textJLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                textJLabel.setForeground(new Color(255,29,0));//设置鼠标移入后字体颜色
                textJLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//设置鼠标移入是光标变成手指
            }

            @Override
            public void mouseExited(MouseEvent e) {
                textJLabel.setForeground(Color.black);
            }
        });
    }
}
