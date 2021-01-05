package client.frame.modle.table;

import client.entity.Comment;
import client.entity.User;
import client.util.ClientUtil;
import server.controller.ServerOperate;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.ArrayList;

public class CommentTable extends JTable {

    public JTable table;
    public DefaultTableModel tableModel;
    public int commentLength;

    public CommentTable(JTable table){
        this.table = table;
        this.commentLength = init();
    }

    private int init() {
        tableModel = (DefaultTableModel) table.getModel();
        tableModel.addColumn("评论id");
        tableModel.addColumn("评论者账户");
        tableModel.addColumn("文章id");
        tableModel.addColumn("评论时间");
        tableModel.addColumn("内容");

        table.getTableHeader().setReorderingAllowed(false); // 不可交换顺序
        table.getTableHeader().setResizingAllowed(false); // 不可拉动表格

        int[] length = {120, 120, 120, 160, 550};		//表格的列宽

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

        //从数据库拉取评论数据，放入表格
        ArrayList<Comment> commentList = new ArrayList<>();
        Comment comment = new Comment();
        comment.operate = ServerOperate.SELECT_COMMENT_INFO;
        try {
            ClientUtil.sendInfo(comment, Comment.class);
            commentList.addAll(ClientUtil.acceptList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object[][] o = new Object[commentList.size()][5];
        int i = 0;
        for(Comment comm : commentList) {
            o[i][0] = comm.getCid();
            o[i][1] = comm.getUid();
            o[i][2] = comm.getAid();
            o[i][3] = comm.getCreate().toString();
            o[i][4] = comm.getText();
            tableModel.addRow(o[i]);
            i++;
        }
        table.setFont(new Font("宋体", Font.PLAIN, 18));
        table.setRowHeight(30);

        DefaultTableCellRenderer r   = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, r);

        return commentList.size();
    }

}
