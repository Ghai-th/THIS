package server.dao.impl;


import client.entity.User;

public class test {
    public static void main(String[] args) {
        AttentionImpl attention = new AttentionImpl();
        User user = new User();
        User.initUser(user);
        try {
            attention.addAttention(user,"123");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
