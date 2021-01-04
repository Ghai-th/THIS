package client.frame.modle.panel;

import client.entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MemberCollectPanel extends JPanel {
    JLabel title,anthor,img,date;
    ImageIcon image;
    JTextArea content;
    String stitle = "请在此放入标题",ccontent = "请在此放入文章概述",aanthor = "作者",ddate = "时间";
    private User myUser,otherUser;
    public MemberCollectPanel(User myUser){
        this.myUser = myUser;
        init();
    }
    public MemberCollectPanel(User myUser,User otherUser){
        this.myUser = myUser;
        this.otherUser = otherUser;
    }
    public void init(){
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,2));
        title = new JLabel(stitle);
        title .setPreferredSize(new Dimension(GetWH.getWidth()*3/5-200,25));
        title = process(title);
        MouseAdapter adapter1 = new MouseAdapter() {
            //            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

                title.setForeground(Color.black);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub


            }
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                title.setForeground(new Color(255,69,0));
                title.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        };
        title.addMouseListener(adapter1);
        this.add(title,BorderLayout.NORTH);
        content = new JTextArea();
        content.setLineWrap(true);
        content.setFont(new Font("宋体",Font.PLAIN,20));
//        content.setPreferredSize(new Dimension(GetWH.getWidth()*3/5,140));
        content.setEditable(false);
        content.append(ccontent);
        content.setBorder(BorderFactory.createMatteBorder(1,0,1,0,Color.LIGHT_GRAY));
        this.add(content,BorderLayout.CENTER);
        JPanel south = new JPanel();
        south.setLayout(new FlowLayout(0));
        anthor = new JLabel(aanthor);
        anthor = process(anthor);
        image = new ImageIcon("");
        img = new JLabel("头像");
        img = process(img);
        date = new JLabel(ddate);
        date=process(date);
        south.add(img);
        south.add(anthor);
        south.add(date);
        this.add(south,BorderLayout.SOUTH);
    }
    public JLabel process(JLabel jLabel){
        jLabel.setFont(new Font("宋体,",Font.PLAIN,20));
        return jLabel;
    }
}
