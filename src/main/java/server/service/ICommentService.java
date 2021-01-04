package server.service;

import client.entity.Comment;

import java.util.List;

public interface ICommentService {

    /**
     * 添加评论
     * @param comment 评论对象
     * @return true代表添加成功 false代表用户已评论该文章
     */
    boolean addComment(Comment comment);

    /**
     * 删除评论
     * @param comment 评论对象
     * @return true代表删除成功 false代表用户对该该文章未进行评论
     */
    boolean deleteComment(Comment comment);

    /**
     * 管理员根据用户id删除评论
     * @param uid 用户id
     */
    void deleteCommentByUid(String uid);

    /**
     * 管理员根据文章id删除评论
     * @param aid 文章id
     */
    void deleteCommentByAid(String aid);

    /**
     * 更新评论
     * @param comment 评论对象
     */
    void updateComment(Comment comment);

    /**
     * 根据用户id返回全部该用户的评论
     * @param uid 用户id
     * @return
     */
    List<Comment> queryAllCommentByUid(String uid);

    /**
     * 根据文章id返回全部该文章的评论
     * @param aid 文章id
     * @return
     */
    List<Comment> queryAllCommentByAid(String aid);

    /**
     * 查询所有评论数量
     * @return
     */
    int selectAllCommentNum();

}
