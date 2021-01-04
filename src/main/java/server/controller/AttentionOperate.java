package server.controller;


import client.entity.Attention;
import data.Operate;
import server.service.IAttentionService;
import server.service.impl.AttentionServiceImpl;
import server.util.ServerUtil;

import java.io.IOException;
import java.util.List;

public class AttentionOperate {
    public Attention attention;
    public ServerUtil serverUtil;
    public IAttentionService attentionService = new AttentionServiceImpl();
    public AttentionOperate(){

    }
    public AttentionOperate(Attention attention,ServerUtil serverUtil){
        this.attention = attention;
        this.serverUtil = serverUtil;
        selectOperate();
    }
    public void selectOperate(){
        switch (attention.operate){
            case ServerOperate.ADD_ATTENTION :
                addAttention();
                break;
            case ServerOperate.DELETE_ATTENTION :
                deleteAttention();
                break;
            case ServerOperate.SEARCH_ATTENTION_FANS:
                searchAttention();
                break;
            case ServerOperate.SELECT_ATTENTION_IDOL:
                selectAttention();
                break;

        }
    }
    public void addAttention(){
        boolean success = false;
        success = attentionService.addAttention(attention);
        if (!success) {
            try {
                serverUtil.sendOperate(new Operate(ServerOperate.ERROR));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void deleteAttention(){
        boolean success = false;
        success = attentionService.deleteAttention(attention);
        if (!success) {
            try {
                serverUtil.sendOperate(new Operate(ServerOperate.ERROR));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 查询我的粉丝
     */
    public void searchAttention(){
        List <Attention>attentions = attentionService.searchAttention(attention);
        try {
            serverUtil.sendInfoList(attentions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询我的关注
     */
    public void selectAttention(){
        List <Attention>attentions = attentionService.selectAttention(attention);
        try {
            serverUtil.sendInfoList(attentions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
