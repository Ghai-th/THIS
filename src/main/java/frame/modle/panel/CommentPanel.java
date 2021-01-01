package frame.modle.panel;

import javax.swing.*;
import java.awt.*;

public class CommentPanel extends JPanel {
    public CommentPanel(){
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(800,800));
        MembercommentPanel membercommentPanelone = new MembercommentPanel();
        MembercommentPanel membercommentPanelotwo = new MembercommentPanel();
        MembercommentPanel membercommentPanelthree = new MembercommentPanel();
        add(membercommentPanelone);
        add(membercommentPanelotwo);
        add(membercommentPanelthree);
    }
}
