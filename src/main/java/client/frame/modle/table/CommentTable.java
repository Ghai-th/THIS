package client.frame.modle.table;

import client.entity.Comment;
import client.entity.User;
import client.util.ClientUtil;
import server.controller.ServerOperate;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.ArrayList;

public class CommentTable extends JTable {

    public JTable table;
    public DefaultTableModel tableModel;

    public CommentTable(JTable table){
        this.table = table;
        init();
    }

    private void init() {
        tableModel = (DefaultTableModel) table.getModel();
        tableModel.addColumn("评论id");
        tableModel.addColumn("评论者账户");
        tableModel.addColumn("文章id");
        tableModel.addColumn("评论时间");
        tableModel.addColumn("内容");

        table.getTableHeader().setReorderingAllowed(false); // 不可交换顺序
        table.getTableHeader().setResizingAllowed(false); // 不可拉动表格

        int[] length = {160, 160, 160, 160, 500};		//表格的列宽

        //获取表格的 列 模型
        TableColumnModel model = table.getColumnModel();
        //设置每列的宽度
        for (int i = 0 ; i< model.getColumnCount() ; i++)
        {
            TableColumn column = model.getColumn(i);			//获取列对象
            column.setPreferredWidth(length[i]);				//设置列宽
        }

        JTableHeader tabHeader = table.getTableHeader();					//获取表头
        tabHeader.setFont(new Font("宋体", Font.BOLD, 18));


        //////////////////////////////
        //从数据库拉取评论数据，放入表格

        ArrayList<Comment> commentList = new ArrayList<>();
        Comment comment = new Comment();
        comment.operate = ServerOperate.SELECT_USERS_INFO ;
        try {
            ClientUtil.sendInfo(comment, User.class);
            commentList.addAll(ClientUtil.acceptList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(Comment comment1 : commentList) {
            System.out.println(comment1);
        }










    }

}
