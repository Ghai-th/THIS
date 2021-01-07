package server.service.impl;

import client.entity.Comment;
import server.controller.ServerOperate;
import server.dao.ICommentDao;
import server.dao.impl.CommentDaoImpl;
import server.service.ICommentService;

import java.util.ArrayList;
import java.util.List;

public class CommentServiceImpl implements ICommentService {

    ICommentDao commentDao = new CommentDaoImpl();

    @Override
    public boolean addComment(Comment comment) {
        //某人评论
        /**
         * 判断评论人是否已经评论
         */
//        List<Comment> commentList = commentDao.queryAllCommentByAid(comment.getAid());
//        for(Comment demo : commentList) {
//            System.out.println(demo);
//            if(demo.getUid().equals(comment.getUid())){
//                System.out.println("相同tui chu le");
//                return false;
//            }
//        }
        commentDao.addComment(comment);
        return true;
    }

    @Override
    public boolean deleteComment(Comment comment) {
        return commentDao.deleteComment(comment);
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
        List<Comment> list = commentDao.queryAllCommentByUid(uid);
        if (list == null) {
             Comment comment = new Comment();
             comment.operate = ServerOperate.NULL;
             list = new ArrayList<>();
             list.add(comment);
        }
        return list;
    }

    @Override
    public List<Comment> queryAllCommentByAid(String aid) {
        //返回文章的所有评论
        List<Comment> list = commentDao.queryAllCommentByAid(aid);
        if (list == null) {
            Comment comment = new Comment();
            comment.operate = ServerOperate.NULL;
            list = new ArrayList<>();
            list.add(comment);
        }
        return list;

    }

    @Override
    public int selectAllCommentNum() {
        //查询所有评论
        int commentNum = commentDao.selectAllCommentNum();
        return commentNum;
    }

    @Override
    public List<Comment> selectCommentInfo() {
        //返回文章的所有评论
        List<Comment> list = commentDao.selectCommentInfo();
        if (list == null) {
            Comment comment = new Comment();
            comment.operate = ServerOperate.NULL;
            list = new ArrayList<>();
            list.add(comment);
        }
        return list;
    }

}
