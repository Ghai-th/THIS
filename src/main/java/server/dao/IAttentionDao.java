package server.dao;

import client.entity.Attention;
import client.entity.User;

import java.util.List;

public interface IAttentionDao {
    public void addAttention(User user , String fansid) throws Exception;
    public boolean deleteAttention(User user,String id) throws Exception;
    public List<Attention> searchAttention(User user) throws Exception;
}
