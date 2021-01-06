package server.service.impl;

import client.entity.Article;
import client.entity.User;
import server.controller.ServerOperate;
import server.dao.IArticleDao;
import server.dao.impl.ArticleDaoImpl;
import server.service.IArticleService;
import server.service.IUserService;

import java.util.ArrayList;
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
        Article article = articleDao.selectArticleByAid(aid);
        if (article == null) {
            article = new Article();
            article.operate = ServerOperate.NONE_ARTICLE;
        }
        return article;
    }

    @Override
    public List<Article> selectArticleByCid(String cid) {
        List list = articleDao.selectArticleByCid(cid);
        if (list == null) {
            list = new ArrayList();
            Article article = new Article();
            article.operate = ServerOperate.NONE_ARTICLE;
            list.add(article);
            return list;
        }
        return list;
    }

    @Override
    public List<Article> selectArticleByTittle(String tittle) {
        List list = articleDao.selectArticleByTittle(tittle);
        if (list == null) {
            list = new ArrayList();
            Article article = new Article();
            article.operate = ServerOperate.NONE_ARTICLE;
            list.add(article);
            return list;
        }
        return list;
    }

    @Override
    public List<Article> selectArticleByUid(String uid) {
        List list = articleDao.selectArticleByUid(uid);
        if (list == null) {
            list = new ArrayList();
            Article article = new Article();
            article.operate = ServerOperate.NONE_ARTICLE;
            list.add(article);
            return list;
        }
        return list;
    }

    @Override
    public List<Article> selectTopLimitArticle(int limit) {
        List list = articleDao.selectTopLimitArticle(limit);
        if (list == null) {
            list = new ArrayList();
            Article article = new Article();
            article.operate = ServerOperate.NONE_ARTICLE;
            list.add(article);
            return list;
        }
        return list;
    }

    @Override
    public List<Article> selectTopLimitArticleByCid(String cid, int limit) {
        List list = articleDao.selectTopLimitArticleByCid(cid,limit);
        if (list == null) {
            list = new ArrayList();
            Article article = new Article();
            article.operate = ServerOperate.NONE_ARTICLE;
            list.add(article);
            return list;
        }
        return list;
    }

    @Override
    public int selectAllArticleNum(String uid) {
        return articleDao.selectAllArticleNum(uid);
    }

    @Override
    public List<Article> selectArticlesInfo() {
        List list = articleDao.selectArticlesInfo();
        if (list == null) {
            list = new ArrayList();
            Article article = new Article();
            article.operate = ServerOperate.NONE_ARTICLE;
            list.add(article);
            return list;
        }
        return list;
    }
}
