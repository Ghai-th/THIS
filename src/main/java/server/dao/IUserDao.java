package server.dao;

import client.entity.User;

import java.util.Date;
import java.util.List;

public interface IUserDao {
    /**
     * 注册成功增加User用户
     * @param user 用户
     */
    void addUser(User user);
    /**
     * 通过uid删除用户
     * @param uid 用户id
     */
    void deleteUser(String uid);
    /**
     * 通过uid更新用户姓名
     * @param uid 用户id
     * @param name 更新的姓名
     */
    void updateUserName(String uid,String name);

    /**
     * 通过uid更新用户等级
     * @param uid 用户id
     */
    void updateUserlevel(String uid);
    /**
     * 通过uid修改用户密码
     * @param uid 用户id
     * @param password 更新的密码
     */
    void updateUserPassword(String uid,String password);
    /**
     * 通过uid更新性别
     * @param uid 用户id
     * @param gender 更新的性别
     */
    void updateUserGender(String uid,Integer gender);
    /**
     * 通过uid更新粉丝数
     * @param uid 用户id
     */
    void updateUserFansNum(String uid);
    /**
     * 通过uid更新关注数量
     * @param uid 用户id
     */
    void updateUserAttentionnum(String uid);
    /**
     * 通过uid更新访客数量
     * @param uid
     */
    void updateUserVisitorNum(String uid);
    /**
     * 通过uid更新发表文章的数量
     * @param uid 用户id
     */
    void updateUserArticleNum(String uid);
    /**
     * 通过uid更新用户最后登录的时间
     * @param uid 用户id
     */
    void updateUserLastLogin(String uid);
    /**
     * 通过uid更新用户简介
     * @param uid 用户id
     * @param synopsis 更新的简介
     */
    void updateUserSynopsis(String uid,String synopsis);
    /**
     * 通过uid更新用户活跃度
     * @param uid 用户id
     */
    void updateUserActive(String uid);
    /**
     * 通过uid更新用户的密钥
     * @param uid 用户id
     * @param mykey 更新的密钥
     */
    void updateUserMyKey(String uid,Integer mykey);
    /**
     * 返回所有用户user的集合
     * @return 用户user的集合
     */
    List<User> selectUsers();
}
