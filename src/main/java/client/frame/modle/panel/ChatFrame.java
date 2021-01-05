package client.frame.modle.panel;

import client.entity.User;
import client.frame.MessagePanel;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ChatFrame extends JFrame {
    int xOld = 0;
    int yOld = 0;
    User sendUser,acceptUser;
    JPanel allJpanel;
    JPanel leftJPanel,upJPanel,downupJPanel;
    JTextPane centerJTextPanel,downJTextPanel;
    JButton sendJButton;

    public ChatFrame(User sendUser,User acceptUser){
        this.sendUser = sendUser;
        this.acceptUser = acceptUser;
        setSize(1920*3/5,864);
        setLocationRelativeTo(null);
        setUndecorated(true);
        //setLayout(null);
        allJpanel = new JPanel();
        allJpanel.setLayout(null);
        sendJButton = new JButton("发送");
        sendJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        init1();
        init2();
        init3();
        init4();
        init5();
        sendJButton.setBounds(1050,830,100,30);
        sendJButton.setBackground(Color.white);
        allJpanel.add(sendJButton);
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
        add(allJpanel);
        allJpanel.setBackground(Color.white);
        setBackground(Color.white);
        setVisible(true);
    }
    public void init1(){
        leftJPanel = new JPanel();
        FlowLayout f=new FlowLayout(0);
        f.setHgap(0);//水平间距
        f.setVgap(0);//组件垂直间距
        leftJPanel.setLayout(f);
        ListPanel listPanel = new ListPanel();
        leftJPanel.add(listPanel);
        leftJPanel.setBounds(0,0,1920/6,864);
        leftJPanel.setBackground(new Color(61,61,61));
        allJpanel.add(leftJPanel);
    }
    public void init2(){
        upJPanel = new JPanel();
        ImageIcon Imageone = new ImageIcon("src/main/resources/关闭.png");
        final JLabel imagJLabel = new JLabel(Imageone);
        imagJLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                imagJLabel.setBackground(Color.lightGray);
                imagJLabel.setBorder(BorderFactory.createLineBorder(Color.black));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                imagJLabel.setBorder(null);
                imagJLabel.setBackground(Color.white);
            }
        });
        upJPanel.setLayout(null);
        upJPanel.setBounds(320,0,1920*3/5-1920/6,1080/12);
        imagJLabel.setBounds(780,15,30,21);
        upJPanel.setBackground(Color.white);
        upJPanel.add(imagJLabel);
        upJPanel.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.red));
        add(upJPanel);
    }
    public void init3(){
        centerJTextPanel = new JTextPane();
        centerJTextPanel.setEditable(false);
        centerJTextPanel.setBounds(320,72,832,534);
        centerJTextPanel.setBackground(Color.white);
        centerJTextPanel.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.LIGHT_GRAY));
        allJpanel.add(centerJTextPanel);
    }
    public void init4(){
        downJTextPanel = new JTextPane();
        downJTextPanel.setBackground(Color.white);
        downJTextPanel.setBounds(320,636,832,180);
        allJpanel.add(downJTextPanel);
    }
    public void init5(){
        downupJPanel = new JPanel();
        JLabel jLabel = new JLabel("表情");
        downupJPanel.setBounds(320,606,832,30);
        downupJPanel.setBackground(Color.white);
        downupJPanel.add(jLabel);
        allJpanel.add(downupJPanel);
    }
    public static void main(String[] args) {
        //User user = new User()
        new ChatFrame(null,null);
    }
}
