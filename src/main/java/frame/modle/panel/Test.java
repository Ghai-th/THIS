package test;

import com.formdev.flatlaf.FlatLightLaf;
import test.db.GetWH;

import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {
    JScrollPane jScrollPane ;
    public Test(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = GetWH.getWidth();//得到宽
        int height = GetWH.getHeight();//得到高
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(0,0);

        init();
        setVisible(true);
    }
    public void init(){
        this.setLayout(new FlowLayout());
        DownPanel down = new DownPanel();
        down.setBorder(BorderFactory.createLineBorder(Color.black));

        this.add(down);
    }

    public static void main(String[] args) {
        FlatLightLaf.install();
        new Test();
    }
}
