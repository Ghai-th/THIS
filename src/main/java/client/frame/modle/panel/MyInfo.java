package client.frame.modle.panel;

import client.entity.User;
import client.util.ClientUtil;
import com.formdev.flatlaf.FlatLightLaf;
import server.controller.ServerOperate;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MyInfo extends JFrame {
    User user;
    JLabel headJLabel,idJLabel,nameJLabel,passwordJLabel,genderJLabel,synopsisJLabel,mykeyJLabel,bkgJLabel;
    JButton okJButton,cleanJButton;
    JTextField idJTextField,nameJTextField,mykeyJTextField,genderJTextField;
    JTextPane synopsisJTextPane;
    JPasswordField passwordJPasswordField;
    JRadioButton boyJRadio,girlJRadio;
    JPanel okJPanel;
    public MyInfo(User user){
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        this.user = user;
        user.setOperate(ServerOperate.SELECT_USER);
        try {
            ClientUtil.sendInfo(user,User.class);
            user = ClientUtil.acceptInfo(User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setTitle("个人信息管理");
        this.setSize(600,750);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);
        this.setLayout(null);
        init();
        this.setVisible(true);
    }
    public void init(){
        //组件初始化
        headJLabel = new JLabel("头像");
        initJLabel(headJLabel);
        idJLabel = new JLabel("账号");
        initJLabel(idJLabel);
        nameJLabel = new JLabel("姓名");
        initJLabel(nameJLabel);
        passwordJLabel = new JLabel("密码");
        initJLabel(passwordJLabel);
        genderJLabel = new JLabel("性别");
        initJLabel(genderJLabel);
        synopsisJLabel = new JLabel("简介");
        initJLabel(synopsisJLabel);
        mykeyJLabel = new JLabel("密钥");
        initJLabel(mykeyJLabel);
        okJButton = new JButton("修改");
        cleanJButton = new JButton("清空");
        bkgJLabel = new JLabel(new ImageIcon("src/main/resources/top.png"));
        idJTextField = new JTextField();
        initJTextField(idJTextField);
        nameJTextField = new JTextField();
        initJTextField(nameJTextField);
        passwordJPasswordField = new JPasswordField();
        passwordJPasswordField.setFont(new Font("楷体",Font.PLAIN,25));
        passwordJPasswordField.setEchoChar('*');
        passwordJPasswordField.setEnabled(false);
        genderJTextField = new JTextField();
        initJTextField(genderJTextField);
        synopsisJTextPane = new JTextPane();
        synopsisJTextPane.setFont(new Font("楷体",Font.PLAIN,25));
        synopsisJTextPane.setBorder(BorderFactory.createLineBorder(new Color(196,196,196)));
        synopsisJTextPane.setEnabled(false);
        mykeyJTextField = new JTextField();
        initJTextField(mykeyJTextField);
        okJPanel = new JPanel(null);
        boyJRadio = new JRadioButton("男");
        girlJRadio = new JRadioButton("女");
        //设置初始文本框都无法编辑
        //组件放置
        bkgJLabel.setBounds(0,0,550,150);
        this.add(bkgJLabel);
        headJLabel.setBounds(30,200,50,25);
        this.add(headJLabel);
        idJLabel.setBounds(310,200,50,25);
        this.add(idJLabel);
        nameJLabel.setBounds(30,300,50,25);
        this.add(nameJLabel);
        passwordJLabel.setBounds(310,300,50,25);
        this.add(passwordJLabel);
        genderJLabel.setBounds(30,400,50,25);
        this.add(genderJLabel);
        mykeyJLabel.setBounds(310,400,50,25);
        this.add(mykeyJLabel);
        synopsisJLabel.setBounds(30,500,50,25);
        this.add(synopsisJLabel);
        cleanJButton.setBounds(160,630,120,60);
        this.add(cleanJButton);
        okJButton.setBounds(0,0,120,60);
        okJPanel.add(okJButton);
        okJPanel.setBounds(350,630,120,60);
        this.add(okJPanel);
        idJTextField.setBounds(380,185,175,50);
        this.add(idJTextField);
        passwordJPasswordField.setBounds(380,285,175,50);
        this.add(passwordJPasswordField);
        mykeyJTextField.setBounds(380,385,175,50);
        this.add(mykeyJTextField);
        nameJTextField.setBounds(100,285,175,50);
        this.add(nameJTextField);
        genderJTextField.setBounds(100,385,175,50);
        this.add(genderJTextField);
        synopsisJTextPane.setBounds(100,485,455,120);
        this.add(synopsisJTextPane);
        setText();
    }


    //设置初始JLabel的样式
    public void initJLabel(JLabel somtJLabel){
        somtJLabel.setFont(new Font("幼圆",Font.PLAIN,25));
        somtJLabel.setForeground(new Color(165,42,42));
    }

    //设置初始JTextField的样式
    public void initJTextField(JTextField someJTextField){
        someJTextField.setFont(new Font("楷体",Font.PLAIN,25));
        someJTextField.setEnabled(false);
    }

    //文本赋值
    public void setText(){
        idJTextField.setText(user.getUid());
        nameJTextField.setText(user.getName());
        passwordJPasswordField.setText(user.getPassword());
        if(user.getGender() == 0){
            genderJTextField.setText("女");
        }else{
            genderJTextField.setText("男");
        }
        synopsisJTextPane.setText(user.getSynopsis());
        mykeyJTextField.setText(user.getMyKey());
    }

}
