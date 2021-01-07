package server.service.impl;

import client.entity.Class;
import server.dao.IClassDao;
import server.dao.impl.ClassDaoImpl;
import server.service.IClassService;

import java.util.List;

public class ClassServiceImpl implements IClassService {
    /**
     * 根据类id查询类
     * @param cid
     * @return查询到的类
     */
    @Override
    public Class selectClassById(String cid){
        IClassDao classDao = new ClassDaoImpl();
        return classDao.selectClassById(cid);
    }

    /**
     * 查询所有类
     * @return所有类信息
     */
    @Override
    public List selectAllClass() {
        IClassDao classDao = new ClassDaoImpl();
        return classDao.selectAllClass();
    }


}
