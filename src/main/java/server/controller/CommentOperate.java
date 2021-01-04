package server.controller;

import client.entity.Comment;
import data.Operate;
import server.service.ICommentService;
import server.service.impl.CommentServiceImpl;
import server.util.ServerUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommentOperate {

    public Comment comment;
    public ServerUtil serverUtil;
    public ICommentService commentService;

    public CommentOperate() {

    }

    public CommentOperate(Comment comment, ServerUtil serverUtil) {
        commentService = new CommentServiceImpl();
        this.comment = comment;
        this.serverUtil = serverUtil;
        executeCommentOperate();
    }

    /**
     * 执行操作
     */
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

    /**
     * 添加评论
     */
    public void clientAddComment(){
        commentService.addComment(comment);
    }

    /**
     * 删除评论
     */
    public void clientDeleteComment(){
        commentService.addComment(comment);
    }

    /**
     * 管理员删除某用户的评论
     */
    public void clientDeleteCommentByUid(){
        commentService.deleteCommentByUid(comment.getUid());
    }

    /**
     * 管理员删除某文章的评论
     */
    public void clientDeleteCommentByAid(){
        commentService.deleteCommentByAid(comment.getAid());
    }

    /**
     * 更新评论
     */
    public void clientUpdateComment(){
        commentService.updateComment(comment);
    }

    /**
     * 向服务端发送某用户全部评论列表
     */
    public void clientQueryAllCommentByUid() {
        List allComment = commentService.queryAllCommentByUid(comment.getUid());
        try {
            serverUtil.sendInfoList(allComment);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向服务器发送某文章全部评论列表
     */
    public void clientQueryAllCommentByAid() {
        List allComment = commentService.queryAllCommentByAid(comment.getAid());
        ((Comment)allComment.get(0)).operate = ServerOperate.QUERY_ALL_COMMENT_BY_AID;
        ArrayList l = (ArrayList) allComment;
        System.out.println(123121231);
        System.out.println(l.size());
        try {
            serverUtil.sendInfoList(allComment);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
