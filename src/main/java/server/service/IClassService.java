package server.service;

import client.entity.Class;

public interface IClassService {
    Class selectClassById(String cid);
}
