package server.dao;

import client.entity.Comment;

import java.util.List;

public interface ICommentDao {
    /**
     *
     * @param comment
     */
    void addComment(Comment comment);

    void deleteComment(Comment comment);

    void deleteCommentByUid(String uid);

    void deleteCommentByAid(String aid);

    void updateComment(Comment comment);

    List<Comment> queryAllCommentByUid(String uid);

    List<Comment> queryAllCommentByAid(String aid);

}
