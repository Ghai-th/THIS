package client.frame.modle.panel;

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
        //中部面板的创建和设置布局
        centerJPanel = new JPanel();
        centerJPanel.setLayout(new BorderLayout());
        //centerJPanel.setPreferredSize(new Dimension(GetWH.getWidth()*3/5-200,600));
        //中部的北面面板的设置
        cnorthPanel = new JPanel();
        cnorthPanel.setLayout(new FlowLayout(0));
        //cnorthPanel.setPreferredSize(new Dimension(GetWH.getWidth()*3/5-60,100));
        final JTextArea summaryJtextArea = new JTextArea();
        summaryJtextArea.setFont(new Font("宋体",Font.PLAIN,20));
        summaryJtextArea.setLineWrap(true);//设置为自动换行
        summaryJtextArea.setBackground(Color.WHITE);
        summaryJtextArea.setPreferredSize(new Dimension(GetWH.getWidth()*3/5-80,80));
        cnorthPanel.add(summaryJtextArea);
        summaryJtextArea.append("在此输入概述");
        summaryJtextArea.setForeground(Color.LIGHT_GRAY);
        summaryJtextArea.setFont(new Font("宋体",Font.PLAIN,25));
        summaryJtextArea.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(summaryJtextArea.getText().trim().equals("在此输入概述")){
                    summaryJtextArea.setText("");
                    summaryJtextArea.setFont(new Font("宋体",Font.PLAIN,20));
                    summaryJtextArea.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(summaryJtextArea.getText().equals("")){
                    summaryJtextArea.setForeground(Color.LIGHT_GRAY);
                    summaryJtextArea.setFont(new Font("宋体",Font.PLAIN,25));
                    summaryJtextArea.append("在此输入概述");
                }
            }
        });
        centerJPanel.add(cnorthPanel,BorderLayout.NORTH);

        //中部的中面面板的设置
        ccenterJPanel = new JPanel();
        ccenterJPanel.setLayout(new FlowLayout(0));//设置中部的中面面板为流式布局
        fileJpanel = new MemberPanel4("图标:","文件");
        pictureJPanel = new MemberPanel4("图标:","图片");
        expressionJPanel = new MemberPanel4("图标:","表情");
        mp4JPanel = new MemberPanel4("图标:","视频");

        fileJpanel.setPreferredSize(new Dimension(100,40));
        pictureJPanel.setPreferredSize(new Dimension(100,40));
        expressionJPanel.setPreferredSize(new Dimension(100,40));
        mp4JPanel.setPreferredSize(new Dimension(100,40));

        ccenterJPanel.add(fileJpanel);
        ccenterJPanel.add(pictureJPanel);
        ccenterJPanel.add(expressionJPanel);
        ccenterJPanel.add(mp4JPanel);

        ccenterJPanel.setPreferredSize(new Dimension(GetWH.getWidth()*3/5,45));
        centerJPanel.add(ccenterJPanel,BorderLayout.CENTER);
        centerJPanel.add(cnorthPanel,BorderLayout.NORTH);

        //中部的南面正文面板的设置
        csouthPanel = new JPanel();
        csouthPanel.setLayout(new FlowLayout(0));
        //csouthPanel.setPreferredSize(new Dimension(GetWH.getWidth()*3/5-60,400));
        final JTextPane textJTextPane = new JTextPane();
        textJTextPane.setFont(new Font("宋体",Font.PLAIN,18));
        textJTextPane.replaceSelection("\n\n"+"             "+ "     请在此输入正文");
        textJTextPane.setFont(new Font("宋体",Font.PLAIN,45));
        textJTextPane.setForeground(Color.LIGHT_GRAY);
        textJTextPane.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(textJTextPane.getText().trim().equals("请在此输入正文")){
                    textJTextPane.setText(null);
                    textJTextPane.setFont(new Font("宋体",Font.PLAIN,25));
                    textJTextPane.setForeground(Color.black);
                }else{
                    textJTextPane.setForeground(Color.black);
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                if(textJTextPane.getText().equals("")){
                    textJTextPane.setForeground(Color.LIGHT_GRAY);
                    textJTextPane.setFont(new Font("宋体",Font.PLAIN,45));
                    textJTextPane.replaceSelection("\n\n"+"             "+ "     请在此输入正文");
                }

            }
        });
        //textJTextPane
        JScrollPane textJScrollPane = new JScrollPane(textJTextPane);
        textJScrollPane.setPreferredSize(new Dimension(GetWH.getWidth()*3/5-80,380));
        csouthPanel.add(textJScrollPane);
        centerJPanel.add(csouthPanel,BorderLayout.SOUTH);

        add(centerJPanel,BorderLayout.CENTER);

    }
}
