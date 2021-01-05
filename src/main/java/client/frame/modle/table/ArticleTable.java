package client.frame.modle.table;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class ArticleTable extends JTable {
    public JTable table;
    public DefaultTableModel tableModel;

    public ArticleTable(JTable table){
        this.table = table;
        init();
    }

    private void init() {
        tableModel = (DefaultTableModel) table.getModel();
        tableModel.addColumn("标题");
        tableModel.addColumn("文章id");
        tableModel.addColumn("作者账户");
        tableModel.addColumn("类型");
        tableModel.addColumn("创建时间");
        tableModel.addColumn("最后一次修改时间");
        tableModel.addColumn("访问量");
        tableModel.addColumn("点赞数");
        tableModel.addColumn("收藏数");

        table.getTableHeader().setReorderingAllowed(false); // 不可交换顺序
        table.getTableHeader().setResizingAllowed(false); // 不可拉动表格

        int[] length = {350,160, 160, 160, 160, 160, 160, 160, 160};		//表格的列宽

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
    }
}
