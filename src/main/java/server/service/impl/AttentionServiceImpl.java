package server.service.impl;

import client.entity.Attention;
import server.dao.IAttentionDao;
import server.dao.impl.AttentionDaoImpl;
import server.service.IAttentionService;

import java.util.List;

public class AttentionServiceImpl implements IAttentionService {
    private IAttentionDao attentionDao = new AttentionDaoImpl();
    @Override
    public boolean addAttention(Attention attention) {
        return attentionDao.addAttention(attention);
    }

    @Override
    public boolean deleteAttention(Attention attention) {
        return attentionDao.deleteAttention(attention);
    }

    @Override
    public List<Attention> searchAttention(Attention attention)  {
        return attentionDao.searchAttention(attention);
    }

    @Override
    public List<Attention> selectAttention(Attention attention)  {
        return attentionDao.selectAttention(attention);
    }
}
