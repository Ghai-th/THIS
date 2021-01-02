package server.dao;

import client.entity.Attention;
import client.entity.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface IAttentionDao {
    void addAttention(User user , String fansid) throws Exception;
    boolean deleteAttention(User user,String id) throws Exception;
    List<Attention> searchAttention(User user) throws Exception;
    List<Attention>selectAttention(User user) throws Exception;

}
