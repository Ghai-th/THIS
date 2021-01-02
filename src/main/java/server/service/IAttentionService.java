package server.service;

import client.entity.User;

public interface IAttentionService {
    //点击关注按钮后，输入该用户的类对象以及所要关注的人的id
    boolean addAttention(User user,String id);
    //输入该用户的类对象以及所要取消关注的用户id
    boolean deleteAttention(User user,String id);
    boolean searchAttention(User user);

}
