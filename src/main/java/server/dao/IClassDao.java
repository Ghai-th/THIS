package server.dao;

import client.entity.Class;

public interface IClassDao {
    /**
     * 根据分类号查找类
     * @param cid
     * @return 返回符合条件的类
     */
    Class selectClassById(String cid);
}
