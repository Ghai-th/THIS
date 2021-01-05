package client.frame.modle.panel;

import client.entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MemberMyArticlePanel extends JPanel {
    private JLabel title,uid,create,renewal,visitor,like,collect;
    String stitle,stext,suid,createTime,renewalTime,visitorNum,likeNum,collectNum;
    private JTextArea textArea;
    private User myUser,otherUser;
    public MemberMyArticlePanel(User myUser){
        this.myUser = myUser;
        init();

    }
    public MemberMyArticlePanel(User myUser,User otherUser,String stitle,String stext, String suid,String createTime,String renewalTime,String visitorNum,String likeNum,String collectNum){

        this.myUser = myUser;
        this.otherUser = otherUser;
        this.stitle = stitle;
        this.stext = stext;
        this.suid =suid;
        this.createTime = createTime;
        this.renewalTime = renewalTime;
        this.visitorNum = visitorNum;
        this.likeNum = likeNum;
        this.collectNum = collectNum;
        init();
    }
    public void init(){
        this.setLayout(new BorderLayout());
        title = new JLabel("标题：  "+stitle);
        title .setPreferredSize(new Dimension(GetWH.getWidth()*3/5-100,25));
        title.setBorder(BorderFactory.createMatteBorder(1,0,0,0,Color.LIGHT_GRAY));
        process(title);
        MouseAdapter adapter1 = new MouseAdapter() {
            //            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                int x;
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
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setFont(new Font("宋体",Font.PLAIN,20));
        textArea.append("概述：  "+stext);
        textArea.setBackground(new Color(0xEEEEEE));
        textArea.setBorder(BorderFactory.createMatteBorder(1,0,1,0,Color.LIGHT_GRAY));
        this.add(textArea,BorderLayout.CENTER);
        JPanel down = new JPanel(new FlowLayout());
        uid = new JLabel("作者： "+suid);
        process(uid);
        down.add(uid);
        create = new JLabel("发表时间"+createTime+" ");
        process(create);
        down.add(create);
        renewal = new JLabel("最后一次更新时间"+renewalTime+" ");
        process(renewal);
        down.add(renewal);
        visitor = new JLabel("访客数"+visitorNum+" ");
        process(visitor);
        down.add(visitor);
        like = new JLabel("喜欢"+likeNum+" ");
        process(like);
        down.add(like);
        collect = new JLabel("收藏"+collectNum);
        process(collect);
        down.add(collect);
        down.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.LIGHT_GRAY));
        this.add(down,BorderLayout.SOUTH);


    }
    public void process(JLabel jLabel){
        jLabel.setFont(new Font("宋体,",Font.PLAIN,18));

    }

}
