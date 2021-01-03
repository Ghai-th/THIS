package server.controller;

import client.entity.Comment;
import client.entity.User;
import data.Operate;
import server.service.impl.CommentServiceImpl;
import server.service.impl.UserServiceImpl;

public class UserOperate {
    private Operate userOperate;
    private User user;
    public UserServiceImpl userServiceImpl;
    public UserOperate(Operate userOperate) {
        this.userOperate = userOperate;
    }

    public Operate getUserOperate() {
        return userOperate;
    }

    public void setUserOperate(Operate userOperate) {
        this.userOperate = userOperate;
    }

    public void executeUserOperate() {
        switch(userOperate.operate) {
            case ServerOperate.REGISTER_USER :
                //userServiceImpl.register();
                break;

        }
    }

}
