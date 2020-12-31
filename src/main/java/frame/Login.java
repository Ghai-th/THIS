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
    public Login(JFrame jFrame) {
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
        NavigationBarPanel navigationBarPanel = new NavigationBarPanel();
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
                if (new String(passwordJPasswordField.getPassword()).equals("密码"))
                    passwordJPasswordField.setText("");
                passwordJPasswordField.setEchoChar('*');
                passwordJPasswordField.setFont(new Font("黑体", Font.PLAIN, 23));
                passwordJPasswordField.setForeground(Color.black);
                infoJPanel.remove(passwordJLabel);
                passwordJLabel = new JLabel(new ImageIcon("src/main/resources/密码1.png"));
                passwordJLabel.setBounds(90, 156, 50, 65);
                infoJPanel.add(passwordJLabel);
                infoJPanel.repaint();
                passwordJPasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(18, 183, 245)));
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
