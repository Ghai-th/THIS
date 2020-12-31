package frame.modle.panel;

import conf.IndexConf;
import frame.Index;
import frame.modle.label.ClassLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NavigationBarPanel extends JPanel implements IndexConf {

    public final  String[] personAction = new String[]{"收藏", "消息", "发表文章"};
    public JTextField searchTextField;
    public JLabel searchLabel;
    public JLabel headImage;

    public NavigationBarPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public NavigationBarPanel(LayoutManager layout) {
        super(layout);
    }

    public NavigationBarPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public NavigationBarPanel() {
        init();
    }

    public void init() {
        this.setPreferredSize(new Dimension(WIDE, HIGH * 53 / 1050));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));

        ClassLabel iconClassLabel = new ClassLabel();
        iconClassLabel.setText("图片THIS");
        this.add(iconClassLabel);

        ClassLabel classLabel;
        for (String string : Index.classification) {
            classLabel = new ClassLabel();
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
            classLabel = new ClassLabel();
            classLabel.setText(string);
            this.add(classLabel);
        }
    }
}
