package server.dao;

import client.entity.User;

import java.util.List;

public interface IUserDao {
    /**
     * 注册成功增加User用户
     * @param user 用户
     * @return 返回增加结果
     */
    boolean addUser(User user);

    /**
     * 删除用户
     * @param user 被删除的用户
     * @return 返回删除结果
     */
    boolean deleteUser(User user);

    /**
     * 更新用户等级
     * @param user 更新的用户
     * @return 返回更新结果
     */
    boolean updateUserlevel(User user);

    /**
     * 更新用户粉丝数量
     * @param user 更新的用户
     * @return 返回更新结果
     */
    boolean updateUserFansNum(User user);

    /**
     * 更新用户关注数量
     * @param user 更新的用户
     * @return 返回更新结果
     */
    boolean updateUserAttentionnum(User user);

    /**
     * 更新用户访客数量
     * @param user 更新的用户
     * @return 返回更新结果
     */
    boolean updateUserVisitorNum(User user);

    /**
     * 更新用户发表文章的数量
     * @param user 更新的用户
     * @return 返回更新结果
     */
    boolean updateUserArticleNum(User user);

    /**
     * 更新用户最后登录的时间
     * @param user 更新的用户
     * @return 返回更新结果
     */
    boolean updateUserLastLogin(User user);

    /**
     * 更新用户活跃度
     * @param user 更新的用户
     * @return 返回更新结果
     */
    boolean updateUserActive(User user);

    /**
     * 更新用户基本信息
     * @param user
     * @return 返回更新结果
     */
    boolean updateUser(User user);

    /**
     * 返回所有用户user的集合
     * @return 用户user的集合
     */
    List<User> selectUsers();
}
