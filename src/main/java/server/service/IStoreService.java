package server.service;

import client.entity.Store;

public interface IStoreService {
    boolean addStore(Store store);
    boolean deleteStore(Store store);
}
