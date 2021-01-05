package server.controller;

import client.entity.User;
import data.Operate;
import server.Thread.UserSocketGather;
import server.service.IUserService;
import server.service.impl.UserServiceImpl;
import server.util.ServerUtil;

import java.io.IOException;
import java.util.List;

public class UserOperate {
    private User user;
    public ServerUtil serverUtil;
    public IUserService userServiceImpl = new UserServiceImpl();

    public UserOperate(User user,ServerUtil serverUtil) {
        this.user = user;
        this.serverUtil = serverUtil;
        selectOperate();
    }

    public UserOperate(){

    }

    public void selectOperate(){
        switch (user.operate){
            case ServerOperate.REGISTER_USER:
                register();
                break;
            case ServerOperate.IS_VALID_USER:
                isValidUser();
                break;
            case ServerOperate.IS_FIND_USER:
                isFind();
                break;
            case ServerOperate.ADD_USER:
                addUser();
                break;
            case ServerOperate.DELETE_USER:
                deleteUser();
                break;
            case ServerOperate.UPDATE_USER_LEVEL:
                updateUserlevel();
                break;
            case ServerOperate.UPDATE_FANS_NUM:
                updateUserFansNum();
                break;
            case ServerOperate.UPDATE_ATTENTION_NUM:
                updateUserAttentionnum();
                break;
            case ServerOperate.UPDATE_VISITOR_NUM:
                updateUserVisitorNum();
                break;
            case ServerOperate.UPDATE_ARTICLE_NUM:
                updateUserArticleNum();
                break;
            case ServerOperate.UPDATE_LAST_LOGIN:
                updateUserLastLogin();
                break;
            case ServerOperate.UPDATE_ACTIVE:
                updateUserActive();
                break;
            case ServerOperate.UPDATE_USER:
                updateUser();
                break;
            case ServerOperate.SELECT_USER:
                selectUser();
                break;
            case ServerOperate.SELECT_USERS:
                selectUsers();
                break;
            case ServerOperate.SELECT_LIMIT_USERS:
                seleceLimitUsers();
                break;
            case ServerOperate.SELECT_USERS_INFO:
                selectUserInfo();
                break;
        }
    }
    /**
     * 判断注册是否合法，向客户端返回用户对象
     */
    public void register(){
       all(1);
    }

    /**
     * 判断登录是否合法，向客户端返回对象
     */
    public void isValidUser(){
      all(2);
    }

    /**
     * 判断找回密码是否合法，向客户端返回对象
     */
    public void isFind(){
       all(3);
    }


    /**
     * 增加用户信息，向客户端返回对象
     */
    public void addUser(){
      all(4);
    }

    /**
     * 删除用户信息，向客户端返回对象
     */
    public void deleteUser(){
       all(5);
    }

    /**
     * 更新用户等级，向客户端返回对象
     */
    public void updateUserlevel(){
       all(6);
    }

    /**
     * 更新用户粉丝数，向客户端返回对象
     */
    public void updateUserFansNum(){
      all(7);
    }

    /**
     * 更新用户关注数量，向客户端返回对象
     */
    public void updateUserAttentionnum(){
       all(8);
    }

    /**
     * 更新用户访问量，向客户端返回对象
     */
    public void updateUserVisitorNum(){
      all(9);
    }

    /**
     * 更新用户文章数量，向客户端返回对象
     */
    public void updateUserArticleNum(){
       all(10);
    }

    /**
     * 更新用户最后登录时间，向客户端返回对象
     */
    public void updateUserLastLogin(){
       all(11);
    }

    /**
     * 更新用户活跃度，向客户端返回对象
     */
    public void updateUserActive(){
        all(12);
    }

    /**
     * 更新用户基本信息，向客户端返回对象
     */
    public void updateUser(){
       all(13);
    }

    /**
     * 向客户端发送单个用户
     */
    public void selectUser(){
        user = userServiceImpl.selectUser(user);
        try{
            serverUtil.sendInfo(user,User.class);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void selectUserInfo() {
        List users = userServiceImpl.selectUsersInfo();
        try {
            serverUtil.sendInfoList(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向客户端发送所有用户信息列表
     */
    public void selectUsers(){
        List users = userServiceImpl.selectUsers();
        try {
            serverUtil.sendInfoList(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向客户端发送热度前十的用户
     */
    public void seleceLimitUsers(){
        List users = userServiceImpl.selectTopLimitUsers(10);
        try {
            serverUtil.sendInfoList(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //传x的值，操作对应函数
    public void all(int x){
        boolean success = false;
        switch(x){
            case 1:
                success = userServiceImpl.register(user);
                break;
            case 2:
                success = userServiceImpl.isValidUser(user);
                break;
            case 3:
                success = userServiceImpl.isFind(user);
                break;
            case 4:
                success = userServiceImpl.addUser(user);
                break;
            case 5:
                success = userServiceImpl.deleteUser(user);
                break;
            case 6:
                success = userServiceImpl.updateUserlevel(user);
                break;
            case 7:
                success = userServiceImpl.updateUserFansNum(user);
                break;
            case 8:
                success = userServiceImpl.updateUserAttentionnum(user);
                break;
            case 9:
                success = userServiceImpl.updateUserVisitorNum(user);
                break;
            case 10:
                success = userServiceImpl.updateUserArticleNum(user);
                break;
            case 11:
                success = userServiceImpl.updateUserLastLogin(user);
                break;
            case 12:
                success = userServiceImpl.updateUserActive(user);
                break;
            case 13:
                success = userServiceImpl.updateUser(user);
                break;
        }
        if(success){
            try {
                user.setOperate(ServerOperate.SUCCESS);
                serverUtil.sendInfo(user,User.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            user.setOperate(ServerOperate.ERROR);
            try {
                serverUtil.sendInfo(user,User.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
