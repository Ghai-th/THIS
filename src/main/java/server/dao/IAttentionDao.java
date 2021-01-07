package server.dao;

import client.entity.Attention;

import java.util.List;

public interface IAttentionDao {
    /**
     * 增加关注
     * @param attention
     * @return返回增加结果
     */
    boolean addAttention(Attention attention);

    /**
     * 删除关注
     * @param attention
     * @return返回删除结果
     */
    boolean deleteAttention(Attention attention);

    /**
     * 根据id查询粉丝
     * @param attention
     * @return粉丝列表
     */
    List<Attention> searchAttention(Attention attention);

    /**
     * 根据粉丝id查询关注
     * @param attention
     * @return返回关注结果
     */
    List<Attention>selectAttention(Attention attention);

}
