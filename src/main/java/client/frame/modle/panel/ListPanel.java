package client.frame.modle.panel;

import javax.swing.*;
import java.awt.*;

public class ListPanel extends JPanel {
    JLabel imagJLabel,nameJLabel;
    String id;
    public ListPanel(String id){
        this.id = id;
        setPreferredSize(new Dimension(1920/6,100));
        this.setLayout(null);
        setBackground(new Color(61,61,61));
        init();
        setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));
    }

    public void init(){
        imagJLabel = new JLabel("头像");
        nameJLabel = new JLabel(id);

        imagJLabel.setFont(new Font("宋体",Font.PLAIN,20));
        nameJLabel.setFont(new Font("宋体",Font.BOLD,20));

        imagJLabel.setForeground(Color.white);
        nameJLabel.setForeground(Color.white);

        /*imagJLabel.setBackground(new Color(61,61,61));
        nameJLabel.setBackground(new Color(61,61,61));*/

        imagJLabel.setBounds(0,30,50,30);
        nameJLabel.setBounds(120,0,80,30);

        add(imagJLabel);
        add(nameJLabel);
    }
}
