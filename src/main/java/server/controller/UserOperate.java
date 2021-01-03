package server.controller;

import client.entity.Comment;
import client.entity.User;
import data.Operate;
import server.service.IUserService;
import server.service.impl.CommentServiceImpl;
import server.service.impl.UserServiceImpl;

public class UserOperate {
    private User user;
    public IUserService userServiceImpl = new UserServiceImpl();

    public UserOperate(User user) {
        this.user = user;
    }

    public UserOperate(){

    }


}
