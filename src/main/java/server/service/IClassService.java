package server.service;

import client.entity.Class;

import java.util.List;

public interface IClassService {
    Class selectClassById(String cid);
    List selectAllClass();
}
