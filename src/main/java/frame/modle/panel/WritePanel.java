package test;

import test.db.GetWH;
import test.JPanel.MemberPanel4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class WritePanel extends JPanel {
    JPanel centerJPanel;//中部的写文章部分面板
    JPanel cnorthPanel;//中部的北面面板
    JPanel ccenterJPanel;//中部的中面面板
    JPanel csouthPanel;//中部的南面面板

    MemberPanel4 fileJpanel,pictureJPanel,expressionJPanel,mp4JPanel;
    private JPanel up,down;
    private JLabel l_title,l_yueshu;
    private JTextField t_title;
    private JComboBox<String> c_type;
    private JButton save,start;
    public WritePanel(){
        init1();
    }
    public void init1(){
        //this.setPreferredSize(new Dimension(GetWH.getWidth()*3/5-200, GetWH.getHeight()-300));
        this.setOpaque(true);
        this.setLayout(new BorderLayout());
        up = new JPanel();
        up.setLayout(new FlowLayout());
        t_title = new JTextField();
        t_title.setFont(new Font("宋体",Font.PLAIN,20));
        t_title.setForeground(Color.lightGray);
        t_title.setText("输入标题");
        t_title.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(t_title.getText().trim().equals("输入标题")){
                    t_title.setText("");
                    t_title.setForeground(Color.black);
                }else {

                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(t_title.getText().trim().equals("")) {
                    t_title.setForeground(Color.LIGHT_GRAY);
                    t_title.setText("输入标题");
                }
            }
        });

        t_title.setPreferredSize(new Dimension(800,30));
        l_title = new JLabel("标题：",JLabel.LEFT);
        l_title.setFont(new Font("宋体",Font.PLAIN,20));
        c_type = new JComboBox<String>();
        c_type.setFont(new Font("宋体",Font.PLAIN,20));
        c_type.addItem("C语言");
        c_type.addItem("数据结构");
        c_type.addItem("C++");
        c_type.addItem("数据库");
        c_type.addItem("Java");
        c_type.addItem("Golang");
        c_type.addItem("Linux");
        c_type.addItem("区块链");
        c_type.addItem("人工智能");
        c_type.addItem("软件安全");
        up.add(l_title);
        up.add(t_title);
        up.add(c_type);
        this.add(up,BorderLayout.NORTH);
        l_yueshu = new JLabel("请遵守THIS论坛的言论原则，不得违反国家法律法规               ");
        l_yueshu.setFont(new Font("宋体",Font.PLAIN,13));
        l_yueshu.setForeground(new Color(10, 3, 9, 102));
        JPanel south = new JPanel(new FlowLayout());
        south.add(l_yueshu,JPanel.LEFT_ALIGNMENT);
        save = new JButton("保存草稿");
        save.setPreferredSize(new Dimension(100,30));
        save.setFont(new Font("宋体",Font.PLAIN,15));
        south.add(save);
        start = new JButton("发表文章");
        start.setPreferredSize(new Dimension(100,30));
        start.setFont(new Font("宋体",Font.PLAIN,15));
        south.add(start);
        south.setPreferredSize(new Dimension(GetWH.getWidth()*3/5-100,50));
        this.add(south,BorderLayout.SOUTH);

    }
}
