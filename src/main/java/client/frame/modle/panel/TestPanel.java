package client.frame.modle.panel;

import client.entity.Article;
import client.entity.Attention;
import client.entity.Message;
import client.entity.User;
import client.frame.Index;
import client.util.ClientUtil;
import client.util.MessageClientUtil;
import server.controller.ServerOperate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestPanel extends JPanel {
    JButton chatJbutton;//放入私信按钮
    JButton attentionJbutton;//放入私聊按钮

    JLabel southJlabel;//设置背面空JLabel
    JLabel northJlabel;//设置南面空JLbale
    public boolean panduan;
    JPanel centerJPanel;//放入总面板中部的JPanel
    TranslucenceJPanel userJPanel;//显示用户信息
    TranslucenceJPanel userJPanel1;//放入第一行的JPanel
    TranslucenceJPanel userJPanel2;//放入第二行的JPanel
    TranslucenceJPanel userJPanel3;//放入第三行的JPanel
    TranslucenceJPanel buttonJPanel;//放入两个按钮的JPanel
    JPanel textPanel;//放在用户信息透明图的下方的热门文章推荐
    MemberArticlePanel textRowone;//放在热门文章推荐的第一行
    MemberArticlePanel textRowtwo;//放在热门文章推荐的第二行
    MemberArticlePanel textRowthree;//放在热门文章推荐的第三行
    MemberArticlePanel textRowfour;//放在热门文章推荐的第四行
    MemberArticlePanel textRowfive;//放在热门文章推荐的第五行
    MemberArticlePanel textRowsix;//放在热门文章推荐的第六行

    MemberImagPanel imagMemberPanel1,signMemberPanel1;
    MemberColorPanel originalMemberPanel2, rankMemberPanel2, visitMemberPanel2, gradeMemberPanel2;
    MemberNoColorPanel fansMemberPanel3,attentionMemberPanel3;


    int width = GetWH.getWidth();//得到宽
    int height = GetWH.getHeight();//得到高
    static User myUser,otherUser;
    public TestPanel(User myUser){
        this.myUser = myUser;
        init();
    }
    public TestPanel(User myUser,User otherUser){
        this.myUser = myUser;
        this.otherUser = otherUser;
        init();
    }
    public void init(){
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
        userJPanel = new TranslucenceJPanel(new GridLayout(2, 1));
        userJPanel1 = new TranslucenceJPanel(new GridLayout(2, 1));
        userJPanel2 = new TranslucenceJPanel(new GridLayout(2, 1));
        userJPanel3 = new TranslucenceJPanel(new GridLayout(2, 1));
        buttonJPanel = new TranslucenceJPanel(new GridLayout(2, 1));
        textPanel = new JPanel();
        textRowone = new MemberArticlePanel("热门");
        textRowtwo = new MemberArticlePanel("走进java重写");
        textRowthree = new MemberArticlePanel("走进java重写");
        textRowfour = new MemberArticlePanel("走进java重写");
        textRowfive = new MemberArticlePanel("走进java重写");
        textRowsix = new MemberArticlePanel("走进java重写");


        textRowone.setForeground(Color.lightGray);

        chatJbutton = new JButton("私信");
        attentionJbutton = new JButton("关注");
        chatJbutton.setBackground(new Color(255,255,255));
        attentionJbutton.setBackground((new Color(255,255,255)));
        //给两个按钮设置鼠标监听器
        chatJbutton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chatJbutton.setBackground(new Color(230,230,230));
                Message message = new Message();
                message.setSendId(otherUser.getUid());
                message.setOperate(ServerOperate.ONLINE_MESSAGE);
                try {
                    System.out.println("第一次上线");
                    MessageClientUtil.sendInfo(message);
                    System.out.println("第一次上线成功");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                Message message1 = new Message();
                message1.setAcceptId(otherUser.getUid());
                message1.setOperate(ServerOperate.ACCEPT_MAP_MESSAGE);
                try {
                    MessageClientUtil.sendInfo(message1);
                    System.out.println("已发送获取用户哈希表的请求");
                    HashMap<String,String> userMap = MessageClientUtil.accept();
                    System.out.println("认错地了");
                    Thread thread = new Thread(new ChatFrame(otherUser,myUser,userMap));
                    thread.start();
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
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
                if(otherUser == null){
                    JOptionPane.showMessageDialog(TestPanel.this,"请您先登录！");
                }else{
                    Attention attention1 = new Attention();
                    attention1.operate = ServerOperate.SELECT_ATTENTION_IDOL;
                    attention1.setFansId(otherUser.getUid());
                    System.out.println(attention1.getFansId());

                    List<Attention> list1 = new ArrayList<>();
                    try {
                        ClientUtil.sendInfo(attention1,Attention.class);
                        list1 .addAll(ClientUtil.acceptList());
                        System.out.println(123123123);
                        for (int i=0;i<list1.size();i++){
                            if (myUser.getUid().equals(list1.get(i).getUid())){
                                System.out.println(8888883);
                                attentionJbutton.setText("取消关注");
                                userJPanel.updateUI();
                                System.out.println("第一步");
                            }else {
                                attentionJbutton.setText("关注");
                                userJPanel.updateUI();
                            }
                        }

                    } catch (IOException | ClassNotFoundException ee) {
                        ee.printStackTrace();
                    }
                    if("取消关注".equals(attentionJbutton.getText())){
                        System.out.println("第二步");
                        myUser.setOperate(ServerOperate.UPDATE_FAN_NUM);
                        Attention attention = new Attention();
                        attention.setFansId(otherUser.getUid());
                        attention.operate = ServerOperate.DELETE_COMMENT;
                        System.out.println("第三步");
                        try {
                            System.out.println("第四步");
                            ClientUtil.sendInfo(myUser,User.class);
                            myUser = ClientUtil.acceptInfo(User.class);
                            System.out.println("第五步");
                            ClientUtil.sendInfo(attention,Attention.class);
                            System.out.println("第六步");
                            //attention = ClientUtil.acceptInfo(Attention.class);
                            if(attention.operate!=ServerOperate.ERROR){
                                JOptionPane.showMessageDialog(TestPanel.this,"取消成功");
                                attentionJbutton.setText("关注");
                                userJPanel.updateUI();
                            }

                        } catch (IOException | ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        Index.MeUser.setFansNum(Index.MeUser.getFansNum()-1);
                        userJPanel3.removeAll();
                        myUser.setFansNum(myUser.getFansNum()-1);

                    }else{
                        myUser.setOperate(ServerOperate.UPDATE_FANS_NUM);
                        Attention attention = new Attention();
                        attention.setUid(myUser.getUid());
                        attention.setFansId(otherUser.getUid());
                        attention.operate = ServerOperate.ADD_ATTENTION;
                        try {
                            ClientUtil.sendInfo(myUser,User.class);
                            myUser = ClientUtil.acceptInfo(User.class);
                            ClientUtil.sendInfo(attention,Attention.class);
                            //attention = ClientUtil.acceptInfo(Attention.class);
                            if(attention.operate!=ServerOperate.ERROR){
                                JOptionPane.showMessageDialog(null,"关注成功");
                                attentionJbutton.setText("取消关注");
                                userJPanel.updateUI();
                            }
                        } catch (IOException | ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        Index.MeUser.setFansNum(Index.MeUser.getFansNum()+1);
                        userJPanel3.removeAll();
                        myUser.setFansNum(myUser.getFansNum()+1);

                    }
                    fansMemberPanel3 = new MemberNoColorPanel(myUser.getFansNum()+"","粉丝");
                    fansMemberPanel3.setOpaque(false);//设置全透明
                    fansMemberPanel3.setTransparent(0.1f);//设置透明度
                    userJPanel3.add(fansMemberPanel3);
                    attentionMemberPanel3 = new MemberNoColorPanel(myUser.getAttentionNum()+"","关注");
                    attentionMemberPanel3.up = myUser.getAttentionNum()+"";
                    attentionMemberPanel3.down = "关注";
                    attentionMemberPanel3.setOpaque(false);//设置全透明
                    attentionMemberPanel3.setTransparent(0.1f);//设置透明度
                    userJPanel3.add(attentionMemberPanel3);
                    userJPanel3.updateUI();
                    userJPanel3.repaint();

                }

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

        imagMemberPanel1  = new MemberImagPanel("头像",myUser.getSynopsis());
        imagMemberPanel1.setOpaque(false);//设置全透明
        imagMemberPanel1.setTransparent(0.1f);//设置透明度
        //imagMemberPanel1.setBorder(BorderFactory.createEtchedBorder());

        originalMemberPanel2 = new MemberColorPanel(myUser.getArticleNum()+"","原创");
        originalMemberPanel2.setOpaque(false);//设置全透明
        originalMemberPanel2.setTransparent(0.1f);//设置透明度
       // originalMemberPanel2.setBorder(BorderFactory.createEtchedBorder());

        rankMemberPanel2 = new MemberColorPanel(myUser.getActive()+"","活跃度");
        rankMemberPanel2.setOpaque(false);//设置全透明
        rankMemberPanel2.setTransparent(0.1f);//设置透明度
       // rankMemberPanel2.setBorder(BorderFactory.createEtchedBorder());

        gradeMemberPanel2 = new MemberColorPanel(myUser.getLevel()+"","等级");
        gradeMemberPanel2.setOpaque(false);//设置全透明
        gradeMemberPanel2.setTransparent(0.1f);//设置透明度
        //gradeMemberPanel2.setBorder(BorderFactory.createEtchedBorder());

        int num = myUser.getVisitorNum()+1;
        visitMemberPanel2 = new MemberColorPanel(num+"","访客");
        myUser.setOperate(ServerOperate.UPDATE_VISITOR_NUM);
        try {
            ClientUtil.sendInfo(myUser,User.class);
            myUser = ClientUtil.acceptInfo(User.class);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        visitMemberPanel2.setOpaque(false);//设置全透明
        visitMemberPanel2.setTransparent(0.1f);//设置透明度
        //visitMemberPanel2.setBorder(BorderFactory.createEtchedBorder());

        fansMemberPanel3 = new MemberNoColorPanel(myUser.getFansNum()+"","粉丝");
        fansMemberPanel3.setOpaque(false);//设置全透明
        fansMemberPanel3.setTransparent(0.1f);//设置透明度
        //fansMemberPanel3.setBorder(BorderFactory.createEtchedBorder());

        attentionMemberPanel3 = new MemberNoColorPanel(myUser.getAttentionNum()+"","关注");
        attentionMemberPanel3.up = myUser.getAttentionNum()+"";
        attentionMemberPanel3.down = "关注";
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
        textPanel.setLayout(new GridLayout(6,1));
    }
    //成员变量的添加以及设置布局位置大小
    public void init3(){
        add(centerJPanel,BorderLayout.CENTER);//将中部面板添加到中部
        add(northJlabel,BorderLayout.NORTH);
        centerJPanel.setPreferredSize(new Dimension(width, height*4/5));
        userJPanel.setBounds(130,0,width/5,height*2/5+40);//设置用用户面板在中部的位置以及大小
        textPanel.setBounds(130,height*2/5+70,width/5,height*2/5-80);
        centerJPanel.add(userJPanel);
        centerJPanel.add(textPanel);
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

        if(otherUser==null&&myUser.getUid().equals(Index.MeUser.getUid())){

        }else {
            //将两个按钮加入到按钮面板中
            chatJbutton.setBounds(45,30,100,40);
            buttonJPanel.add(chatJbutton);
            attentionJbutton.setBounds(238,30,100,40);
            buttonJPanel.add(attentionJbutton);
        }

        //将按钮面板加入到用户面板的第四行
        if(otherUser==null&&myUser.getUid().equals(Index.MeUser.getUid())){
        }else {
            userJPanel.add(buttonJPanel);
        }


        //热门文章的添加
        List<Article> articleTopList = new ArrayList<>();
        Article article = new Article();
        article.operate = ServerOperate.GET_ARTICLE_TOP_TEN;
        try {
            ClientUtil.sendInfo(article,Article.class);
            articleTopList.addAll(ClientUtil.acceptList());
            System.out.println(articleTopList.size());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        textPanel.add(textRowone);
        textRowtwo = new MemberArticlePanel(articleTopList.get(0).getTitle());
        textPanel.add(textRowtwo);
        textRowthree = new MemberArticlePanel(articleTopList.get(1).getTitle());
        textPanel.add(textRowthree);
        textRowfour = new MemberArticlePanel(articleTopList.get(2).getTitle());
        textPanel.add(textRowfour);
        textRowfive = new MemberArticlePanel(articleTopList.get(3).getTitle());
        textPanel.add(textRowfive);
        textRowsix = new MemberArticlePanel(articleTopList.get(4).getTitle());
        textPanel.add(textRowsix);
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
    public JPanel getTextPanel(){
        return textPanel;
    }
}
