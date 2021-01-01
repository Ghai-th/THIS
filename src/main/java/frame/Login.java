package frame;

import com.formdev.flatlaf.FlatLightLaf;
import conf.IndexConf;
import frame.modle.border.RoundBorder;
import frame.modle.panel.NavigationBarPanel;
import frame.modle.panel.TranslucenceJPanel;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.*;

public class Login extends JPanel implements ActionListener, IndexConf {
    //登录
    JFrame jFrame;
    JLabel idJLabel,passwordJLabel,registerJLabel,forgetJLabel,bkgJLabel,titleJLabel;
    JTextField idJTextField;
    JLabel loginJLabel;
    JPasswordField passwordJPasswordField;
    JPanel centerJPanel;
    TranslucenceJPanel infoJPanel,randomJPanel;
    //String titleString,textString;
    JTextPane textJTextPane;
    //注册
    JLabel helloJLabel,hadJLabel,goJLabel,id1JLabel,password1JLabel,password2JLabel,okJLabel,messageJLabel,message1JLabel;
    JTextField id1JTextField;
    JPasswordField password3JPassword,password4JPassword;
    RoundBorder whiteBorder = new RoundBorder(Color.white);
    RoundBorder grayBorder = new RoundBorder(Color.gray);
    //找回密码
    JLabel findidJLabel,checkJLabel,findJLabel,returnJLabel;
    JTextField findidJTextField,checkJTextField;

    Index index;
    //定时器监听的鼠标监听时间
    MouseListener a = new MouseListener() {
        public void mouseClicked(MouseEvent e) {
            jFrame.remove(Login.this);
            jFrame.add(new Index());
            jFrame.setVisible(true);
        }
        public void mousePressed(MouseEvent e) {
            loginJLabel.setBackground(new Color(30,150,230));
        }

        public void mouseReleased(MouseEvent e) {
            loginJLabel.setBackground(new Color(30,170,252));
        }

        public void mouseEntered(MouseEvent e) {
            loginJLabel.setBackground(new Color(30,170,252));
            loginJLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        public void mouseExited(MouseEvent e) {
            loginJLabel.setBackground(new Color(30,196,252));
        }
    };
    MouseListener b = new MouseListener() {

        public void mouseClicked(MouseEvent e) {

        }

        public void mousePressed(MouseEvent e) {
            okJLabel.setBackground(new Color(30,150,230));
        }

        public void mouseReleased(MouseEvent e) {
            okJLabel.setBackground(new Color(30,170,252));
        }

        public void mouseEntered(MouseEvent e) {
            okJLabel.setBackground(new Color(30,170,252));
            okJLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        public void mouseExited(MouseEvent e) {
            okJLabel.setBackground(new Color(30,196,252));
        }
    };
    MouseListener c = new MouseListener() {
        public void mouseClicked(MouseEvent e) {
        }
        public void mousePressed(MouseEvent e) {
            findJLabel.setBackground(new Color(30,150,230));
        }


        public void mouseReleased(MouseEvent e) {
            findJLabel.setBackground(new Color(30,170,252));
        }


        public void mouseEntered(MouseEvent e) {
            findJLabel.setBackground(new Color(30,170,252));
            findJLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        public void mouseExited(MouseEvent e) {
            findJLabel.setBackground(new Color(30,196,252));
        }
    };
    MouseAdapter d = new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);
            messageJLabel.setForeground(new Color(150,170,255));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);
            messageJLabel.setForeground(new Color(155,155,155));
        }
    };
    MouseAdapter e = new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);
            message1JLabel.setForeground(new Color(150,170,255));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);
            message1JLabel.setForeground(new Color(155,155,155));
        }
    };
    FocusListener f = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            password3JPassword.setBorder(whiteBorder);
        }

        @Override
        public void focusLost(FocusEvent e) {
            password3JPassword.setBorder(grayBorder);
        }
    };
    FocusListener g = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            password4JPassword.setBorder(whiteBorder);
        }

        @Override
        public void focusLost(FocusEvent e) {
            password4JPassword.setBorder(grayBorder);
        }
    };
    FocusListener h = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            findidJTextField.setBorder(whiteBorder);
        }

        @Override
        public void focusLost(FocusEvent e) {
            findidJTextField.setBorder(grayBorder);        }
    };
    FocusListener i = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            checkJTextField.setBorder(whiteBorder);
        }

        @Override
        public void focusLost(FocusEvent e) {
            checkJTextField.setBorder(grayBorder);        }
    };
    //状态记录
    boolean isChange1 = false;
    boolean isChange2 = false;
    Timer timer = new Timer(200,this);
    //构造函数，调用扁平化风格，初始化总界面的布局方式及标题等
    public Login(JFrame jFrame,Index index) {
        this.index = index;
        this.jFrame = jFrame;
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        this.setLayout(new BorderLayout());
        init();
        this.setVisible(true);
        timer.start();
    }


    //初始化north与center
    public void init () {
        initNorth();
        initCenter();
    }
    //初始化north
    public void initNorth(){
        NavigationBarPanel navigationBarPanel = new NavigationBarPanel(index);
        this.add(navigationBarPanel, BorderLayout.NORTH);
    }

    //初始化center
    public void initCenter(){
        centerJPanel = new JPanel(null);
        randomJPanel = new TranslucenceJPanel();
        randomJPanel.setOpaque(false);
        randomJPanel.setLayout(null);
        randomJPanel.setTransparent(0.5f);
        randomJPanel.setBounds(600,150,350,500);
        randomJPanel.setBackground(Color.black);
        centerJPanel.add(randomJPanel);
        titleJLabel = new JLabel();
        titleJLabel.setText("哈哈哈");
        titleJLabel.setFont(new Font("黑体",Font.PLAIN,30));
        titleJLabel.setForeground(Color.white);
        titleJLabel.setBounds(50,80,300,30);
        randomJPanel.add(titleJLabel);
        textJTextPane = new JTextPane();
        textJTextPane.setText("啦啦啦啦啦读取文件哦的玩去哪低品位去年底我脾气");
        textJTextPane.setEditable(false);
        textJTextPane.setFont(new Font("黑体",Font.PLAIN,20));
        textJTextPane.setForeground(Color.white);
        textJTextPane.setBounds(45,130,270,200);
        SimpleAttributeSet a = new SimpleAttributeSet();
        StyleConstants.setLineSpacing(a,0.5f);
        textJTextPane.setParagraphAttributes(a,false);
        textJTextPane.setOpaque(false);
        randomJPanel.add(textJTextPane);
        bkgJLabel = new JLabel(new ImageIcon("src/main/resources/bkg.png"));
        bkgJLabel.setBounds(0,0,1920,950);
        //初始化信息窗体
        initInfo();
        centerJPanel.add(bkgJLabel);
        this.add(centerJPanel,BorderLayout.CENTER);
    }
    //初始化信息窗体
    public void initInfo(){
        infoJPanel = new TranslucenceJPanel();
        infoJPanel.setOpaque(false);
        infoJPanel.setLayout(null);
        infoJPanel.setTransparent(0.8f);
        infoJPanel.setBounds(950,150,450,500);
        centerJPanel.add(infoJPanel);
        //初始化登陆界面组件
        idJLabel = new JLabel(new ImageIcon("src/main/resources/用户.png"));
        idJTextField = new JTextField();
        idJTextField.setCaretColor(Color.orange);
        idJTextField.setBounds(145,65,200,50);
        idJTextField.setOpaque(false);
        idJTextField.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.white));
        idJTextField.setText("账号");
        idJTextField.setFont(new Font("楷体",Font.ITALIC,23));
        idJTextField.setForeground(Color.gray);
        passwordJLabel = new JLabel(new ImageIcon("src/main/resources/密码.png"));
        passwordJPasswordField = new JPasswordField();
        registerJLabel = new JLabel("注册帐号");
        forgetJLabel = new JLabel("忘记密码");
        loginJLabel = new JLabel("登录",JLabel.CENTER);
        //放置组件
        idJLabel.setBounds(90,62,50,65);
        infoJPanel.add(idJLabel);

        idJTextField.addFocusListener(new FocusListener() {
            //获得焦点
            public void focusGained(FocusEvent e) {
                if(idJTextField.getText().equals("账号"))
                    idJTextField.setText("");
                idJTextField.setFont(new Font("黑体",Font.PLAIN,23));
                idJTextField.setForeground(Color.black);
                infoJPanel.remove(idJLabel);
                idJLabel = new JLabel(new ImageIcon("src/main/resources/用户1.png"));
                idJLabel.setBounds(90,62,50,65);
                infoJPanel.add(idJLabel);
                infoJPanel.repaint();
                idJTextField.setBorder(BorderFactory.createMatteBorder(0,0,1,0,new Color(18,183,245)));
            }
            //失去焦点
            public void focusLost(FocusEvent e) {
                if(idJTextField.getText().equals("")){
                    idJTextField.setFont(new Font("楷体",Font.ITALIC,23));
                    idJTextField.setForeground(Color.gray);
                    idJTextField.setText("账号");
                }
                infoJPanel.remove(idJLabel);
                idJLabel = new JLabel(new ImageIcon("src/main/resources/用户.png"));
                idJLabel.setBounds(90,62,50,65);
                infoJPanel.add(idJLabel);
                infoJPanel.repaint();
                idJTextField.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.white));
            }
        });
        infoJPanel.add(idJTextField);

        passwordJLabel.setBounds(90,156,50,65);
        infoJPanel.add(passwordJLabel);
        passwordJPasswordField.setBounds(145,163,200,50);
        passwordJPasswordField.setCaretColor(Color.orange);
        passwordJPasswordField.setOpaque(false);
        passwordJPasswordField.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.white));
        passwordJPasswordField.setFont(new Font("楷体",Font.ITALIC,23));
        passwordJPasswordField.setForeground(Color.gray);
        passwordJPasswordField.setText("密码");
        passwordJPasswordField.setEchoChar((char)0);
        passwordJPasswordField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if(new String(passwordJPasswordField.getPassword()).equals("密码"))
                    passwordJPasswordField.setText("");
                passwordJPasswordField.setEchoChar('*');
                passwordJPasswordField.setFont(new Font("黑体",Font.PLAIN,23));
                passwordJPasswordField.setForeground(Color.black);
                infoJPanel.remove(passwordJLabel);
                passwordJLabel = new JLabel(new ImageIcon("src/main/resources/密码1.png"));
                passwordJLabel.setBounds(90,156,50,65);
                infoJPanel.add(passwordJLabel);
                infoJPanel.repaint();
                passwordJPasswordField.setBorder(BorderFactory.createMatteBorder(0,0,1,0,new Color(18,183,245)));
            }

            public void focusLost(FocusEvent e) {
                if(new String(passwordJPasswordField.getPassword()).equals("")){
                    passwordJPasswordField.setFont(new Font("楷体",Font.ITALIC,23));
                    passwordJPasswordField.setForeground(Color.gray);
                    passwordJPasswordField.setText("密码");
                    passwordJPasswordField.setEchoChar((char)0);
                }
                infoJPanel.remove(passwordJLabel);
                passwordJLabel = new JLabel(new ImageIcon("src/main/resources/密码.png"));
                passwordJLabel.setBounds(90,156,50,65);
                infoJPanel.add(passwordJLabel);
                infoJPanel.repaint();
                passwordJPasswordField.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.white));
            }
        });
        infoJPanel.add(passwordJPasswordField);

        registerJLabel.setBounds(100,250,90,20);
        registerJLabel.setFont(new Font("楷体",Font.PLAIN,20));
        registerJLabel.setForeground(new Color(80,250,252));
        infoJPanel.add(registerJLabel);
        registerJLabel.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
                infoJPanel.removeAll();
                helloJLabel.setBounds(40,25,170,40);
                infoJPanel.add(helloJLabel);
                hadJLabel.setBounds(40,72,125,25);
                infoJPanel.add(hadJLabel);
                goJLabel.setBounds(165,72,50,25);
                infoJPanel.add(goJLabel);
                id1JLabel.setBounds(40,140,50,25);
                infoJPanel.add(id1JLabel);
                id1JTextField.setBounds(110,130,250,50);
                infoJPanel.add(id1JTextField);
                password1JLabel.setBounds(40,230,50,25);
                infoJPanel.add(password1JLabel);
                password3JPassword.setBounds(110,220,250,50);
                infoJPanel.add(password3JPassword);
                password2JLabel.setBounds(40,320,50,25);
                infoJPanel.add(password2JLabel);
                password4JPassword.setBounds(110,310,250,50);
                infoJPanel.add(password4JPassword);
                okJLabel.setBounds(135,380,200,60);
                infoJPanel.add(okJLabel);
                messageJLabel.setBounds(370,130,50,50);
                infoJPanel.add(messageJLabel);
                message1JLabel.setBounds(370,220,50,50);
                infoJPanel.add(message1JLabel);
                infoJPanel.repaint();
            }

            public void mousePressed(MouseEvent e) {
                idJTextField.setFocusable(false);passwordJPasswordField.setFocusable(false);

                registerJLabel.setForeground(new Color(80,180,252));

            }


            public void mouseReleased(MouseEvent e) {
                registerJLabel.setForeground(new Color(80,200,252));
            }


            public void mouseEntered(MouseEvent e) {
                registerJLabel.setForeground(new Color(80,200,252));
                registerJLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }


            public void mouseExited(MouseEvent e) {
                idJTextField.setFocusable(true);
                passwordJPasswordField.setFocusable(true);
                registerJLabel.setForeground(new Color(80,250,252));
            }
        });

        forgetJLabel.setBounds(270,250,90,20);
        forgetJLabel.setFont(new Font("楷体",Font.PLAIN,20));
        forgetJLabel.setForeground(new Color(80,250,252));
        infoJPanel.add(forgetJLabel);
        forgetJLabel.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
                infoJPanel.removeAll();
                findidJLabel.setBounds(60,62,50,65);
                findidJTextField.setBounds(155,65,200,50);
                infoJPanel.add(findidJLabel);
                infoJPanel.add(findidJTextField);
                checkJLabel.setBounds(60,160,50,65);
                checkJTextField.setBounds(155,163,200,50);
                infoJPanel.add(checkJLabel);
                infoJPanel.add(checkJTextField);
                findJLabel.setBounds(240,300,120,50);
                infoJPanel.add(findJLabel);
                returnJLabel.setBounds(60,300,120,50);
                infoJPanel.add(returnJLabel);
                infoJPanel.repaint();
            }

            public void mousePressed(MouseEvent e) {
                forgetJLabel.setForeground(new Color(80,180,252));
                idJTextField.setFocusable(false);
                passwordJPasswordField.setFocusable(false);
            }


            public void mouseReleased(MouseEvent e) {
                forgetJLabel.setForeground(new Color(80,200,252));
            }


            public void mouseEntered(MouseEvent e) {
                forgetJLabel.setForeground(new Color(80,200,252));
                forgetJLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }


            public void mouseExited(MouseEvent e) {
                forgetJLabel.setForeground(new Color(80,250,252));
                idJTextField.setFocusable(true);
                passwordJPasswordField.setFocusable(true);
            }
        });



        loginJLabel.setBounds(95,340,250,60);
        loginJLabel.setOpaque(true);
        loginJLabel.setBackground(new Color(189,206,252));
        loginJLabel.setForeground(Color.white);
        loginJLabel.setFont(new Font("楷体",Font.PLAIN,27));
        loginJLabel.setBorder(grayBorder);
        infoJPanel.add(loginJLabel);
        //注册界面组件初始化
        messageJLabel = new JLabel("？");
        setMessageJLabel(messageJLabel,"账号格式");
        messageJLabel.addMouseListener(d);
        message1JLabel = new JLabel("？");
        setMessageJLabel(message1JLabel,"密码格式");
        message1JLabel.addMouseListener(e);
        helloJLabel = new JLabel("欢迎注册");
        helloJLabel.setFont(new Font("微软雅黑",Font.BOLD,40));
        helloJLabel.setForeground(Color.BLACK);
        hadJLabel = new JLabel("已有帐号？");
        hadJLabel.setFont(new Font("楷体",Font.PLAIN,25));
        hadJLabel.setForeground(new Color(155, 155, 155));
        goJLabel = new JLabel("登录");
        goJLabel.setForeground(new Color(15,60,242));
        goJLabel.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                returnLogin();
            }


            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                goJLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                goJLabel.setForeground(new Color(60,100,240));
            }


            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                goJLabel.setForeground(new Color(15,60,242));
            }


            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                goJLabel.setForeground(new Color(60,60,242));
            }


            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                goJLabel.setForeground(new Color(60,100,240));
            }
        });
        goJLabel.setFont(new Font("楷体",Font.PLAIN,25));
        id1JLabel = new JLabel("账号");
        id1JLabel.setFont(new Font("隶书",Font.PLAIN,25));
        id1JLabel.setForeground(new Color(240,128,128));
        id1JTextField = new JTextField();
        setJTextField(id1JTextField);
        id1JTextField.addFocusListener(new FocusListener() {

            public void focusGained(FocusEvent e) {
                id1JTextField.setBorder(whiteBorder);
            }


            public void focusLost(FocusEvent e) {
                id1JTextField.setBorder(grayBorder);
            }
        });
        password1JLabel = new JLabel("密码");
        password3JPassword = new JPasswordField();
        changePassword1(password1JLabel,password3JPassword);
        password3JPassword.addFocusListener(f);
        password2JLabel = new JLabel("确认");
        password4JPassword = new JPasswordField();
        changePassword1(password2JLabel,password4JPassword);
        password4JPassword.addFocusListener(g);
        okJLabel = new JLabel("注册", JLabel.CENTER);
        okJLabel.setBackground(new Color(189,206,252));
        okJLabel.setOpaque(true);
        okJLabel.setForeground(Color.white);
        okJLabel.setFont(new Font("楷体",Font.PLAIN,27));
        okJLabel.setBorder(grayBorder);
        //找回密码界面初始化
        findidJLabel = new JLabel("账号");
        changeJLabel(findidJLabel);
        findidJTextField = new JTextField();
        setJTextField(findidJTextField);
        findidJTextField.addFocusListener(h);
        checkJLabel = new JLabel("验证");
        changeJLabel(checkJLabel);
        checkJTextField = new JTextField();
        setJTextField(checkJTextField);
        checkJTextField.addFocusListener(i);
        findJLabel = new JLabel("找回",JLabel.CENTER);
        findJLabel.setOpaque(true);
        findJLabel.setBackground(new Color(30,196,252));
        findJLabel.setForeground(Color.white);
        findJLabel.setFont(new Font("楷体",Font.PLAIN,27));
        findJLabel.addMouseListener(c);
        returnJLabel = new JLabel("返回", JLabel.CENTER);
        returnJLabel.setOpaque(true);
        returnJLabel.setBackground(new Color(30,196,252));
        returnJLabel.setForeground(Color.white);
        returnJLabel.setFont(new Font("楷体",Font.PLAIN,27));
        returnJLabel.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
                returnLogin();
            }


            public void mousePressed(MouseEvent e) {
                returnJLabel.setBackground(new Color(30,160,252));
            }


            public void mouseReleased(MouseEvent e) {
                returnJLabel.setBackground(new Color(30,180,252));
            }


            public void mouseEntered(MouseEvent e) {
                returnJLabel.setBackground(new Color(30,180,252));
                returnJLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }


            public void mouseExited(MouseEvent e) {
                returnJLabel.setBackground(new Color(30,196,252));
            }
        });
    }
    public void setMessageJLabel(JLabel messageJLabel,String message){
        messageJLabel.setFont(new Font("黑体",Font.BOLD,30));
        messageJLabel.setForeground(new Color(155,155,155));
        messageJLabel.setToolTipText(message);
    }
    public void setJTextField(JTextField jTextField){
        jTextField.setFont(new Font("幼圆",Font.PLAIN,25));
        jTextField.setCaretColor(Color.orange);
        jTextField.setBorder(BorderFactory.createMatteBorder(0,0,1,0,new Color(30,196,252)));
        jTextField.setBorder(grayBorder);
        jTextField.setOpaque(false);
    }
    public void returnLogin(){
        infoJPanel.removeAll();
        idJLabel.setBounds(90,62,50,65);
        passwordJLabel.setBounds(90,156,50,65);
        registerJLabel.setBounds(100,250,90,20);
        registerJLabel.setForeground(new Color(80,250,252));
        forgetJLabel.setBounds(270,250,90,20);
        idJTextField.setBounds(145,65,200,50);
        idJTextField.setFocusable(true);
        loginJLabel.setBounds(95,340,250,60);
        passwordJPasswordField.setBounds(145,163,200,50);
        passwordJPasswordField.setFocusable(true);
        infoJPanel.add(idJLabel);
        infoJPanel.add(idJTextField);
        infoJPanel.add(passwordJLabel);
        infoJPanel.add(passwordJPasswordField);
        infoJPanel.add(registerJLabel);
        infoJPanel.add(forgetJLabel);
        infoJPanel.add(loginJLabel);
        infoJPanel.repaint();
    }
    public void changePassword1(JLabel password1JLabel,JPasswordField password3JPassword){
        password1JLabel.setFont(new Font("隶书",Font.PLAIN,25));
        password1JLabel.setForeground(new Color(240,128,128));
        password3JPassword.setFont(new Font("宋体",Font.PLAIN,25));
        password3JPassword.setCaretColor(Color.orange);
        password3JPassword.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.white));
        password3JPassword.setOpaque(false);
        password3JPassword.setBorder(grayBorder);
    }
    public void changeJLabel(JLabel findidJLabel){
        findidJLabel.setFont(new Font("楷书",Font.PLAIN,25));
        findidJLabel.setForeground(new Color(240,128,128));
    }


    public void actionPerformed(ActionEvent e) {
        if(!(idJTextField.getText().equals("")||idJTextField.getText().equals("账号")||
                new String(passwordJPasswordField.getPassword()).equals("")||
                new String(passwordJPasswordField.getPassword()).equals("密码"))){
            if(!isChange1){
                loginJLabel.setBackground(new Color(30,196,252));
                loginJLabel.setBorder(null);
                loginJLabel.addMouseListener(a);
                isChange1 = true;
            }
        }
        if(idJTextField.getText().equals("")||idJTextField.getText().equals("账号")||
                new String(passwordJPasswordField.getPassword()).equals("")||
                new String(passwordJPasswordField.getPassword()).equals("密码")){
            if(!isChange1){
                loginJLabel.setBackground(new Color(189,206,252));
                loginJLabel.setBorder(grayBorder);
                loginJLabel.removeMouseListener(a);
                loginJLabel.setCursor(Cursor.getDefaultCursor());
                isChange1 = false;
            }
        }
        if(!(id1JTextField.getText().equals("")||new String(password3JPassword.getPassword()).equals("")||
                new String(password4JPassword.getPassword()).equals(""))){
            if(!isChange2 ){
                okJLabel.setBackground(new Color(30,196,252));
                okJLabel.setBorder(null);
                okJLabel.addMouseListener(b);
                isChange2 = true;
            }
        }
        if(id1JTextField.getText().equals("")||new String(password3JPassword.getPassword()).equals("")||
                new String(password4JPassword.getPassword()).equals("")){
            if(!isChange2){
                okJLabel.setBackground(new Color(189,206,252));
                okJLabel.removeMouseListener(c);
                okJLabel.setBorder(grayBorder);
                okJLabel.setCursor(Cursor.getDefaultCursor());
                isChange2 = false;
            }
        }
    }
}
