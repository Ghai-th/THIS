package server.dao;

import client.entity.Store;

public interface IStoreDao {
    boolean addStore(Store store);
    boolean deleteStore(Store store);
}
