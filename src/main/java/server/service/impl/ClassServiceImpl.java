package server.service.impl;

import client.entity.Class;
import server.dao.IClassDao;
import server.dao.impl.ClassDaoImpl;
import server.service.IClassService;

public class ClassServiceImpl implements IClassService {
    @Override
    public Class selectClassById(String cid){
        IClassDao classDao = new ClassDaoImpl();
        return classDao.selectClassById(cid);
    }

    @Override
    public Class selectAllClass() {
        IClassDao classDao = new ClassDaoImpl();
        return classDao.selectAllClass();
    }


}
