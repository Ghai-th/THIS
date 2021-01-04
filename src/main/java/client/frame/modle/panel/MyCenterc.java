package client.frame.modle.panel;

import client.entity.Article;
import client.entity.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MyCenterc extends TranslucenceJPanel {
    List<Article> list  = new ArrayList();
    public MyCenterc(User user){
        init();
    }
    public MyCenterc(User myUser,User otherUser){
        init();
    }
    public void init(){
        this.setLayout(new FlowLayout());

    }
}
