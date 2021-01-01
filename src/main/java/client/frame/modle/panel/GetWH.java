package client.frame.modle.panel;

import java.awt.*;

public class GetWH {
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int width = (int)screenSize.getWidth();//得到宽
    public static int height = (int)screenSize.getHeight();//得到高

    public static int getWidth(){
        return width;
    }
    public  static  int getHeight(){
        return height;
    }

}
