package client.frame.modle.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MemberButtonPanel extends JPanel {
    JLabel imagJLabel;
    JLabel textJLabel;
    public MemberButtonPanel(String imag, String text){
        setLayout(new GridLayout(1,2));
        imagJLabel = new JLabel(imag);
        textJLabel = new JLabel(text);
        textJLabel.setFont(new Font("宋体",Font.PLAIN,15));
        imagJLabel.setFont(new Font("宋体",Font.PLAIN,15));
        add(imagJLabel);
        add(textJLabel);
        this.addMouseListener(new MouseListener() {
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
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//设置鼠标移入是光标变成手指
                setBorder(BorderFactory.createLineBorder(Color.black));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBorder(null);
            }
        });
    }
}