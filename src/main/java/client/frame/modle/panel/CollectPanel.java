package client.frame.modle.panel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CollectPanel extends JPanel {
    List<MemberCollectPanel> list = new ArrayList<MemberCollectPanel>();
    public CollectPanel(){
        init();
    }
    public void init(){
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(GetWH.getWidth()*3/5-100,800));
        for(int i=0;i<3;i++){
            MemberCollectPanel a = new MemberCollectPanel();
            list.add(a);
        }
        System.out.println(list.size());
        for (int i = 0;i<list.size();i++){
            this.add(list.get(i));
            System.out.println(3);
        }
    }
}
