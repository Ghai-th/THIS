package server.dao;

import client.entity.Class;

public interface IClassDao {
    Class selectClassById(String cid);
}
