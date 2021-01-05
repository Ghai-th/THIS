package client.frame.modle.panel;

import client.entity.Article;
import client.entity.User;
import client.util.ClientUtil;
import server.controller.ServerOperate;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyCenterc extends TranslucenceJPanel {
    List<Article> list  = new ArrayList();
    private User myUser,otherUser;
    public MyCenterc(User user){
        this.myUser = myUser;
        init();
    }
    public MyCenterc(User myUser,User otherUser,List<Article>list){
        this.myUser = myUser;
        this.otherUser = otherUser;
        this.list =list;
        init();
    }
    public void init(){
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(GetWH.getWidth()*3/5-100,800));
        for (int i =0;i<list.size();i++){
            MemberMyArticlePanel memberMyArticlePanel = new MemberMyArticlePanel(myUser,otherUser,list.get(i).getTitle()
                    ,list.get(i).getText(),list.get(i).getUid(), String.valueOf(list.get(i).getCreate()),String.valueOf(list.get(i).getRenewal())
                    ,String.valueOf(list.get(i).getVisitorNum()),String.valueOf(list.get(i).getLikeNum()),String.valueOf(list.get(i).getCollectNum()));
            this.add(memberMyArticlePanel);
        }

    }
}
