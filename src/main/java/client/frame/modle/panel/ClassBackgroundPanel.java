package client.frame.modle.panel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ClassBackgroundPanel extends JPanel {
    private Image img;

    public ClassBackgroundPanel(String className) {
        switch (className) {
            case "C语言":
                try {
                    img = ImageIO.read(new File("src/main/resources/C语言简洁.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "数据结构":
                try {
                    img = ImageIO.read(new File("src/main/resources/数据结构.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "C++":
                try {
                    img = ImageIO.read(new File("src/main/resources/C++.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "数据库":
                try {
                    img = ImageIO.read(new File("src/main/resources/数据库.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "Java":
                try {
                    img = ImageIO.read(new File("src/main/resources/Java.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "Golang":
                try {
                    img = ImageIO.read(new File("src/main/resources/Golang.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "Linux":
                try {
                    img = ImageIO.read(new File("src/main/resources/Linux.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "区块链":
                try {
                    img = ImageIO.read(new File("src/main/resources/区块链.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "人工智能":
                try {
                    img = ImageIO.read(new File("src/main/resources/人工智能.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "软件安全":
                try {
                    img = ImageIO.read(new File("src/main/resources/软件安全.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    public void paint(Graphics g) {
        super.paint(g);
        //下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小
        g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), null);
    }

}

