package client.frame.modle.panel;

import client.entity.User;
import client.util.ClientUtil;
import com.formdev.flatlaf.FlatLightLaf;
import server.controller.ServerOperate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class MyInfo extends JFrame {
    User user;
    JLabel headJLabel,idJLabel,nameJLabel,passwordJLabel,genderJLabel,synopsisJLabel,mykeyJLabel,bkgJLabel;
    JButton okJButton,cleanJButton;
    JTextField idJTextField,nameJTextField,mykeyJTextField,genderJTextField;
    JTextPane synopsisJTextPane;
    JPasswordField passwordJPasswordField;
    JPanel okJPanel;
    boolean state = false;
    public MyInfo(User user){
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        this.user = user;
        this.setTitle("个人信息管理");
        this.setSize(600,750);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);
        this.setLayout(null);
        init();
        this.setVisible(true);
    }
    public void init(){
        try {
            user.setOperate(ServerOperate.SELECT_USER);
            ClientUtil.sendInfo(user,User.class);
            user = ClientUtil.acceptInfo(User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        genderJTextField = new JTextField();
        initJTextField(genderJTextField);
        synopsisJTextPane = new JTextPane();
        synopsisJTextPane.setFont(new Font("楷体",Font.PLAIN,25));
        synopsisJTextPane.setBorder(BorderFactory.createLineBorder(new Color(196,196,196)));
        mykeyJTextField = new JTextField();
        initJTextField(mykeyJTextField);
        enableField();
        setCenter();
        okJPanel = new JPanel(null);
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
        cleanJButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(state){
                    passwordJPasswordField.setText("");
                    nameJTextField.setText("");
                    synopsisJTextPane.setText("");
                    genderJTextField.setText("");
                    mykeyJTextField.setText("");
                }
            }
        });
        okJButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(okJButton.getText().equals("修改")){
                    state = true;
                    ableField();
                    passwordJPasswordField.setEchoChar((char)0);
                    okJButton.setText("保存");
                }else{
                    enableField();
                    state = false;
                    passwordJPasswordField.setEchoChar('*');
                    user.setName(nameJTextField.getText());
                    user.setPassword(new String(passwordJPasswordField.getPassword()));
                    user.setSynopsis(synopsisJTextPane.getText());
                    if(genderJTextField.getText().equals("男")){
                        user.setGender(1);
                    }else if(genderJTextField.getText().equals("女")){
                        user.setGender(0);
                    }
                    user.setMyKey(mykeyJTextField.getText());
                    try {
                        user.setOperate(ServerOperate.REGISTER_USER);
                        System.out.println(user);
                        ClientUtil.sendInfo(user,User.class);
                        user = ClientUtil.acceptInfo(User.class);
                        System.out.println(user.operate);
                        if(user.operate == ServerOperate.SUCCESS){
                            System.out.println("成功了！！！！");
                            user.setOperate(ServerOperate.UPDATE_USER);
                            ClientUtil.sendInfo(user,User.class);
                            user = ClientUtil.acceptInfo(User.class);
                            if(user.operate != ServerOperate.ERROR){
                                JOptionPane.showMessageDialog(MyInfo.this,"修改成功！");
                            }else{
                                JOptionPane.showMessageDialog(MyInfo.this,"修改失败！");
                            }
                        }else{
                            JOptionPane.showMessageDialog(MyInfo.this,"密码格式不合法！");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    okJButton.setText("修改");
                }
            }
        });
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
    }
    //使得Field可编辑
    public void ableField(){
        nameJTextField.setEnabled(true);
        passwordJPasswordField.setEnabled(true);
        genderJTextField.setEnabled(true);
        synopsisJTextPane.setEnabled(true);
        mykeyJTextField.setEnabled(true);
    }
    //使得Field不可编辑
    public void enableField(){
        idJTextField.setEnabled(false);
        nameJTextField.setEnabled(false);
        passwordJPasswordField.setEnabled(false);
        genderJTextField.setEnabled(false);
        synopsisJTextPane.setEnabled(false);
        mykeyJTextField.setEnabled(false);
    }
    //设置文本框文字居中
    public void setCenter(){
        idJTextField.setHorizontalAlignment(JTextField.CENTER);
        passwordJPasswordField.setHorizontalAlignment(JTextField.CENTER);
        genderJTextField.setHorizontalAlignment(JTextField.CENTER);
        nameJTextField.setHorizontalAlignment(JTextField.CENTER);
        mykeyJTextField.setHorizontalAlignment(JTextField.CENTER);
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
