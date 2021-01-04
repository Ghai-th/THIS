package server.dao;

import client.entity.Attention;

import java.util.List;

public interface IAttentionDao {
    boolean addAttention(Attention attention);
    boolean deleteAttention(Attention attention);
    List<Attention> searchAttention(Attention attention);
    List<Attention>selectAttention(Attention attention);

}
