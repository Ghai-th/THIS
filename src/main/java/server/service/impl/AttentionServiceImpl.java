package server.service.impl;

import client.entity.Article;
import client.entity.Attention;
import server.controller.ServerOperate;
import server.dao.IAttentionDao;
import server.dao.impl.AttentionDaoImpl;
import server.service.IAttentionService;

import java.util.ArrayList;
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
        List<Attention> list = attentionDao.searchAttention(attention);
        if (list == null) {
            list = new ArrayList();
            return list;
        }
        return list;
    }

    @Override
    public List<Attention> selectAttention(Attention attention)  {
        List<Attention> list = attentionDao.selectAttention(attention);
        if (list == null) {
            list = new ArrayList();
            return list;
        }
        return list;
    }
}
