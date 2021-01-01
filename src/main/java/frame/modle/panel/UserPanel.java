package frame.modle.panel;
import frame.modle.panel.GetWH;
import frame.modle.panel.TranslucenceJPanel;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class UserPanel extends TranslucenceJPanel {
    private TranslucenceJPanel center;
    TranslucenceJPanel up,down;
    private JLabel userId,text,resource,topic,answer,j;
    private JButton b_return,b_guanli;
    public int anum,bnum,cnum,dnum;
    public TranslucenceJPanel Big;
    TestPanel testPanel;
    JScrollPane jScrollPane;
    WritePanel writePanel = new WritePanel();
    TranslucenceJPanel centerc = new TranslucenceJPanel();
    ImageIcon Imageone,Imagetwo,Imagethree,imagefour;
    JLabel imageJLabelone,imageJLabeltwo,imageJLabelthree,imageJLabelfour;
    JPanel imageJPanelone,imageJPaneltwo,imageJPanelthree,imageJPanelfour;
    public UserPanel() {
        setBounds(0,0,1920,1080);
        init();

    }
    public void init() {
        centerc.setPreferredSize(new Dimension(GetWH.getWidth()*3/5-50,1000));
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
        b_return.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
            }
        });
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
        text = new JLabel("我的文章("+anum+")",JLabel.CENTER);
        text.setFont(new Font("宋体",Font.PLAIN,30));
        //中中布局
        final TranslucenceJPanel myCenterc = new TranslucenceJPanel();
        myCenterc.setOpaque(false);
        myCenterc.setTransparent(0.1f);
        centerup.setBackground(Color.WHITE);
        myCenterc.setBackground(new Color(240,255,255));
        myCenterc.setLayout(new FlowLayout());
        myCenterc.setPreferredSize(new Dimension(800,800));
        jScrollPane = new JScrollPane(centerc);
        jScrollPane.setOpaque(false);
        jScrollPane.getViewport().setOpaque(false);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JLabel tl= new JLabel("Spring Boot整合EasyExcel（完整版包含上传解析excel和下载模板）");
        tl.setFont(new Font("宋体",Font.PLAIN,20));
        JPanel artical1 = new JPanel();
        artical1.setBackground(new Color(240,248,255));
        artical1.setPreferredSize(new Dimension(800,200));
        artical1.add(tl,JPanel.LEFT_ALIGNMENT);
        artical1.setBorder(BorderFactory.createLineBorder(Color.black));
        JPanel artical2 = new JPanel();
        artical2.add(tl,JPanel.LEFT_ALIGNMENT);
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

            }
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                clear();
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
        resource = new JLabel("写文章("+bnum+")",JLabel.CENTER);
        resource=setFontLabel(resource);

        MouseAdapter adapter2 = new MouseAdapter() {
            //            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

                resource.setForeground(Color.black);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                clear();
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
        topic = new JLabel("我的收藏("+cnum+")",JLabel.CENTER);
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
                clear();
                topic.setBorder(BorderFactory.createMatteBorder(0,0,3,0,new Color(255,69,0)));
                centerc.removeAll();
                centerc.add(new CollectPanel());
                centerc.updateUI();
                repaint();
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
        answer = new JLabel("我的评论("+dnum+")",JLabel.CENTER);
        answer=setFontLabel(answer);

        MouseAdapter adapter4 = new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                answer.setForeground(Color.black);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                clear();
                answer.setBorder(BorderFactory.createMatteBorder(0,0,3,0,new Color(255,69,0)));
                CommentPanel commentPanel = new CommentPanel();
                centerc.removeAll();
                centerc.add(commentPanel);
                centerc.updateUI();
                repaint();
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
        center.setBounds(GetWH.getWidth()/5+190,0, GetWH.getWidth()*3/5, 740);
        center.add(centerup,BorderLayout.NORTH);
        center.add(jScrollPane,BorderLayout.CENTER);

        Imageone=new ImageIcon("src/main/resources/闹钟.png");
        imageJLabelone = new JLabel(Imageone);
        imageJPanelone = new JPanel();
        imageJPanelone.setOpaque(false);
        imageJPanelone.add(imageJLabelone);
        imageJPanelone.setBounds(GetWH.getWidth()*4/5+210,100,120,86);

        imageJPanelone.addMouseListener(new MouseListener() {
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
                imageJPanelone.remove(imageJLabelone);
                Imageone = new ImageIcon("src/main/resources/闹钟text.png");
                imageJLabelone = new JLabel(Imageone);
                imageJPanelone.add(imageJLabelone);
                imageJPanelone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//设置鼠标移入是光标变成手指
                imageJPanelone.validate();
                //System.out.println("ssss");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                imageJPanelone.remove(imageJLabelone);
                Imageone = new ImageIcon("src/main/resources/闹钟.png");
                imageJLabelone = new JLabel(Imageone);
                imageJPanelone.add(imageJLabelone);
                imageJPanelone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//设置鼠标移入是光标变成手指
                imageJPanelone.validate();
                //System.out.println("ssss");
            }
        });

        ImageIcon Imagetwo=new ImageIcon("src/main/resources/电脑.png");
        imageJLabeltwo = new JLabel(Imagetwo);
        imageJPaneltwo = new JPanel();
        imageJPaneltwo.add(imageJLabeltwo);
        imageJPaneltwo.setOpaque(false);
        imageJPaneltwo.setBounds(GetWH.getWidth()*4/5+210,190,120,86);
        imageJPaneltwo.addMouseListener(new MouseListener() {
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
                imageJPaneltwo.remove(imageJLabeltwo);
                Imageone = new ImageIcon("src/main/resources/电脑text.png");
                imageJLabeltwo = new JLabel(Imageone);
                imageJPaneltwo.add(imageJLabeltwo);
                imageJPaneltwo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//设置鼠标移入是光标变成手指
                imageJPaneltwo.validate();
                //System.out.println("111");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                imageJPaneltwo.remove(imageJLabeltwo);
                Imageone = new ImageIcon("src/main/resources/电脑.png");
                imageJLabeltwo = new JLabel(Imageone);
                imageJPaneltwo.add(imageJLabeltwo);
                imageJPaneltwo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//设置鼠标移入是光标变成手指
                imageJPaneltwo.validate();
                //System.out.println("111");
            }
        });

        ImageIcon Imagethree=new ImageIcon("src/main/resources/耳机.png");
        JLabel imagJLabelthree = new JLabel(Imagethree);
        imagJLabelthree.setBounds(GetWH.getWidth()*4/5+210,270,120,86);

        ImageIcon Imagefour=new ImageIcon("src/main/resources/刷新.png");
        JLabel imagJLabelfour = new JLabel(Imagefour);
        imagJLabelfour.setBounds(GetWH.getWidth()*4/5+210,360,120,86);

        down = new DownPanel();

        Big = new TranslucenceJPanel();
        Big.setOpaque(false);
        Big.add(imageJPanelone);
        Big.add(imageJPaneltwo);
        //Big.add(imageJPanelthree);
        //Big.add(imageJPanelfour);
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
    public void clear(){
        resource.setBorder(null);
        text.setBorder(null);
        topic.setBorder(null);
        answer.setBorder(null);
    }
    public JLabel setFontLabel(JLabel jlabel){
        jlabel.setFont(new Font("宋体",Font.PLAIN,30));
        return jlabel;
    }

}
