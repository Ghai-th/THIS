package client.frame.modle.panel;

import client.entity.Article;
import client.entity.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MyCenterc extends TranslucenceJPanel {
    List<Article> list  = new ArrayList();
    private User myUser,otherUser;
    public MyCenterc(User user){
        this.myUser = myUser;
        init();
    }
    public MyCenterc(User myUser,User otherUser){
        this.myUser = myUser;
        this.otherUser = otherUser;
        init();
    }
    public void init(){
        this.setLayout(new FlowLayout());

    }
}
