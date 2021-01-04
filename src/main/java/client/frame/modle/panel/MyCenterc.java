package client.frame.modle.panel;

import client.entity.Article;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MyCenterc extends TranslucenceJPanel {
    List<Article> list  = new ArrayList();
    public MyCenterc(){
        init();
    }
    public void init(){
        this.setLayout(new FlowLayout());

    }
}
