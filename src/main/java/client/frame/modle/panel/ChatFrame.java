package client.frame.modle.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class ChatFrame extends JFrame {
    int xOld = 0;
    int yOld = 0;

    JPanel leftJPanel,upJPanel,centerJPanel,downJPanel,downupJPanel;
    public ChatFrame(){
        setSize(1920*3/5,864);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setLayout(null);
        init1();
        init2();
        init3();
        init5();
        init4();
        setResizable(false);
        //处理拖动事件
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xOld = e.getX();
                yOld = e.getY();
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int xOnScreen = e.getXOnScreen();
                int yOnScreen = e.getYOnScreen();
                int xx = xOnScreen - xOld;
                int yy = yOnScreen - yOld;
                setLocation(xx, yy);
            }
        });
        setVisible(true);
    }
    public void init1(){
        leftJPanel = new JPanel();
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(0);
        flowLayout.setVgap(0);
        leftJPanel.setLayout(flowLayout);
        leftJPanel.setBounds(0,0,1920/6,864);
        leftJPanel.setBackground(new Color(61,61,61));
        add(leftJPanel);
    }
    public void init2(){
        upJPanel = new JPanel();
        upJPanel.setBounds(1920/6,0,1920*3/5-1920/6,1080/12);
        upJPanel.setBackground(Color.white);
        upJPanel.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.LIGHT_GRAY));
        add(upJPanel);
    }
    public void init3(){
        centerJPanel = new JPanel();
        centerJPanel.setBounds(320,72,832,534);
        centerJPanel.setBackground(Color.white);
        centerJPanel.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.LIGHT_GRAY));
        add(centerJPanel);
    }
    public void init4(){
        downJPanel = new JPanel();
        downJPanel.setBackground(Color.white);
        downJPanel.setBounds(320,606,832,360);
        add(downJPanel);
    }
    public void init5(){
        downupJPanel = new JPanel();
        downupJPanel.setBounds(320,606,832,30);
        downupJPanel.setBackground(Color.WHITE);
        add(downupJPanel);
    }
    public static void main(String[] args) {
        new ChatFrame();
    }
}
