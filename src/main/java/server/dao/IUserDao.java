package server.dao;

import client.entity.User;

import java.util.Date;
import java.util.List;

public interface IUserDao {
    void addUser(User user);

    void deleteUser(String uid);

    void updateUserName(String name);
    void updateUserPassword(String password);
    void updateUserGender(Integer gender);
    void updateUserImage(Byte[]image);
    void updateUserFansNum(Integer fansNum);
    void updateUserAttentionnum(Integer attentionNum);
    void updateUserVisitorNum(Integer visitorNum);
    void updateUserArticleNum(Integer articleNum);
    void updateUserCreate(Date create);
    void updateUserUpdate(Date update);
    void updateUserSynopsis(String synopsis);
    void updateUserActive(Integer active);

    List<User> selectUsers();
}
