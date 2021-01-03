package server.controller;

import client.entity.Comment;
import client.entity.User;
import data.Operate;
import server.service.IUserService;
import server.service.impl.CommentServiceImpl;
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
                selectUsers();
                break;


        }
    }
    /**
     * 判断注册是否合法，成功向客户端返回对象
     */
    public void register(){
        boolean success = userServiceImpl.register(user);
        if(success){
            try {
                serverUtil.sendInfo(user,User.class);
            } catch (IOException e) {
                e.printStackTrace();
                try {
                    serverUtil.sendOperate(new Operate(ServerOperate.ERROR));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    /**
     * 判断登录是否合法，成功向客户端返回对象
     */
    public void isValidUser(){
        boolean success = userServiceImpl.isValidUser(user);
        if(success){
            try {
                serverUtil.sendInfo(user,User.class);
            } catch (IOException e) {
                e.printStackTrace();
                try {
                    serverUtil.sendOperate(new Operate(ServerOperate.ERROR));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }
    /**
     * 判断找回密码是否合法，成功向客户端返回对象
     */
    public void isFind(){
        boolean success = userServiceImpl.isFind(user);
        if(success){
            try {
                serverUtil.sendInfo(user,User.class);
            } catch (IOException e) {
                e.printStackTrace();
                try {
                    serverUtil.sendOperate(new Operate(ServerOperate.ERROR));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * 增加用户信息，不成功向客户端返回数据
     */
    public void addUser(){
        boolean success = false;
        success = userServiceImpl.addUser(user);
        if (!success) {
            try {
                serverUtil.sendOperate(new Operate(ServerOperate.ERROR));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 删除用户信息，不成功向客户端返回数据
     */
    public void deleteUser(){
        boolean success = false;
        success = userServiceImpl.deleteUser(user);
        if (!success) {
            try {
                serverUtil.sendOperate(new Operate(ServerOperate.ERROR));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 更新用户等级，不成功向客户端返回数据
     */
    public void updateUserlevel(){
        boolean success = false;
        success = userServiceImpl.updateUserlevel(user);
        if (!success) {
            try {
                serverUtil.sendOperate(new Operate(ServerOperate.ERROR));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 更新用户粉丝数，不成功向客户端返回数据
     */
    public void updateUserFansNum(){
        boolean success = false;
        success = userServiceImpl.updateUserFansNum(user);
        if (!success) {
            try {
                serverUtil.sendOperate(new Operate(ServerOperate.ERROR));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 更新用户关注数量，不成功向客户端返回数据
     */
    public void updateUserAttentionnum(){
        boolean success = false;
        success = userServiceImpl.updateUserAttentionnum(user);
        if (!success) {
            try {
                serverUtil.sendOperate(new Operate(ServerOperate.ERROR));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 更新用户访问量，不成功向客户端返回数据
     */
    public void updateUserVisitorNum(){
        boolean success = false;
        success = userServiceImpl.updateUserVisitorNum(user);
        if (!success) {
            try {
                serverUtil.sendOperate(new Operate(ServerOperate.ERROR));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 更新用户文章数量，不成功向客户端返回数据
     */
    public void updateUserArticleNum(){
        boolean success = false;
        success = userServiceImpl.updateUserArticleNum(user);
        if (!success) {
            try {
                serverUtil.sendOperate(new Operate(ServerOperate.ERROR));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 更新用户最后登录时间，不成功向客户端返回数据
     */
    public void updateUserLastLogin(){
        boolean success = false;
        success = userServiceImpl.updateUserLastLogin(user);
        if (!success) {
            try {
                serverUtil.sendOperate(new Operate(ServerOperate.ERROR));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 更新用户活跃度，不成功向客户端返回数据
     */
    public void updateUserActive(){
        boolean success = false;
        success = userServiceImpl.updateUserActive(user);
        if (!success) {
            try {
                serverUtil.sendOperate(new Operate(ServerOperate.ERROR));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 更新用户基本信息，不成功向客户端返回数据
     */
    public void updateUser(){
        boolean success = false;
        success = userServiceImpl.updateUser(user);
        if (!success) {
            try {
                serverUtil.sendOperate(new Operate(ServerOperate.ERROR));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 向客户端发送所有用户信息列表，不成功向客户端返回数据
     */
    public void selectUsers(){
        List users = userServiceImpl.selectUsers();
        try {
            serverUtil.sendInfoList(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
