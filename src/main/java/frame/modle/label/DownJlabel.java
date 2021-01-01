package frame.modle.label;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class DownJlabel {
    public JLabel x;

    public JLabel init(String m){
        x = new JLabel(m);
        x.setFont(new Font("宋体",Font.PLAIN,20));
        MouseAdapter adapter1 = new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

                x.setForeground(Color.black);
            }



            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                x.setForeground(new Color(255,69,0));
                x.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        };
        x.addMouseListener(adapter1);
        return x;
    }
}
