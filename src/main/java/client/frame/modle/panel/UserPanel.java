package client.frame.modle.panel;

import client.entity.Article;
import client.entity.Comment;
import client.entity.Store;
import client.entity.User;
import client.frame.Index;
import client.util.ClientUtil;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import server.controller.ServerOperate;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;


public class UserPanel extends TranslucenceJPanel implements Runnable {
    private TranslucenceJPanel center;
    TranslucenceJPanel up,down;
    private JLabel userId,text,resource,topic,answer,j;
    private JButton b_return,b_guanli;
    public int anum,cnum,dnum;
    public TranslucenceJPanel Big;
    public static boolean returnall = false;
    TestPanel testPanel;
    JScrollPane jScrollPane;
    WritePanel writePanel ;
    TranslucenceJPanel centerc = new TranslucenceJPanel();
    ImageIcon Imageone,Imagetwo,Imagethree,imagefour;
    JLabel imageJLabelone,imageJLabeltwo,imageJLabelthree,imageJLabelfour;
    JPanel imageJPanelone,imageJPaneltwo,imageJPanelthree,imageJPanelfour;
    static User myUser,otherUser;
    AllPanel allPanel;
    List<Comment> commentList = null;
    List<Store> storeList = null;
    List<Article> articleList = null;
    public Index index;
    public static int sign = 0;
    boolean state = false;//音乐的播放状态
    Thread [] music = new Thread[30];
    int i = 0;
    public UserPanel() {
        setBounds(0,0,1920,1080);
        init();

    }
    public UserPanel(User user){
        this.myUser = user;
        setBounds(0,0,1920,1080);
        init();
    }
    public UserPanel(User myUser, User otherUser, Index index, AllPanel allPanel, List<Comment> commentList, List<Store> storeList, List<Article> articleList){
        this.commentList = commentList;
        this.storeList = storeList;
        if(storeList==null){
            cnum = 0;
        }else{
            cnum = storeList.size();
        }
        this.articleList = articleList;
        anum = articleList.size();
        this.myUser = myUser;
        this.otherUser = otherUser;
        this.index = index;
        this.allPanel = allPanel;
        setBounds(0,0,1920,1080);
        init();
    }
    public void init() {
        //User.initUser(myUser);
        writePanel = new WritePanel(myUser);
        centerc.setPreferredSize(new Dimension(GetWH.getWidth()*3/5-50,5000));
//        centerc.setOpaque(false);
//        centerc.setTransparent(0.3f);
        this.setOpaque(false);
        this.setTransparent(0.01f);
        testPanel = new TestPanel(myUser,otherUser);
        this.setLayout(new BorderLayout());
        userId  = new JLabel(myUser.getName());
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
                index.removeAll();
                index.setVisible(false);
                //Index.MeUser = myUser;
                index.add(new Index(myUser));
                index.setVisible(true);
            }
        });
        b_guanli = new JButton("信息管理");
        b_guanli.setForeground(Color.black);
        b_guanli.setBackground(Color.white);
        b_guanli.setBounds(1700, 30, 160, 30);
        b_guanli.setFont(new Font("宋体",Font.PLAIN,15));
        up.add(userId);
        b_guanli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyInfo(myUser);
            }
        });
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
        centerup.setBackground(Color.WHITE);
        //中中布局
        final MyCenterc myCenterc = new MyCenterc(myUser,otherUser,articleList);
        jScrollPane = new JScrollPane(centerc);
        jScrollPane.getVerticalScrollBar().setUnitIncrement(20);
        jScrollPane.setOpaque(false);
        jScrollPane.getViewport().setOpaque(false);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
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
        resource = new JLabel("写文章",JLabel.CENTER);
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
                centerc.add(new WritePanel(myUser));
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
                centerc.add(new CollectPanel(myUser,otherUser,storeList));
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
        int comnum;
        if(commentList==null){
            comnum = 0;
        }else{
            comnum = commentList.size();
        }
        answer = new JLabel("我的评论("+comnum+")",JLabel.CENTER);
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

                CommentPanel commentPanel = new CommentPanel(myUser,commentList);
                centerc.setPreferredSize(new Dimension(800,250*commentList.size()));
                centerc.removeAll();
                centerc.add(commentPanel);
                JScrollBar sBar = jScrollPane.getVerticalScrollBar();
                sBar.setValue(sBar.getMinimum());
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
        Imageone=new ImageIcon("src/main/resources/音乐.png");
        imageJLabelthree = new JLabel(Imageone);
        imageJPanelthree = new JPanel();
        imageJPanelthree.setOpaque(false);
        imageJPanelthree.add(imageJLabelthree);
        imageJPanelthree.setBounds(GetWH.getWidth()*4/5+210,270,120,86);
        imageJPanelthree.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //播放音乐
                music[++i] = new Thread("music"){
                    public void run(){
                            String filename="src/main/resources/祖海 - 好运来.mp3";
                            try {
                                BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(filename));
                                Player player = new Player(buffer);
                                player.play();
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                    }
                };
                imageJPanelthree.remove(imageJLabelthree);
                if(state == false){
                    Imageone = new ImageIcon("src/main/resources/开始.png");
                    state = true;
                    imageJLabelthree = new JLabel(Imageone);
                    imageJPanelthree.add(imageJLabelthree);
                    imageJPanelthree.validate();
                    imageJPanelthree.updateUI();
                    music[i].start();
                } else{
                    Imageone = new ImageIcon("src/main/resources/暂停.png");
                    imageJLabelthree = new JLabel(Imageone);
                    imageJPanelthree.add(imageJLabelthree);
                    imageJPanelthree.validate();
                    imageJPanelthree.updateUI();
                    music[--i].stop();
                    state = false;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                imageJPanelthree.remove(imageJLabelthree);
                if(state == false)
                    Imageone = new ImageIcon("src/main/resources/暂停.png");
                else
                    Imageone = new ImageIcon("src/main/resources/开始.png");
                imageJLabelthree = new JLabel(Imageone);
                imageJPanelthree.add(imageJLabelthree);
                imageJPanelthree.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//设置鼠标移入是光标变成手指
                imageJPanelthree.validate();
                //System.out.println("111");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                imageJPanelthree.remove(imageJLabelthree);
                Imageone = new ImageIcon("src/main/resources/音乐.png");
                imageJLabelthree = new JLabel(Imageone);
                imageJPanelthree.add(imageJLabelthree);
                imageJPanelthree.setCursor(Cursor.getDefaultCursor());//设置鼠标移入是光标变成手指
                imageJPanelthree.validate();
                //System.out.println("111");
            }
        });
        Imageone=new ImageIcon("src/main/resources/刷新.png");
        imageJLabelfour = new JLabel(Imageone);
        imageJPanelfour = new JPanel();
        imageJPanelfour.setOpaque(false);
        imageJPanelfour.add(imageJLabelfour);
        imageJPanelfour.setBounds(GetWH.getWidth()*4/5+210,360,120,86);
        imageJPanelfour.addMouseListener(new MouseListener() {
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
                imageJPanelfour.remove(imageJLabelfour);
                Imageone = new ImageIcon("src/main/resources/刷新text.png");
                imageJLabelfour = new JLabel(Imageone);
                imageJPanelfour.add(imageJLabelfour);
                imageJPanelfour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//设置鼠标移入是光标变成手指
                imageJPanelfour.validate();
                //System.out.println("111");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                imageJPanelfour.remove(imageJLabelfour);
                Imageone = new ImageIcon("src/main/resources/刷新.png");
                imageJLabelfour = new JLabel(Imageone);
                imageJPanelfour.add(imageJLabelfour);
                imageJPanelfour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//设置鼠标移入是光标变成手指
                imageJPanelfour.validate();
                //System.out.println("111");
            }
        });


        down = new DownPanel(myUser);

        Big = new TranslucenceJPanel();
        Big.setOpaque(false);
        Big.add(imageJPanelone);
        Big.add(imageJPaneltwo);
        Big.add(imageJPanelthree);
        Big.add(imageJPanelfour);
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

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
