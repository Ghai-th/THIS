package client;

import client.conf.IndexConf;
import client.entity.User;
import client.frame.Administrate;
import client.frame.Index;

import javax.swing.*;

public class Main implements IndexConf {

    public static void main(String[] args) {

        JFrame jFrame = new JFrame("test");
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        Login index = new Login(jFrame);
//        jFrame.add(index);
//        Index index = new Index();
//        jFrame.add(index);
        User user = new User();
        User.initUser(user);
        Administrate administrate = new Administrate(user);
        jFrame.add(administrate);
        jFrame.setLocationRelativeTo(null);

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }
}
