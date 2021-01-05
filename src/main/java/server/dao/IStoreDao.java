package server.dao;

import client.entity.Store;

import java.util.List;

public interface IStoreDao {
    boolean addStore(Store store);
    boolean deleteStore(Store store);
    List<Store> selectStore(Store store);
}
