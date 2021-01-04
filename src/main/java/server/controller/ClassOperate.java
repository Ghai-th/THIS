package server.controller;

import client.entity.Article;
import client.entity.Class;
import server.service.IClassService;
import server.util.ServerUtil;
import server.service.impl.ClassServiceImpl;

import java.io.IOException;

public class ClassOperate {
    public Class clazz;
    public ServerUtil serverUtil;
    public IClassService classService= new ClassServiceImpl();

    public ClassOperate(Class clazz,ServerUtil serverUtil){
        this.clazz = clazz;
        this.serverUtil = serverUtil;
        selectOperate();
    }
    public ClassOperate(){

    }
    /**
     * 执行对应操作
     */
    public void selectOperate() {
        System.out.println(clazz.operate);
        switch (clazz.operate) {
            case ServerOperate.SELECT_CLASS_BY_ID:
                selectClassByCid();
                break;
        }
    }
        /**
         * 根据类id查找
         */
        public void selectClassByCid (){
            clazz = classService.selectClassById(clazz.getCid());
            clazz.operate = ServerOperate.SELECT_CLASS_BY_ID;
            try {
                serverUtil.sendInfo(clazz, Class.class);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }