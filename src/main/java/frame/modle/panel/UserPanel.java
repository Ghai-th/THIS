package frame.modle.panel;
import frame.modle.panel.GetWH;
import frame.modle.panel.TranslucenceJPanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;


public class UserPanel extends TranslucenceJPanel {
    private TranslucenceJPanel center;
    TranslucenceJPanel up,down;
    private JLabel userId,text,resource,topic,answer,j;
    private JButton b_return,b_guanli;
    private int a,b,c,d;
    public TranslucenceJPanel Big;
    TestPanel testPanel;
    JScrollPane jScrollPane;
    WritePanel writePanel = new WritePanel();
    TranslucenceJPanel centerc = new TranslucenceJPanel();

    public UserPanel() {
        setBounds(0,0,1920,1080);
        init();

    }
    public void init() {
        centerc.setPreferredSize(new Dimension(GetWH.getWidth()*3/5-5,500));
//        centerc.setOpaque(false);
//        centerc.setTransparent(0.3f);
        this.setOpaque(false);
        this.setTransparent(0.01f);
        testPanel = new TestPanel();
        this.setLayout(new BorderLayout());
        userId  = new JLabel("adsa***sadas用户");
        up = new TranslucenceJPanel();
        up.setOpaque(false);
        up.setTransparent(0.5f);
        up.setLayout(null);
        userId.setFont(new Font("宋体",Font.PLAIN,30));
        userId.setBounds(20, 30, 800, 30);
        userId.setForeground(Color.white);
        b_return = new JButton("返回首页");
        b_return.setForeground(Color.black);
        b_return.setBackground(Color.white);
        b_return.setBounds(1500, 30, 100, 30);
        b_return.setFont(new Font("宋体",Font.PLAIN,15));
        b_guanli = new JButton("管理个人信息");
        b_guanli.setForeground(Color.black);
        b_guanli.setBackground(Color.white);
        b_guanli.setBounds(1700, 30, 160, 30);
        b_guanli.setFont(new Font("宋体",Font.PLAIN,15));
        up.add(userId);
        up.add(b_return);
        up.add(b_guanli);
        this.add(up,BorderLayout.NORTH);
        up.setPreferredSize(new Dimension(GetWH.getWidth(),100));
        up.setBorder(BorderFactory.createMatteBorder(0,5,0,0,new Color(255,69,0)));
        up.setBackground(new Color(0,0,0,0.9f));
//中间布局
        center = new TranslucenceJPanel();
        center.setOpaque(false);
        center.setTransparent(0.01f);
        //中北布局
        JPanel centerup = new JPanel();
        centerup.setLayout(new GridLayout(1,8));
        center.setLayout(new BorderLayout());
        text = new JLabel("我的文章("+a+")",JLabel.CENTER);
        text.setFont(new Font("宋体",Font.PLAIN,30));
        //中中布局
        final TranslucenceJPanel myCenterc = new TranslucenceJPanel();
        myCenterc.setOpaque(false);
        myCenterc.setTransparent(0.1f);
        centerup.setBackground(Color.WHITE);
        myCenterc.setBackground(new Color(240,255,255));
        myCenterc.setLayout(new GridLayout(5,1));
        jScrollPane = new JScrollPane(centerc);
        jScrollPane.setOpaque(false);
        jScrollPane.getViewport().setOpaque(false);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JLabel tl= new JLabel("gdisahodhaoishdoahsodhaoishfihfidoshhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhowwwwwwwwwwwwwwwwwww");
        tl.setFont(new Font("宋体",Font.PLAIN,20));
        JPanel artical1 = new JPanel();
        artical1.setBackground(new Color(240,248,255));
        //artical1.setPreferredSize(new Dimension(800,200));
        artical1.add(tl,JPanel.LEFT_ALIGNMENT);
        artical1.setBorder(BorderFactory.createLineBorder(Color.black));
        JPanel artical2 = new JPanel();
        artical2.add(tl);
        artical2.setBackground(new Color(240,248,255));
        artical2.setPreferredSize(new Dimension(800,200));
        myCenterc.add(artical1);
        myCenterc.add(artical2);
        centerc.add(myCenterc);
        MouseAdapter adapter1 = new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                text.setForeground(Color.black);
                //text.setBorder(null);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                resource.setBorder(null);
                text.setBorder(null);
                topic.setBorder(null);
                answer.setBorder(null);
                text.setBorder(BorderFactory.createMatteBorder(0,0,3,0,new Color(255,69,0)));
                centerc.removeAll();
                centerc.add(myCenterc);
                centerc.updateUI();
                repaint();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                text.setForeground(new Color(255,69,0));
                text.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        };
        text.addMouseListener(adapter1);
        centerup.add(text);
        resource = new JLabel("写文章("+b+")",JLabel.CENTER);
        resource.setFont(new Font("宋体",Font.PLAIN,30));

        MouseAdapter adapter2 = new MouseAdapter() {
            //            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

                resource.setForeground(Color.black);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                resource.setBorder(null);
                text.setBorder(null);
                topic.setBorder(null);
                answer.setBorder(null);
                resource.setBorder(BorderFactory.createMatteBorder(0,0,3,0,new Color(255,69,0)));
                centerc.removeAll();
                centerc.add(new WritePanel());
                centerc.updateUI();
                repaint();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                resource.setForeground(new Color(255,69,0));
                resource.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        };
        resource.addMouseListener(adapter2);
        centerup.add(resource);
        topic = new JLabel("论坛("+c+")",JLabel.CENTER);
//		topic.setBounds(310, 20, 100, 20);
        topic.setFont(new Font("宋体",Font.PLAIN,30));
        MouseAdapter adapter3 = new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

                topic.setForeground(Color.black);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                resource.setBorder(null);
                text.setBorder(null);
                topic.setBorder(null);
                answer.setBorder(null);
                topic.setBorder(BorderFactory.createMatteBorder(0,0,3,0,new Color(255,69,0)));
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                topic.setForeground(new Color(255,69,0));
                topic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        };
        topic.addMouseListener(adapter3);
        topic.addMouseMotionListener(adapter3);
        centerup.add(topic);
        answer = new JLabel("问答("+d+")",JLabel.CENTER);

//		answer.setBounds(430, 20, 100, 20);
        answer.setFont(new Font("宋体",Font.PLAIN,30));
        MouseAdapter adapter4 = new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                answer.setForeground(Color.black);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                resource.setBorder(null);
                text.setBorder(null);
                topic.setBorder(null);
                answer.setBorder(null);
                answer.setBorder(BorderFactory.createMatteBorder(0,0,3,0,new Color(255,69,0)));
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                answer.setForeground(new Color(255,69,0));
                answer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        };
        answer.addMouseListener(adapter4);
        centerup.add(answer);

        //center.setBackground(new Color(250,235,215));
        center.setBounds(GetWH.getWidth()/5+90,0, GetWH.getWidth()*3/5, 740);
        center.add(centerup,BorderLayout.NORTH);
        center.add(jScrollPane,BorderLayout.CENTER);
        down = new DownPanel();

        Big = new TranslucenceJPanel();
        Big.setOpaque(false);
        Big.setTransparent(0.01f);
        Big.setPreferredSize(new Dimension(GetWH.width, GetWH.height*4/5));
        Big.setLayout(null);
        Big.add(testPanel.getUserJPanel());
        Big.add(testPanel.getTextPanel());
        Big.add(center);
        Big.add(down);
        //Big.setBackground(Color.lightGray);
        this.add(Big,BorderLayout.CENTER);

    }

}
