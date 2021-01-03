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

    void updateUserName(String uid,String name);
    void updateUserlevel(String uid);
    void updateUserPassword(String uid,String password);
    void updateUserGender(String uid,Integer gender);
    void updateUserFansNum(String uid);
    void updateUserAttentionnum(String uid);
    void updateUserVisitorNum(String uid);
    void updateUserArticleNum(String uid);
    void updateUserLastLogin(String uid);
    void updateUserSynopsis(String uid,String synopsis);
    void updateUserActive(String uid);
    void updateUserMyKey(String uid,Integer mykey);

    List<User> selectUsers();
}
