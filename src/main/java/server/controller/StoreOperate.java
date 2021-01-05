package server.controller;

import client.entity.Attention;
import client.entity.Store;
import data.Operate;
import server.service.IStoreService;
import server.service.impl.StoreServiceImpl;
import server.util.ServerUtil;

import java.io.IOException;
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
    public void addStore(){
        boolean success = false;
        success = storeService.addStore(store);
        if (!success) {
            try {
                serverUtil.sendOperate(new Operate(ServerOperate.ERROR));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void deleteStore(){
        boolean success = false;
        success = storeService.deleteStore(store);
        if (!success) {
            try {
                serverUtil.sendOperate(new Operate(ServerOperate.ERROR));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void selectStore(){
        List<Store> attentions = storeService.selectStore(store);
        try {
            serverUtil.sendInfoList(attentions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
