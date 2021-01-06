package server.controller;

import client.entity.User;
import server.service.IUserService;
import server.service.impl.UserServiceImpl;
import server.util.ServerUtil;

import java.io.IOException;
import java.util.List;

public class UserOperate {
    private User user;
    public ServerUtil serverUtil;
    public IUserService userServiceImpl = new UserServiceImpl();

    public UserOperate(User user, ServerUtil serverUtil) {
        this.user = user;
        this.serverUtil = serverUtil;
        selectOperate();
    }

    public UserOperate() {

    }

    /**
     * 执行操作
     */
    public void selectOperate() {
        switch (user.operate) {
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
                selectLimitUsers();
                break;
            case ServerOperate.SELECT_USERS_INFO:
                selectUserInfo();
                break;
        }
    }

    /**
     * 判断注册是否合法，向客户端返回用户对象
     */
    public void register() {
        isSuccess(userServiceImpl.register(user));
    }

    /**
     * 判断登录是否合法，向客户端返回对象
     */
    public void isValidUser() {
        isSuccess(userServiceImpl.isValidUser(user));
    }

    /**
     * 判断找回密码是否合法，向客户端返回对象
     */
    public void isFind() {
        isSuccess(userServiceImpl.isFind(user));
    }


    /**
     * 增加用户信息，向客户端返回对象
     */
    public void addUser() {
        isSuccess(userServiceImpl.addUser(user));
    }

    /**
     * 删除用户信息，向客户端返回对象
     */
    public void deleteUser() {
        isSuccess(userServiceImpl.deleteUser(user));
    }

    /**
     * 更新用户等级，向客户端返回对象
     */
    public void updateUserlevel() {
        isSuccess(userServiceImpl.updateUserlevel(user));
    }

    /**
     * 更新用户粉丝数，向客户端返回对象
     */
    public void updateUserFansNum() {
        isSuccess(userServiceImpl.updateUserFansNum(user));
    }

    /**
     * 更新用户关注数量，向客户端返回对象
     */
    public void updateUserAttentionnum() {
        isSuccess(userServiceImpl.updateUserAttentionnum(user));
    }

    /**
     * 更新用户访问量，向客户端返回对象
     */
    public void updateUserVisitorNum() {
        isSuccess(userServiceImpl.updateUserVisitorNum(user));
    }

    /**
     * 更新用户文章数量，向客户端返回对象
     */
    public void updateUserArticleNum() {
        isSuccess(userServiceImpl.updateUserArticleNum(user));
    }

    /**
     * 更新用户最后登录时间，向客户端返回对象
     */
    public void updateUserLastLogin() {
        isSuccess(userServiceImpl.updateUserLastLogin(user));
    }

    /**
     * 更新用户活跃度，向客户端返回对象
     */
    public void updateUserActive() {
        isSuccess(userServiceImpl.updateUserActive(user));
    }

    /**
     * 更新用户基本信息，向客户端返回对象
     */
    public void updateUser() {
        isSuccess(userServiceImpl.updateUser(user));
    }

    /**
     * 向客户端发送单个用户
     */
    public void selectUser() {
        user = userServiceImpl.selectUser(user);
        try {
            serverUtil.sendInfo(user, User.class);
        } catch (IOException e) {
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
    public void selectUsers() {
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
    public void selectLimitUsers() {
        List users = userServiceImpl.selectTopLimitUsers(10);
        try {
            serverUtil.sendInfoList(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void isSuccess(boolean success) {
        if (success) {
            System.out.println("success");
            try {
                serverUtil.sendInfo(user, User.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("error");
            user.setOperate(ServerOperate.ERROR);
            try {
                serverUtil.sendInfo(user, User.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
