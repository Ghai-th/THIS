package server.dao;

import client.entity.Store;

import java.util.List;

public interface IStoreDao {
    /**
     * 添加收藏
     * @param store
     * @return返回添加结果
     */
    boolean addStore(Store store);

    /**
     * 删除收藏
     * @param store
     * @return返回删除结果
     */
    boolean deleteStore(Store store);

    /**
     * 查询收藏信息
     * @param store
     * @return返回信息结果
     */
    List<Store> selectStore(Store store);
}
