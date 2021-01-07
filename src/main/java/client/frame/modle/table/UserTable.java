package client.frame.modle.table;

import client.entity.User;
import client.frame.modle.label.RankLabel;
import client.util.ClientUtil;
import server.controller.ServerOperate;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.ArrayList;

public class UserTable extends JTable {

    public JTable table;
    public DefaultTableModel tableModel;
    public int userLength;

    public UserTable(JTable table) {
        this.table = table;
        this.userLength = init();
    }

    /**
     * 初始化表格表头
     * @return
     */
    private int init() {
        tableModel = (DefaultTableModel) table.getModel();
        tableModel.addColumn("账户");
        tableModel.addColumn("姓名");
        tableModel.addColumn("等级");
        tableModel.addColumn("性别");
        tableModel.addColumn("粉丝数");
        tableModel.addColumn("关注数");
        tableModel.addColumn("访客数");
        tableModel.addColumn("文章数");
        tableModel.addColumn("创建时间");
        tableModel.addColumn("最后登录时间");
        tableModel.addColumn("活跃度");
        tableModel.addColumn("简介");

        table.getTableHeader().setReorderingAllowed(false); // 不可交换顺序
        table.getTableHeader().setResizingAllowed(false); // 不可拉动表格

        int[] length = {140, 150, 50, 50, 50, 50, 50, 50, 250, 250, 50, 350};		//表格的列宽

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

        //从数据库拉取用户数据，放入表格
        ArrayList<User> userList = new ArrayList<>();
        User user = new User();
        user.operate = ServerOperate.SELECT_USERS_INFO;
        try {
            ClientUtil.sendInfo(user, User.class);
            userList.addAll(ClientUtil.acceptList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object[][] o = new Object[userList.size()][12];
        int n = 0;
        for(User userTop : userList) {
            if(userTop.getPassword().equals("admin")){
                o[n][0] = userTop.getUid();
                o[n][1] = userTop.getName();
                o[n][2] = userTop.getLevel().toString();
                o[n][3] = userTop.getGender().toString();
                o[n][4] = userTop.getFansNum().toString();
                o[n][5] = userTop.getAttentionNum().toString();
                o[n][6] = userTop.getVisitorNum().toString();
                o[n][7] = userTop.getActive().toString();
                o[n][8] = userTop.getCreate().toString();
                o[n][9] = userTop.getLastlogin().toString();
                o[n][10] = userTop.getActive().toString();
                o[n][11] = userTop.getSynopsis();
                tableModel.addRow(o[n]);
                n++;
            }
        }
        int i = 6;
        for(User userTop : userList){
            if(userTop.getPassword().equals("admin")){
                continue;
            } else {
                o[i][0] = userTop.getUid();
                o[i][1] = userTop.getName();
                o[i][2] = userTop.getLevel().toString();
                o[i][3] = userTop.getGender().toString();
                o[i][4] = userTop.getFansNum().toString();
                o[i][5] = userTop.getAttentionNum().toString();
                o[i][6] = userTop.getVisitorNum().toString();
                o[i][7] = userTop.getActive().toString();
                o[i][8] = userTop.getCreate().toString();
                o[i][9] = userTop.getLastlogin().toString();
                o[i][10] = userTop.getActive().toString();
                o[i][11] = userTop.getSynopsis();
                tableModel.addRow(o[i]);
                i++;
            }
        }

        table.setFont(new Font("宋体", Font.PLAIN, 18));
        table.setRowHeight(30);

        DefaultTableCellRenderer r   = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, r);

        return userList.size();
    }
}
