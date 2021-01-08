package client.frame.modle.panel;

import client.entity.Message;
import client.entity.User;
import client.util.MessageClientUtil;
import server.controller.ServerOperate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ChatFrame extends JFrame implements Runnable {
    int xOld = 0;
    int yOld = 0;
    public static User sendUser,acceptUser;
    HashMap<String,String> userMap;
    JPanel allJpanel;
    JPanel leftJPanel,upJPanel,downupJPanel;
    JTextPane centerJTextPanel,downJTextPanel;
    JButton sendJButton;

    public ChatFrame(final User sendUser, final User acceptUser, HashMap<String,String> userMap){
        this.userMap = userMap;
        this.sendUser = sendUser;
        this.acceptUser = acceptUser;
        setSize(1920*3/5,864);
        setLocationRelativeTo(null);
        setUndecorated(true);
        //setLayout(null);
        allJpanel = new JPanel();
        allJpanel.setLayout(null);
        sendJButton = new JButton("发送");
        sendJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = downJTextPanel.getText();
                Message message = new Message(sendUser.getUid(),acceptUser.getUid(),text,null,null,null);
                message.setOperate(ServerOperate.SEND_MESSAGE);
                try {
                    MessageClientUtil.sendInfo(message);

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                centerJTextPanel.setText(centerJTextPanel.getText()+"我："+text+"\n");
                downJTextPanel.setText("");
            }
        });
        init1();
        init2();
        init3();
        init4();
        init5();
        sendJButton.setBounds(1050,830,100,30);
        sendJButton.setBackground(Color.white);
        allJpanel.add(sendJButton);
        setResizable(false);
        //处理拖动事件
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xOld = e.getX();
                yOld = e.getY();
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int xOnScreen = e.getXOnScreen();
                int yOnScreen = e.getYOnScreen();
                int xx = xOnScreen - xOld;
                int yy = yOnScreen - yOld;
                setLocation(xx, yy);
            }
        });
        add(allJpanel);
        allJpanel.setBackground(Color.white);
        setBackground(Color.white);
        setVisible(true);
    }
    public void init1(){
        leftJPanel = new JPanel();
        FlowLayout f=new FlowLayout(0);
        f.setHgap(0);//水平间距
        f.setVgap(0);//组件垂直间距
        leftJPanel.setLayout(f);

        ListPanel listPanel = new ListPanel(sendUser.getUid());
        leftJPanel.add(listPanel);
        final ListPanel listPanel1 = new ListPanel(acceptUser.getUid());

        listPanel1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                listPanel1.setBackground(Color.black);
                acceptUser.setUid(listPanel1.nameJLabel.getText());
                centerJTextPanel.setText("");

                try {
                    Message message = new Message();
                    message.setOperate(ServerOperate.ACCEPT_LIST_MESSAGE);
                    message.setSendId(acceptUser.getUid());
                    message.setAcceptId(sendUser.getUid());
                    MessageClientUtil.sendInfo(message);
                    List messageList = MessageClientUtil.acceptList2();
                    if(message!=null){
                        System.out.println(messageList);
                        Iterator<Message> iterator = messageList.iterator();
                        while(iterator.hasNext()){
                            Message message2 = iterator.next();
                            centerJTextPanel.setText(centerJTextPanel.getText()+acceptUser.getName()+":"+message2.getText()+"\n");
                            centerJTextPanel.repaint();
                            centerJTextPanel.updateUI();
                        }
                    }
                } catch (IOException a) {
                    a.printStackTrace();
                } catch (ClassNotFoundException a) {
                    a.printStackTrace();
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

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        leftJPanel.add(listPanel1);

        if(userMap!=null){
            Iterator iterator = userMap.entrySet().iterator();
            while(iterator.hasNext()){
                final Map.Entry<String,String> entry = (Map.Entry<String, String>) iterator.next();
                final ListPanel listPanel2 = new ListPanel(entry.getKey());
                leftJPanel.add(listPanel2);
                listPanel2.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        listPanel2.setBackground(Color.black);
                        acceptUser.setUid(entry.getKey());
                        centerJTextPanel.setText("");

                        try {
                            Message message = new Message();
                            message.setOperate(ServerOperate.ACCEPT_LIST_MESSAGE);
                            message.setSendId(acceptUser.getUid());
                            message.setAcceptId(sendUser.getUid());
                            MessageClientUtil.sendInfo(message);
                            List<Message> messageList = MessageClientUtil.acceptList2();
                            System.out.println("拿到"+messageList);
                            if(message!=null){
                                System.out.println(messageList);
                                Iterator<Message> iterator = messageList.iterator();
                                while(iterator.hasNext()){
                                    Message message2 = iterator.next();
                                    centerJTextPanel.setText(centerJTextPanel.getText()+acceptUser.getName()+":"+message2.getText()+"\n");
                                    centerJTextPanel.repaint();
                                    centerJTextPanel.updateUI();
                                }
                            }
                        } catch (IOException a) {
                            a.printStackTrace();
                        } catch (ClassNotFoundException a) {
                            a.printStackTrace();
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

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
        }
        }
        leftJPanel.setBounds(0,0,1920/6,864);
        leftJPanel.setBackground(new Color(61,61,61));
        allJpanel.add(leftJPanel);
    }
    public void init2(){
        upJPanel = new JPanel();
        ImageIcon Imageone = new ImageIcon("src/main/resources/关闭.png");
        final JLabel imagJLabel = new JLabel(Imageone);
        imagJLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Message message = new Message();
                message.setSendId(sendUser.getUid());
                message.setOperate(ServerOperate.WINDING_MESSAGE);
                try {
                    MessageClientUtil.sendInfo(message);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                imagJLabel.setBackground(Color.lightGray);
                imagJLabel.setBorder(BorderFactory.createLineBorder(Color.black));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                imagJLabel.setBorder(null);
                imagJLabel.setBackground(Color.white);
            }
        });
        upJPanel.setLayout(null);
        upJPanel.setBounds(320,0,1920*3/5-1920/6,1080/12);
        imagJLabel.setBounds(780,15,30,21);
        upJPanel.setBackground(Color.white);
        upJPanel.add(imagJLabel);
        upJPanel.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.red));
        add(upJPanel);
    }
    public void init3(){
        centerJTextPanel = new JTextPane();
        centerJTextPanel.setEditable(false);
        centerJTextPanel.setBounds(320,72,832,534);
        centerJTextPanel.setBackground(Color.white);
        centerJTextPanel.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.LIGHT_GRAY));
        allJpanel.add(centerJTextPanel);
    }
    public void init4(){
        downJTextPanel = new JTextPane();
        downJTextPanel.setBackground(Color.white);
        downJTextPanel.setBounds(320,636,832,180);
        allJpanel.add(downJTextPanel);
    }
    public void init5(){
        downupJPanel = new JPanel();
        JLabel jLabel = new JLabel("表情");
        downupJPanel.setBounds(320,606,832,30);
        downupJPanel.setBackground(Color.white);
        downupJPanel.add(jLabel);
        allJpanel.add(downupJPanel);

    }
    public static void main(String[] args) {
        //User user = new User()
        new ChatFrame(null,null,null);
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message message = null;
            try {
                message = MessageClientUtil.acceptInfo();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if(message!=null){
                centerJTextPanel.setText(centerJTextPanel.getText()+message.getSendId()+message.getText());
            }
        }
    }
}
