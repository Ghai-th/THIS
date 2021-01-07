package server.service;

import client.entity.Class;

import java.util.List;

public interface IClassService {
    /**
     * 根据类id查询类
     * @param cid
     * @return查询结果
     */
    Class selectClassById(String cid);

    /**
     * 查询所有类名
     * @return返回查询到的信息
     */
    List selectAllClass();
}
