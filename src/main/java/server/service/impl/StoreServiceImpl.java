package server.service.impl;

import client.entity.Store;
import server.dao.IStoreDao;
import server.dao.impl.StoreDaoImpl;
import server.service.IStoreService;

public class StoreServiceImpl implements IStoreService {
    private IStoreDao storeDao = new StoreDaoImpl();
    @Override
    public boolean addStore(Store store) {
        return storeDao.addStore(store);
    }

    @Override
    public boolean deleteStore(Store store) {
        return storeDao.deleteStore(store);
    }
}
