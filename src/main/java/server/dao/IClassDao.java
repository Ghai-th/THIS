package server.dao;

import client.entity.Class;

public interface IClassDao {
    /**
     * 根据分类号查找类
     * @param cid
     * @return 返回符合条件的类
     */
    Class selectClassById(String cid);
    /**
     * 查询所有分类
     * @return 返回所有类
     */
    Class selectAllClass();
}
