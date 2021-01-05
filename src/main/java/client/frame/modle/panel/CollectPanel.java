package client.frame.modle.panel;

import client.entity.Article;
import client.entity.Store;
import client.entity.User;
import client.util.ClientUtil;
import server.controller.ServerOperate;

import javax.jws.soap.SOAPBinding;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CollectPanel extends JPanel {
    List<MemberCollectPanel> list = new ArrayList<MemberCollectPanel>();
    private User myUser,otherUser;
    List<Store> storeList;
    public CollectPanel(User myUser){
        this.myUser = myUser;
        init();
    }
    public CollectPanel(User myUser,User otherUser,List<Store>storeList){
        this.myUser = myUser;
        this.otherUser = otherUser;
        this.storeList = storeList;
        init();
    }
    public void init(){
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(GetWH.getWidth()*3/5-100,800));
        /**
         * 获取此用户的所有收藏信息
         */
        List<Store> storeList = new ArrayList<>();
        Store store = new Store();
        store.operate = ServerOperate.SELECT_STORE;
        store.setUid(myUser.getUid());
        try {
            ClientUtil.sendInfo(store,Store.class);
            storeList.addAll(ClientUtil.acceptList());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        /**
         * 按文章id查询获取所有收藏的文章信息
         */
        List<Article> articleList = new ArrayList<>();
        Article article = new Article();
        article.operate = ServerOperate.GET_ARTICLE_BY_AID;
        for (int i =0;i<storeList.size();i++){
            article.setAid(storeList.get(i).getAid());
            try {
                ClientUtil.sendInfo(article,Article.class);
                articleList.add(ClientUtil.acceptInfo(Article.class));

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        for (int i=0;i<articleList.size();i++){
            MemberCollectPanel memberCollectPanel = new MemberCollectPanel(myUser,null,articleList.get(i).getTitle(),articleList.get(i).getSynopsis(),String.valueOf(articleList.get(i).getCreate()));
            list.add(memberCollectPanel);
        }
        for (int i = 0;i<list.size();i++){
            this.add(list.get(i));
        }
    }
}
