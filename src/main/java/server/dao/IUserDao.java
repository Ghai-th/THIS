package server.dao;

import client.entity.User;

import java.util.Date;
import java.util.List;

public interface IUserDao {
    void addUser(User user);

    void deleteUser(String uid);

    void updateUserName(String uid,String name);
    void updateUserlevel(String uid);
    void updateUserPassword(String uid,String password);
    void updateUserGender(String uid,Integer gender);
    void updateUserFansNum(String uid,Integer fansNum);
    void updateUserAttentionnum(String uid,Integer attentionNum);
    void updateUserVisitorNum(String uid,Integer visitorNum);
    void updateUserArticleNum(String uid,Integer articleNum);
    void updateUserLastLogin(String uid);
    void updateUserSynopsis(String uid,String synopsis);
    void updateUserActive(String uid,Integer active);
    void updateUserMyKey(String uid,Integer mykey);

    List<User> selectUsers();
}
