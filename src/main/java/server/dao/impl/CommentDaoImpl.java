package server.dao.impl;

import client.entity.Comment;
import server.dao.ICommentDao;
import server.util.DBUtil;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.List;

public class CommentDaoImpl implements ICommentDao {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    List<Comment> list;
    int count;

    /**
     * 向数据库添加评论
     * @param comment 评论
     */
    public void addComment(Comment comment) {
        System.out.println("tianjia");
        System.out.println(comment);
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

    /**
     * 删除评论
     * @param comment 评论
     * @return返回true或者false
     */
    public boolean deleteComment(Comment comment) {
        try {
            conn = DBUtil.getConnection();
            String sql = "delete from comment where cid = '" + comment.getCid() + "'";
            System.out.println(comment.getCid());
            stmt = DBUtil.getStatement(conn);
            DBUtil.executeChange(stmt, sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            DBUtil.closeResources(conn, stmt, rs);
        }
    }

    /**
     * 根据用户id删除数据库中的评论
     * @param uid 用户id
     */
    @Override
    public void deleteCommentByUid(String uid) {
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

    /**
     * 根据文章id删除数据库种中的所有评论
     * @param aid 文章id
     */
    @Override
    public void deleteCommentByAid(String aid) {
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

    /**
     * 根据评论id修改数据库中的评论
     * @param comment 评论
     */
    public void updateComment(Comment comment) {
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

    /**
     * 根据用户id查询所有评论
     * @param  uid 的用户id
     * @return 评论列表
     */
    public List<Comment> queryAllCommentByUid(String uid) {
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

    /**
     * 根据文章id查询所有评论
     * @param aid 文章id
     * @return 评论信息
     */
    public List<Comment> queryAllCommentByAid(String aid) {
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

    /**
     * 查询全部评论数量
     * @return
     */
    @Override
    public int selectAllCommentNum() {
        int integer = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "select count(*) num from comment";
            stmt = DBUtil.getStatement(conn);
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                integer = resultSet.getInt("num");
            }
            return integer;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeResources(conn, stmt, rs);
        }
        return 0;
    }

    /**
     * 查询全部评论
     * @return
     */
    @Override
    public List<Comment> selectCommentInfo() {
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from comment";
            stmt = DBUtil.getStatement(conn);
            list = DBUtil.executeGetMoreData(stmt, sql, Comment.class);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResources(conn, stmt, rs);
        }
        return null;
    }
}
