package server.dao;

import client.entity.Comment;

import java.util.List;

public interface ICommentDao {
    /**
     *评论加入数据库
     * @param comment 评论
     */
    void addComment(Comment comment);

    /**
     * 删除评论
     * @param comment 评论
     */
    boolean deleteComment(Comment comment);

    /**
     * 根据用户id删除评论
     * @param uid 用户id
     */
    void deleteCommentByUid(String uid);

    /**
     * 根据文章id删除评论
     * @param aid 文章id
     */
    void deleteCommentByAid(String aid);

    /**
     * 更新评论
     * @param comment 评论
     */
    void updateComment(Comment comment);

    /**
     *根据用户id  返回该用户全部评论
     * @param  uid 的用户id
     */
    List<Comment> queryAllCommentByUid(String uid);

    /**
     *根据文章id  返回该文章全部评论
     * @param aid 文章id
     */
    List<Comment> queryAllCommentByAid(String aid);

    /**
     * 查询全部评论数量 返回数量
     * @return 评论总数
     */
    int selectAllCommentNum();

    /**
     * 查询全部评论列表 字段有顺序的查询
     * @return 评论列表
     */
    List<Comment> selectCommentInfo();
}
