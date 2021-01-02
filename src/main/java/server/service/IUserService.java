package server.service;

import client.entity.User;

import java.util.Date;
import java.util.List;

public interface IUserService {
    boolean register(User user);
    boolean isValidUser(User user);
    boolean isFind(User user);

    void addUser(User user);

    void deleteUser(String uid);

    void updateUserName(String name);
    void updateUserPassword(String password);
    void updateUserGender(Integer gender);
    void updateUserFansNum(Integer fansNum);
    void updateUserAttentionnum(Integer attentionNum);
    void updateUserVisitorNum(Integer visitorNum);
    void updateUserArticleNum(Integer articleNum);
    void updateUserCreate(Date create);
    void updateUserUpdate(Date update);
    void updateUserSynopsis(String synopsis);
    void updateUserActive(Integer active);
    void updateUserKey(Integer key);

    List<User> selectUsers();
}
