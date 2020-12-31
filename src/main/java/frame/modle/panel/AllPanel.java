package test;

import javax.swing.*;

public class AllPanel extends JPanel {
    JLabel j;
    public AllPanel(){
        setLayout(null);
        UserPanel userPanel = new UserPanel();
        ImageIcon Image=new ImageIcon("src/main/java/iamg/屏幕截图 2020-12-30 223025.png");
        j = new JLabel(Image);
        j.setBounds(0,0,1920,1080);
        setBounds(0,0,1920,1080);
        add(userPanel);
        add(j);
    }
}
