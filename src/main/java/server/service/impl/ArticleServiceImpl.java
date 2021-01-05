package server.service.impl;

import client.entity.Article;
import client.entity.User;
import server.dao.IArticleDao;
import server.dao.impl.ArticleDaoImpl;
import server.service.IArticleService;
import server.service.IUserService;

import java.util.List;

public class ArticleServiceImpl implements IArticleService {
    private IArticleDao articleDao = new ArticleDaoImpl();
    private IUserService userService = new UserServiceImpl();

    @Override
    public boolean addArticle(Article article) {
        User user = new User();
        user.setUid(article.getUid());
        user = userService.selectUser(user);
        user.setArticleNum(user.getArticleNum() + 1);
        userService.updateUserArticleNum(user);
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
    public List<Article> selectTopLimitArticleByCid(String cid, int limit) {
        return articleDao.selectTopLimitArticleByCid(cid,limit);
    }

    @Override
    public int selectAllArticleNum(String uid) {
        return articleDao.selectAllArticleNum(uid);
    }
}
