package server.service.impl;

import client.entity.Comment;
import server.dao.ICommentDao;
import server.dao.impl.CommentDaoImpl;
import server.service.ICommentService;

import java.util.List;

public class CommentServiceImpl implements ICommentService {

    ICommentDao commentDao = new CommentDaoImpl();

    @Override
    public boolean addComment(Comment comment) {
        //某人评论
        List<Comment> commentList = commentDao.queryAllCommentByAid(comment.getAid());
        for(Comment demo : commentList) {
            if(demo.getUid() == comment.getUid()){
                return false;
            }
        }
        commentDao.addComment(comment);
        return true;
    }

    @Override
    public boolean deleteComment(Comment comment) {
        //某人删除自己的评论
        List<Comment> commentList = commentDao.queryAllCommentByUid(comment.getUid());
        for(Comment demo : commentList) {
            if(demo.getAid() == comment.getAid()){
                commentDao.deleteComment(comment);
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteCommentByUid(String uid) {
        //管理员删除某人的所有评论
        commentDao.deleteCommentByUid(uid);
    }

    @Override
    public void deleteCommentByAid(String aid) {
        //管理员删除某篇文章的所有评论
        commentDao.deleteCommentByAid(aid);
    }

    @Override
    public void updateComment(Comment comment) {
        //用户修改自己的评论
        commentDao.updateComment(comment);
    }

    @Override
    public List<Comment> queryAllCommentByUid(String uid) {
        //返回用户的所有评论
        List<Comment> commentList = commentDao.queryAllCommentByUid(uid);
        return commentList;
    }

    @Override
    public List<Comment> queryAllCommentByAid(String aid) {
        //返回文章的所有评论
        List<Comment> commentList = commentDao.queryAllCommentByAid(aid);
        return commentList;
    }
}
