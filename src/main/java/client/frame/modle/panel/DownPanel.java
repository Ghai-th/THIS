package client.frame.modle.panel;

import client.entity.User;
import client.frame.modle.label.DownJlabel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

public class DownPanel extends TranslucenceJPanel {
    private JLabel a1,a2,a3,a4,a5;
    DownJlabel j1 = new DownJlabel();
    DownJlabel j2 = new DownJlabel();
    DownJlabel j3 = new DownJlabel();
    DownJlabel j4 = new DownJlabel();
    DownJlabel j5 = new DownJlabel();
    private User myUser,otherUser;
    public DownPanel(User myUser){
        super(new GridLayout(2, 1));
        this.myUser = myUser;
        this.setOpaque(false);
        this.setTransparent(0.01f);
        this.setBounds(GetWH.getWidth()/5+190,745, GetWH.getWidth()*3/5, 155);
        init();
    }
    public DownPanel(User myUser,User otherUser){
        super(new GridLayout(2, 1));
        this.myUser = myUser;
        this.otherUser = otherUser;
        this.setOpaque(false);
        this.setTransparent(0.01f);
        this.setBounds(GetWH.getWidth()/5+190,745, GetWH.getWidth()*3/5, 155);
        init();
    }
    public void init(){
        this.setLayout(new BorderLayout());
        TranslucenceJPanel up = new TranslucenceJPanel(new GridLayout(2, 1));
        up.setLayout(new FlowLayout());
        up.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.GRAY));
        up.setBackground(new Color(0xFDFFFB));
        a1 = j1.init("关于我们   ");
        up.add(a1);
        a2 = j2.init("招贤纳士   ");
        up.add(a2);
        a3 = j3.init("联系我们   ");
        up.add(a3);
        a4 = j4.init("THIS简介   ");
        up.add(a4);
        a5 = j5.init("邮箱：861789352@qq.com  ");
        up.add(a5);

        this.add(up,BorderLayout.NORTH);
        a3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Desktop desktop = Desktop.getDesktop();
                URI uri = null; //创建URI统一资源标识符
                try {
                    uri = new URI("https://space.bilibili.com/176534591?from=search&seid=3910647422385211263");
                    desktop.browse(uri); //使用默认浏览器打开超链接
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        a5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Desktop desktop = Desktop.getDesktop();
                URI uri = null; //创建URI统一资源标识符
                try {
                    uri = new URI("https://mail.qq.com/");
                    desktop.browse(uri); //使用默认浏览器打开超链接
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        final JTextArea text =new JTextArea();
        text.append("  感谢使用THIS论坛，孔夫子曾言，知之者不如好之者，好之者不如乐之者。看来对于鲸鱼一行一道者，最高的境界应该是乐之，" +
                "乐从何来，欧翁有醉翁之言，或许可以借鉴，乐人之乐是为其乐。埋头断案，愁思不得，忽然解惑，" +
                "如醍醐灌顶，茅塞顿开，是技术人员的常乐。偶有所得，为人解惑，则变为以人为乐为己乐。同有所惑，论之而解，有人乐更有己乐" +
                "如果有众多寻乐者，论坛既开，当趋之若鹜，乐此不疲。仁者见仁，智者见智，君子达者，会于一堂，为入者所乐，为观者所贺。虽为观者，为之所乐，" +
                "愿论坛言旺，祝THIS常青。");
        text.setLineWrap(true);
        text.setFont(new Font("宋体",Font.PLAIN,20));
        text.setPreferredSize(new Dimension(GetWH.getWidth()*3/5,140));
        text.setEditable(false);
        text.addMouseListener(new   MouseAdapter()   {
            public   void   mouseEntered(MouseEvent mouseEvent)   {
                text.setCursor(new   Cursor(Cursor.TEXT_CURSOR));   //鼠标进入Text区后变为文本输入指针
            }
            public   void   mouseExited(MouseEvent   mouseEvent)   {
                text.setCursor(new   Cursor(Cursor.DEFAULT_CURSOR));   //鼠标离开Text区后恢复默认形态
            }
        });
        text.getCaret().addChangeListener(new   ChangeListener()   {
            public   void   stateChanged(ChangeEvent e)   {
                text.getCaret().setVisible(true);   //使Text区的文本光标显示
            }
        });
        this.add(text,BorderLayout.CENTER);

    }
}
