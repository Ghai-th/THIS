package client.frame.modle.panel;

import client.entity.User;

import javax.swing.*;
import java.awt.*;

public class testframe extends JFrame {
    JScrollPane allJScrollPane;
    public testframe(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = GetWH.getWidth();//得到宽
        int height = GetWH.getHeight();//得到高
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(0,0);

        AllPanel allPanel = new AllPanel(new User(),new User());
        add(allPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        //FlatLightLaf.install();
        new testframe();
    }

}
