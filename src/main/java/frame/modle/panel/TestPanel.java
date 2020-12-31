package test;

import exjpanel.TranslucenceJPanel;
import test.db.GetWH;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TestPanel extends JPanel {
    JButton testJButton;//测试按钮
    JButton chatJbutton;//放入私信按钮
    JButton attentionJbutton;//放入私聊按钮

    JLabel southJlabel;//设置背面空JLabel
    JLabel northJlabel;//设置南面空JLbale
    JLabel test = new JLabel("666");

    JPanel centerJPanel;//放入总面板中部的JPanel
    TranslucenceJPanel userJPanel;//显示用户信息
    TranslucenceJPanel userJPanel1;//放入第一行的JPanel
    TranslucenceJPanel userJPanel2;//放入第二行的JPanel
    TranslucenceJPanel userJPanel3;//放入第三行的JPanel
    TranslucenceJPanel buttonJPanel;//放入两个按钮的JPanel

    MemberPanel1 imagMemberPanel1,signMemberPanel1;
    MemberPanel2 originalMemberPanel2, rankMemberPanel2, visitMemberPanel2, gradeMemberPanel2;
    MemberPanel3 fansMemberPanel3,attentionMemberPanel3;


    int width = GetWH.getWidth();//得到宽
    int height = GetWH.getHeight();//得到高
    public TestPanel(){
        setLayout(new BorderLayout());//设置总面板的布局为东南西北，将东和西设置为无，中部布局设置为自由布局
        System.out.println(width+"，"+height);
        init1();
        init2();
        init3();
        init4();
        //setLayout(new BorderLayout());//设置总面板的布局为东南西北，将东和西设置为无，中部布局设置为自由布局
        //设置总体背景颜色
        centerJPanel.setBackground(Color.lightGray);
    }
    //成员变量的初始化以及设置监听器
    public void init1(){
        centerJPanel = new JPanel();
        southJlabel = new JLabel();
        northJlabel = new JLabel();
        userJPanel = new TranslucenceJPanel();
        userJPanel1 = new TranslucenceJPanel();
        userJPanel2 = new TranslucenceJPanel();
        userJPanel3 = new TranslucenceJPanel();
        buttonJPanel = new TranslucenceJPanel();

        chatJbutton = new JButton("私信");
        attentionJbutton = new JButton("关注");
        chatJbutton.setBackground(new Color(255,255,255));
        attentionJbutton.setBackground((new Color(255,255,255)));
        //给两个按钮设置鼠标监听器
        chatJbutton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chatJbutton.setBackground(new Color(230,230,230));
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                chatJbutton.setBorder(BorderFactory.createLineBorder(new Color(196,196,196)));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                chatJbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//设置鼠标移入是光标变成手指
                chatJbutton.setBorder(BorderFactory.createLineBorder(new Color(135,175,218)));
                chatJbutton.setBackground(new Color(227,241,250));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                chatJbutton.setBorder(BorderFactory.createLineBorder(new Color(196,196,196,196)));
                chatJbutton.setBackground(new Color(255,255,255));
            }
        });
        MouseAdapter adapter1 = new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                attentionJbutton.setBorder(BorderFactory.createLineBorder(new Color(196,196,196,196)));
                attentionJbutton.setBackground(new Color(255,255,255));

            }
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                attentionJbutton.setBackground(new Color(230,230,230));
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                attentionJbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//设置鼠标移入是光标变成手指
                attentionJbutton.setBorder(BorderFactory.createLineBorder(new Color(135,175,218)));
                attentionJbutton.setBackground(new Color(227,241,250));
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                attentionJbutton.setBorder(BorderFactory.createLineBorder(new Color(196,196,196)));
            }
        };
        attentionJbutton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                attentionJbutton.setBackground(new Color(230,230,230));
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                attentionJbutton.setBorder(BorderFactory.createLineBorder(new Color(196,196,196)));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                attentionJbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//设置鼠标移入是光标变成手指
                attentionJbutton.setBorder(BorderFactory.createLineBorder(new Color(135,175,218)));
                attentionJbutton.setBackground(new Color(227,241,250));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                attentionJbutton.setBorder(BorderFactory.createLineBorder(new Color(196,196,196,196)));
                attentionJbutton.setBackground(new Color(255,255,255));
            }
        });

        imagMemberPanel1  = new MemberPanel1("头像","666");
        imagMemberPanel1.setOpaque(false);//设置全透明
        imagMemberPanel1.setTransparent(0.1f);//设置透明度
        //imagMemberPanel1.setBorder(BorderFactory.createEtchedBorder());

        originalMemberPanel2 = new MemberPanel2("0","原创");
        originalMemberPanel2.setOpaque(false);//设置全透明
        originalMemberPanel2.setTransparent(0.1f);//设置透明度
       // originalMemberPanel2.setBorder(BorderFactory.createEtchedBorder());

        rankMemberPanel2 = new MemberPanel2("0","排名");
        rankMemberPanel2.setOpaque(false);//设置全透明
        rankMemberPanel2.setTransparent(0.1f);//设置透明度
       // rankMemberPanel2.setBorder(BorderFactory.createEtchedBorder());

        gradeMemberPanel2 = new MemberPanel2("1","等级");
        gradeMemberPanel2.setOpaque(false);//设置全透明
        gradeMemberPanel2.setTransparent(0.1f);//设置透明度
        //gradeMemberPanel2.setBorder(BorderFactory.createEtchedBorder());

        visitMemberPanel2 = new MemberPanel2("0","访客");
        visitMemberPanel2.setOpaque(false);//设置全透明
        visitMemberPanel2.setTransparent(0.1f);//设置透明度
        //visitMemberPanel2.setBorder(BorderFactory.createEtchedBorder());

        fansMemberPanel3 = new MemberPanel3("0","粉丝");
        fansMemberPanel3.setOpaque(false);//设置全透明
        fansMemberPanel3.setTransparent(0.1f);//设置透明度
        //fansMemberPanel3.setBorder(BorderFactory.createEtchedBorder());

        attentionMemberPanel3 = new MemberPanel3("0","关注");
        attentionMemberPanel3.setOpaque(false);//设置全透明
        attentionMemberPanel3.setTransparent(0.1f);//设置透明度
        ///attentionMemberPanel3.setBorder(BorderFactory.createEtchedBorder());

    }
    //成员变量的布局
    public void init2(){
        userJPanel.setBackground(Color.black);//设置显示用户信息的面板的背景颜色为白色
        userJPanel.setLayout(new GridLayout(4,1));//将显示用户窗体信息的面板布局设成3行1列
        centerJPanel.setLayout(null);//将中部面板的布局设置为绝对布局
        userJPanel1.setLayout(new GridLayout(1,1));//用户面板的第一行
        userJPanel2.setLayout(new GridLayout(1,4));//用户面板的第二行
        userJPanel3.setLayout(new GridLayout(1,2));//用户面板的第三行
        buttonJPanel.setLayout(null);
    }
    //成员变量的添加以及设置布局位置大小
    public void init3(){
        add(centerJPanel,BorderLayout.CENTER);//将中部面板添加到中部
        add(northJlabel,BorderLayout.NORTH);
        centerJPanel.setPreferredSize(new Dimension(width, height*4/5));
        userJPanel.setBounds(30,130,width/5,height*2/5+40);//设置用用户面板在中部的位置以及大小
        centerJPanel.add(userJPanel);
        northJlabel.setPreferredSize(new Dimension(width, height/5));

        //用户面板的第一行添加
        userJPanel1.add(imagMemberPanel1);
        //用户面板的第二行添加
        userJPanel2.add(originalMemberPanel2);
        userJPanel2.add(rankMemberPanel2);
        userJPanel2.add(gradeMemberPanel2);
        userJPanel2.add(visitMemberPanel2);
        //用户面板的第三行添加
        userJPanel3.add(fansMemberPanel3);
        userJPanel3.add(attentionMemberPanel3);

        //将三行JPanel添加到用户面板中
        userJPanel.add(userJPanel1);
        userJPanel.add(userJPanel2);
        userJPanel.add(userJPanel3);

        //将两个按钮加入到按钮面板中
        chatJbutton.setBounds(45,30,100,40);
        buttonJPanel.add(chatJbutton);
        attentionJbutton.setBounds(238,30,100,40);
        buttonJPanel.add(attentionJbutton);

        //将按钮面板加入到用户面板的第四行
        userJPanel.add(buttonJPanel);
    }
    //各种颜色以及透明度的设置
    public void init4(){

        userJPanel.setOpaque(false);
        userJPanel.setTransparent(0.1f);

        userJPanel1.setOpaque(false);
        userJPanel1.setTransparent(0.1f);

        userJPanel2.setOpaque(false);
        userJPanel2.setTransparent(0.1f);

        userJPanel3.setOpaque(false);
        userJPanel3.setTransparent(0.1f);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.lightGray);
        g.drawLine(80,645,462,645);
    }
    public JPanel getUserJPanel(){
        return userJPanel;
    }
}
