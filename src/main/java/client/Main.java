package client;

import client.conf.IndexConf;
import client.frame.Index;
//import client.frame.modle.panel.JframeBackGround;
import client.util.MessageClientUtil;

import javax.swing.*;
import java.awt.*;

public class Main implements IndexConf {
    public static void main(String[] args) {
        new MessageClientUtil();
//        JFrame jFrame = new JframeBackGround("test");
        JFrame jFrame = new JFrame("test");
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Index index = new Index();
        jFrame.add(index);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
