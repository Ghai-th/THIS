package client.frame.modle.panel;

import client.entity.User;

import javax.swing.*;
import java.awt.*;

public class FriendListPanel extends JPanel {
    public User user;
    public FriendListPanel(User user) {
        this.user = user;
        init();
    }

    public void init() {
        this.setLocation(null);
        this.setPreferredSize(new Dimension());
    }
}
