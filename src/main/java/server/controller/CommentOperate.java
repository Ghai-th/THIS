package server.controller;

import client.entity.Comment;
import data.Operate;
import server.service.impl.CommentServiceImpl;

import java.io.IOException;
import java.util.List;

import static server.util.ServerUtil.sendInfoList;

public class CommentOperate {

    public CommentServiceImpl commentServiceImpl;
    public Comment comment;

    public CommentOperate(Comment comment) {
        this.comment = comment;
    }

    public void executeCommentOperate() {
        switch(comment.operate) {
            case ServerOperate.ADD_COMMENT :
                clientAddComment();
                break;
            case ServerOperate.DELETE_COMMENT:
                clientDeleteComment();
                break;
            case ServerOperate.DELETE_COMMENT_BY_UID:
                clientDeleteCommentByUid();
                break;
            case ServerOperate.DELETE_COMMENT_BY_AID:
                clientDeleteCommentByAid();
                break;
            case ServerOperate.UPDATE_COMMENT:
                clientUpdateComment();
                break;
            case ServerOperate.QUERY_ALL_COMMENT_BY_UID:
                clientQueryAllCommentByUid();
                break;
            case ServerOperate.QUERY_ALL_COMMENT_BY_AID:
                clientQueryAllCommentByAid();
                break;
        }
    }

    public void clientAddComment(){
        commentServiceImpl.addComment(comment);
    }

    public void clientDeleteComment(){
        commentServiceImpl.addComment(comment);
    }

    public void clientDeleteCommentByUid(){
        commentServiceImpl.deleteCommentByUid(comment.getUid());
    }

    public void clientDeleteCommentByAid(){
        commentServiceImpl.deleteCommentByAid(comment.getAid());
    }

    public void clientUpdateComment(){
        commentServiceImpl.updateComment(comment);
    }

    public void clientQueryAllCommentByUid() {
        List allComment = commentServiceImpl.queryAllCommentByUid(comment.getUid());
        try {
            sendInfoList(allComment);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clientQueryAllCommentByAid() {
        List allComment = commentServiceImpl.queryAllCommentByAid(comment.getAid());
        try {
            sendInfoList(allComment);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
