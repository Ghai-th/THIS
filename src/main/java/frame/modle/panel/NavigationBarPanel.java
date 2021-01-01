package frame.modle.panel;

import conf.IndexConf;
import entity.Article;
import frame.Index;
import frame.modle.label.ClassLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class NavigationBarPanel extends JPanel implements IndexConf {

    public final  String[] personAction = new String[]{"收藏", "消息", "发表文章"};
    public JTextField searchTextField;
    public JLabel searchLabel;
    public JLabel headImage;
    public Index index;

    public NavigationBarPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public NavigationBarPanel(LayoutManager layout) {
        super(layout);
    }

    public NavigationBarPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public NavigationBarPanel(Index index) {
        this.index = index;
        init();
    }

    public void init() {
        this.setPreferredSize(new Dimension(WIDE, HIGH * 53 / 1050));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));

        final JLabel iconLabel = new JLabel();
        iconLabel.setText("图片THIS");
        iconLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                index.removeAll();
                index.setVisible(false);
                index.add(new Index());
                index.setVisible(true);
            }
        });
        this.add(iconLabel);

        ClassLabel classLabel;
        for (String string : Index.classification) {
            classLabel = new ClassLabel(index);
            classLabel.setText(string);
            this.add(classLabel);
        }

        JPanel searchPanel;
        searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        searchPanel.setPreferredSize(new Dimension(WIDE * 5 / 16, HIGH / 35));
        searchTextField = new JTextField();
        searchTextField.setPreferredSize(new Dimension(WIDE * 5 / 32, HIGH / 35));
        searchPanel.add(searchTextField);
        searchLabel = new JLabel("搜索");
        searchLabel.setPreferredSize(new Dimension(WIDE * 5 / 192, HIGH * 29 / 1050));
        searchLabel.setOpaque(true);
        searchLabel.setBackground(new Color(188, 16, 3, 240));
        searchLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                searchLabel.setBackground(new Color(255, 142, 141));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                searchLabel.setBackground(new Color(188, 16, 3, 240));
                super.mouseExited(e);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // 数据库模糊查询
                String searchText = null;
                super.mouseClicked(e);
                try {
                    searchText = searchTextField.getText();
                } catch (Exception ex) {
                    System.out.println("不可为空");
                }
                System.out.println( "点击搜索" + searchText);
            }
        });
        searchPanel.add(searchLabel);
        this.add(searchPanel);

        headImage = new JLabel("头像");
        headImage.addMouseListener(new MouseAdapter() {
            // 进入个人中心
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.out.println("个人中心");
            }

            // 下面俩实现弹窗
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
            }
        });
        headImage.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 20));
        this.add(headImage);

        for (String string : personAction) {
            classLabel = new ClassLabel(index);
            classLabel.setText(string);
            this.add(classLabel);
        }
    }

}
