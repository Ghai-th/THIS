package server.dao.impl;

import client.entity.Comment;
import server.dao.ICommentDao;
import server.util.DBUtil;

import java.sql.*;
import java.util.List;

public class CommentDaoImpl implements ICommentDao {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    List<Comment> list;

    public void addComment(Comment comment) {
        //向数据库添加评论
        try {
            conn = DBUtil.getConnection();
            String sql = "insert into comment values ('" + comment.getCid() + "' ,'" + comment.getUid() + "', '" + comment.getAid() + "' , '" + comment.getText() + "' , '" + comment.getCreate() + "')";
            stmt = DBUtil.getStatement(conn);
            DBUtil.executeChange(stmt, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeResources(conn, stmt, rs);
        }
    }

    public void deleteComment(Comment comment) {
        //删除数据库评论
        try {
            conn = DBUtil.getConnection();
            String sql = "delete from comment where cid = '" + comment.getCid() + "'";
            stmt = DBUtil.getStatement(conn);
            DBUtil.executeChange(stmt, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeResources(conn, stmt, rs);
        }
    }

    @Override
    public void deleteCommentByUid(String uid) {
        //删除用户id对应数据库中所有评论
        try {
            conn = DBUtil.getConnection();
            String sql = "delete from comment where uid = '" + uid + "'";
            stmt = DBUtil.getStatement(conn);
            DBUtil.executeChange(stmt, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeResources(conn, stmt, rs);
        }
    }

    @Override
    public void deleteCommentByAid(String aid) {
        //删除文章id对应数据库中的所有评论
        try {
            conn = DBUtil.getConnection();
            String sql = "delete from comment where aid = '" + aid + "'";
            stmt = DBUtil.getStatement(conn);
            DBUtil.executeChange(stmt, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeResources(conn, stmt, rs);
        }
    }

    public void updateComment(Comment comment) {
        //修改数据库中评论
        try {
            conn = DBUtil.getConnection();
            String sql = "update comment set text = '" + comment.getText() + "' and create = '" + comment.getCreate() + "' where cid = '" + comment.getCid() + "'";
            stmt = DBUtil.getStatement(conn);
            DBUtil.executeChange(stmt, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeResources(conn, stmt, rs);
        }
    }

    public List<Comment> queryAllCommentByUid(String uid) {
        //查找用户id对应所有评论信息
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from comment where uid = '" + uid + "'";
            stmt = DBUtil.getStatement(conn);
            list = DBUtil.executeGetMoreData(stmt, sql, Comment.class);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeResources(conn, stmt, rs);
        }
        return null;
    }

    public List<Comment> queryAllCommentByAid(String aid) {
        //查找文章id对应所有评论信息
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from comment where aid = '" + aid + "'";
            stmt = DBUtil.getStatement(conn);
            list = DBUtil.executeGetMoreData(stmt, sql, Comment.class);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeResources(conn, stmt, rs);
        }
        return null;
    }

    public static void main(String[] args) {
        CommentDaoImpl commentDaoImpl = new CommentDaoImpl();
        Comment comment = Comment.initComment();
        commentDaoImpl.addComment(comment);
    }

}
