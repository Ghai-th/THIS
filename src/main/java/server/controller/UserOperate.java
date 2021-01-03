package server.controller;

import client.entity.Comment;
import client.entity.User;
import data.Operate;
import server.service.IUserService;
import server.service.impl.CommentServiceImpl;
import server.service.impl.UserServiceImpl;
import server.util.ServerUtil;

public class UserOperate {
    private User user;
    public ServerUtil serverUtil;
    public IUserService userServiceImpl = new UserServiceImpl();

    public UserOperate(User user,ServerUtil serverUtil) {
        this.user = user;
        this.serverUtil = serverUtil;
    }

    public UserOperate(){

    }

    public void selectOperate(){
        switch (user.operate){
            case ServerOperate.REGISTER_USER:
                register();
                break;

        }
    }

    public void register(){
        userServiceImpl.register(user);
    }
    public void isValidUser(){
        userServiceImpl.isValidUser(user);
    }
    public void isFind(){
        userServiceImpl.isFind(user);
    }

    /**
     * 增加用户信息，不成功向客户端返回数据
     */
    public void addUser(){
        userServiceImpl.addUser(user);
    }
    public void deleteUser(){
        userServiceImpl.deleteUser(user);
    }
    public void updateUserlevel(){
        userServiceImpl.updateUserlevel(user);
    }
    public void updateUserFansNum(){
        userServiceImpl.updateUserFansNum(user);
    }
    public void updateUserAttentionnum(){
        userServiceImpl.updateUserAttentionnum(user);
    }
    public void updateUserVisitorNum(){
        userServiceImpl.updateUserVisitorNum(user);
    }
    public void updateUserArticleNum(){
        userServiceImpl.updateUserArticleNum(user);
    }
    public void updateUserLastLogin(){
        userServiceImpl.updateUserLastLogin(user);
    }
    public void updateUserActive(){
        userServiceImpl.updateUserActive(user);
    }
    public void updateUser(){
        userServiceImpl.updateUser(user);
    }
    public void selectUsers(){

    }


}
