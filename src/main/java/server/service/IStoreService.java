package server.service;

import client.entity.Store;

import java.util.List;

public interface IStoreService {
    boolean addStore(Store store);
    boolean deleteStore(Store store);
    List<Store> selectStore(Store store);
}
