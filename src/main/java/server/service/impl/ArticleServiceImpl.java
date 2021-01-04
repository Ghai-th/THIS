package server.service.impl;

import client.entity.Article;
import server.dao.IArticleDao;
import server.dao.impl.ArticleDaoImpl;
import server.service.IArticleService;

import java.util.List;

public class ArticleServiceImpl implements IArticleService {
    private IArticleDao articleDao = new ArticleDaoImpl();

    @Override
    public boolean addArticle(Article article) {
        return articleDao.addArticle(article);
    }

    @Override
    public boolean deleteArticle(String aid) {
        return articleDao.deleteArticle(aid);
    }

    @Override
    public boolean updateArticle(Article article) {
        return articleDao.updateArticle(article);
    }

    @Override
    public Article selectArticleByAid(String aid) {
        return articleDao.selectArticleByAid(aid);
    }

    @Override
    public List<Article> selectArticleByCid(String cid) {
        return articleDao.selectArticleByCid(cid);
    }

    @Override
    public List<Article> selectArticleByTittle(String tittle) {
        return articleDao.selectArticleByTittle(tittle);
    }

    @Override
    public List<Article> selectArticleByUid(String uid) {
        return articleDao.selectArticleByUid(uid);
    }

    @Override
    public List<Article> selectTopLimitArticle(int limit) {
        return articleDao.selectTopLimitArticle(limit);
    }

    @Override
    public List<Article> selectTopNumArticleByCid(String cid, int limit) {
        return articleDao.selectTopNumArticleByCid(cid,limit);
    }
}
