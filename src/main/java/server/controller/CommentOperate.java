package server.controller;

import client.entity.Comment;
import data.Operate;
import server.service.impl.CommentServiceImpl;

import java.io.IOException;
import java.util.List;

import static server.util.ServerUtil.sendInfoList;

public class CommentOperate {

    private Operate commentOperate;
    public CommentServiceImpl commentServiceImpl;
    public Comment comment;

    public CommentOperate(Operate commentOperate, Comment comment) {
        this.commentOperate = commentOperate;
        this.comment = comment;
    }

    public Operate getCommentOperate() {
        return commentOperate;
    }

    public void setCommentOperate(Operate commentOperate) {
        this.commentOperate = commentOperate;
    }

    public void executeCommentOperate() throws IOException {
        switch(commentOperate.operate) {
            case ServerOperate.ADD_COMMENT :
                clientAddComment(comment);
                break;
            case ServerOperate.DELETE_COMMENT:
                clientDeleteComment(comment);
                break;
            case ServerOperate.DELETE_COMMENT_BY_UID:
                clientDeleteCommentByUid(comment.getUid());
                break;
            case ServerOperate.DELETE_COMMENT_BY_AID:
                clientDeleteCommentByAid(comment.getAid());
                break;
            case ServerOperate.UPDATE_COMMENT:
                clientUpdateComment(comment);
                break;
            case ServerOperate.QUERY_ALL_COMMENT_BY_UID:
                clientQueryAllCommentByUid(comment.getUid());
                break;
            case ServerOperate.QUERY_ALL_COMMENT_BY_AID:
                clientQueryAllCommentByAid(comment.getAid());
                break;
        }
    }

    public void clientAddComment(Comment comment){
        commentServiceImpl.addComment(comment);
    }

    public void clientDeleteComment(Comment comment){
        commentServiceImpl.addComment(comment);
    }

    public void clientDeleteCommentByUid(String uid){
        commentServiceImpl.deleteCommentByUid(uid);
    }

    public void clientDeleteCommentByAid(String aid){
        commentServiceImpl.deleteCommentByAid(aid);
    }

    public void clientUpdateComment(Comment comment){
        commentServiceImpl.updateComment(comment);
    }

    public void clientQueryAllCommentByUid(String uid) throws IOException {
        List allComment = commentServiceImpl.queryAllCommentByUid(uid);
        sendInfoList(allComment);
    }

    public void clientQueryAllCommentByAid(String aid) throws IOException {
        List allComment = commentServiceImpl.queryAllCommentByUid(aid);
        sendInfoList(allComment);
    }
}
