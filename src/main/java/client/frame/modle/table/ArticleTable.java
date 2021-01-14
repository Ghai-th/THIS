package client.frame.modle.table;

import client.entity.Article;
import client.entity.Report;
import client.entity.User;
import client.util.ClientUtil;
import server.controller.ServerOperate;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArticleTable extends JTable {
    public JTable table;
    public DefaultTableModel tableModel;
    public ArrayList<Article> articleArrayList;
    public ArrayList<Report> reportArrayList;

    public ArticleTable(JTable table){
        this.table = table;
        init();
    }

    /**
     * 初始化表格表头
     */
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
        tableModel.addColumn("被举报次数");

        table.getTableHeader().setReorderingAllowed(false); // 不可交换顺序
        table.getTableHeader().setResizingAllowed(false); // 不可拉动表格

        int[] length = {400, 50, 50, 50, 250, 250, 50, 50, 50, 50};		//表格的列宽

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

        /**
         * 从数据库拉取文章数据，放入表格
         */
        articleArrayList = new ArrayList<>();
        Article articl = new Article();
        articl.operate = ServerOperate.SELECT_ARTICLE_INFO;
        try {
            ClientUtil.sendInfo(articl, Article.class);
            articleArrayList.addAll(ClientUtil.acceptList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        /**
         * 从数据库拉取举报列表数据，放入表格
         */
        reportArrayList = new ArrayList<>();
        Report report = new Report();
        report.operate = ServerOperate.SELECT_REPORT_ARTICLE;
        try {
            ClientUtil.sendInfo(report, Report.class);
            reportArrayList.addAll(ClientUtil.acceptList());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Object[][] o = new Object[articleArrayList.size()][11];
        boolean flag = true;
        while(flag){
            int i = 0;
            for(Article art : articleArrayList) {
                o[i][0] = art.getTitle();
                o[i][1] = art.getAid();
                o[i][2] = art.getUid();
                o[i][3] = art.getCid();
                o[i][4] = art.getCreate().toString();
                o[i][5] = art.getRenewal().toString();
                o[i][6] = art.getVisitorNum().toString();
                o[i][7] = art.getLikeNum().toString();
                o[i][8] = art.getCollectNum().toString();
                i++;
            }
            int j = 0;
            for(Report rep : reportArrayList){
                o[j][9] = rep.getReportNum().toString();
                j++;
            }
            for(int k = 0; k < articleArrayList.size(); k++){
                tableModel.addRow(o[k]);
            }
            flag = false;
        }

        table.setFont(new Font("宋体", Font.PLAIN, 18));
        table.setRowHeight(30);

        DefaultTableCellRenderer r  = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, r);

    }
}
