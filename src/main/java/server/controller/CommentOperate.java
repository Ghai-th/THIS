package server.controller;

import client.entity.Comment;
import data.Operate;
import server.service.impl.CommentServiceImpl;

public class CommentOperate {
    private Operate commentOperate;
    public CommentServiceImpl commentServiceImpl;
    public CommentOperate(Operate commentOperate) {
        this.commentOperate = commentOperate;
    }

    public Operate getCommentOperate() {
        return commentOperate;
    }

    public void setCommentOperate(Operate commentOperate) {
        this.commentOperate = commentOperate;
    }

    public void executeCommentOperate() {
        switch(commentOperate.operate) {
            case ServerOperate.ADD_COMMENT :
                commentServiceImpl.addComment((Comment) commentOperate);
                break;
            case ServerOperate.DELETE_COMMENT:
                commentServiceImpl.deleteComment((Comment) commentOperate);
                break;
            case ServerOperate.DELETE_COMMENT_BY_UID:
                commentServiceImpl.deleteCommentByUid("1");
                break;
            case ServerOperate.DELETE_COMMENT_BY_AID:
                commentServiceImpl.deleteCommentByAid("1");
                break;
            case ServerOperate.UPDATE_COMMENT:
                commentServiceImpl.updateComment((Comment) commentOperate);
                break;
            case ServerOperate.QUERY_ALL_COMMENT_BY_UID:
                commentServiceImpl.queryAllCommentByUid("1");
                break;
            case ServerOperate.QUERY_ALL_COMMENT_BY_AID:
                commentServiceImpl.queryAllCommentByAid("1");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.commentOperate);
        }
    }
}
