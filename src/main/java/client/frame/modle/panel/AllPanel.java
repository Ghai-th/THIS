package client.frame.modle.panel;

import client.entity.User;
import client.frame.Index;

import javax.swing.*;

public class AllPanel extends JPanel {
    JLabel j;
    Index index;
    public AllPanel(User user){
        init();
    }
    public AllPanel(User myUser,User otherUser){
        init();
    }
    public AllPanel(User user,Index index){
        init();
    }
    public void init(){
        setLayout(null);
        UserPanel userPanel = new UserPanel();
        ImageIcon Image=new ImageIcon("src/main/resources/屏幕截图 2020-12-30 223025.png");
        j = new JLabel(Image);
        j.setBounds(0,0,1920,1080);
        setBounds(0,0,1920,1080);
        add(userPanel);
        add(j);
    }
}
