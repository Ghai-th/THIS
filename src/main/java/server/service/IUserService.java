package server.service;

import client.entity.Article;
import client.entity.User;

import java.util.List;

public interface IUserService {
    /**
     * 判断注册是否合法
     * @param user 用户注册信息
     * @return true为合法，false为不合法
     */
    boolean register(User user);

    /**
     * 判断登录是否合法
     * @param user 用户登录信息
     * @return true为合法，false为不合法
     */
    boolean isValidUser(User user);

    /**
     * 判断找回密码是否合法
     * @param user 找回密码信息
     * @return true为合法，false为不合法
     */
    boolean isFind(User user);

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
     * 更新用户粉丝数量,使粉丝数量加一
     * @param user 更新的用户
     * @return 返回更新结果
     */
    boolean updateUserFansNum(User user);

    /**
     * 更新用户的粉丝数量，使粉丝数量减一
     * @param user 更新的用户
     * @return 返回更新的结果
     */
    boolean updateUserFanNum(User user);

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
     *
     * @param user 更新的用户
     * @return 返回更新结果
     */
    boolean updateUser(User user);

    /**
     * 返回该用户
     */
    User selectUser(User user);

    /**
     * 查询全部用户中活跃度排名前十的用户
     * @param limit 查询条数
     * @return 用户列表
     */
    List<User> selectTopLimitUsers(int limit);

    /**
     * 返回所有用户user的集合
     * @return 用户user的集合
     */

    List<User> selectUsers();


    /**
     * 返回用户的部分数据
     * @return user的部分数据集合
     */
    List<User> selectUsersInfo();
}
