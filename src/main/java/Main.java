import conf.IndexConf;
import frame.Index;
import frame.Login;

import javax.swing.*;

public class Main implements IndexConf {

    public static void main(String[] args) {

        JFrame jFrame = new JFrame("test");
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        Login index = new Login(jFrame);
//        jFrame.add(index);
        Index index = new Index();
        jFrame.add(index);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }
}
