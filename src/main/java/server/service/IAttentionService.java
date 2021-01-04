package server.service;

import client.entity.Attention;

import java.util.List;

public interface IAttentionService {
    /**
     * 点击关注按钮后，输入该用户的类对象以及所要关注的人的id
     * @param attention 关注类型对象
     * @return 执行结果
     */
    boolean addAttention(Attention attention) ;


    /**
     * 删除对象中表示的关注关系
     * @param attention 关注对象
     * @return 执行结果
     */
    boolean deleteAttention(Attention attention);

    /**
     * 查询某个用户对应的粉丝
     * @param attention 关注对象
     * @return 执行结果
     */
    List<Attention> searchAttention(Attention attention);


    /**
     * 查询某个用户的关注
     * @param attention 关注对象
     * @return 执行结果
     */
    List<Attention> selectAttention(Attention attention);


}
