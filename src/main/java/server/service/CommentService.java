package server.service;

import client.entity.Comment;

import java.util.List;

public interface CommentService {

    boolean addComment(Comment comment);

    boolean deleteComment(Comment comment);

    void deleteCommentByUid(String uid);

    void deleteCommentByAid(String aid);

    void updateComment(Comment comment);

    List<Comment> queryAllCommentByUid(String uid);

    List<Comment> queryAllCommentByAid(String aid);

}
