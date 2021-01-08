package server.controller;

import client.entity.Attention;
import client.entity.Store;
import data.Operate;
import server.service.IStoreService;
import server.service.impl.StoreServiceImpl;
import server.util.ServerUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StoreOperate {
    public Store store;
    public ServerUtil serverUtil;
    public IStoreService storeService =  new StoreServiceImpl();
    public StoreOperate(Store store,ServerUtil serverUtil){
        this.store = store;
        this.serverUtil = serverUtil;
        selectOperate();
    }

    /**
     * 执行操作
     */
    public void selectOperate(){
        switch (store.operate){
            case ServerOperate.ADD_STORE:
                addStore();
                break;
            case ServerOperate.DELETE_STORE:
                deleteStore();
                break;
            case ServerOperate.SELECT_STORE:
                selectStore();
                break;

        }
    }

    /**
     * 增加收藏
     */
    public void addStore(){
        boolean success = false;
        success = storeService.addStore(store);
    }

    /**
     * 删除收藏
     */
    public void deleteStore(){
        storeService.deleteStore(store);
    }

    /**
     * 查询收藏
     */
    public void selectStore(){
        List<Store> attentions = storeService.selectStore(store);
        if (attentions == null) {
            attentions = new ArrayList<>();
        }
        try {
            serverUtil.sendInfoList(attentions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
