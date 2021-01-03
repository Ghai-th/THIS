package server.controller;

import client.entity.Article;
import data.Operate;
import server.service.IArticleService;
import server.service.impl.ArticleServiceImpl;
import server.util.ServerUtil;

import java.io.IOException;
import java.util.List;


public class ArticleOperate {

    public Article article;
    public ServerUtil serverUtil;
    private IArticleService articleService = new ArticleServiceImpl();

    public ArticleOperate(Article article, ServerUtil serverUtil) {
        this.article = article;
        this.serverUtil = serverUtil;
        selectOperate();
    }

    public ArticleOperate() {

    }

    /**
     * 执行对应操作
     */
    public void selectOperate() {
        System.out.println(article.operate);
        switch (article.operate) {
            case ServerOperate.ADD_ARTICLE:
                addArticle();
                break;
            case ServerOperate.DELETE_ARTICLE:
                deleteArticle();
                break;
            case ServerOperate.UPDATE_ARTICLE:
                updateArticle();
                break;
            case ServerOperate.GET_ARTICLE_BY_AID:
                selectArticleByAid();
                break;
            case ServerOperate.GET_ARTICLE_BY_CID:
                System.out.println("cid");
                selectArticleByCid();
                break;
            case ServerOperate.GET_ARTICLE_BY_UID:
                selectArticleByUid();
                break;
            case ServerOperate.GET_ARTICLE_BY_TITTLE:
                selectArticleByTittle();
                break;
            case ServerOperate.GET_ARTICLE_TOP_TEN:
                selectTopTenArticle();
                break;
        }
    }


    /**
     * 添加文章数据，不成功向客户端返回数据
     */
    public void addArticle() {
        boolean success = false;
        success = articleService.addArticle(article);
        if (!success) {
            try {
                serverUtil.sendOperate(new Operate(ServerOperate.ERROR));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 删除文章, 返回错误数据
     */
    public void deleteArticle() {
        boolean success = false;
        success = articleService.deleteArticle(this.article.getAid());
        if (!success) {
            try {
                serverUtil.sendOperate(new Operate(ServerOperate.ERROR));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 跟新文章的 各类num信息 失败返回错误信息
     */
    public void updateArticle(){
        boolean success = false;
        success = articleService.updateArticle(this.article);
        if (!success) {
            try {
                serverUtil.sendOperate(new Operate(ServerOperate.ERROR));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据文章id查找
     */
    public void selectArticleByAid() {
        article = articleService.selectArticleByAid(article.getAid());
        article.operate = ServerOperate.GET_ARTICLE_BY_AID;
        try {
            serverUtil.sendInfo(article,Article.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向客户端发送 分类产找的id
     */
    public void selectArticleByCid() {
        List articles = articleService.selectArticleByCid(article.getCid());
        ((Article)articles.get(0)).operate = ServerOperate.GET_ARTICLE_BY_CID;
        try {
            serverUtil.sendInfoList(articles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向客户端发送 根据文章标题模糊查询的文章列表
     */
    public void selectArticleByTittle() {
        List articles = articleService.selectArticleByTittle(article.getTitle());
        ((Article)articles.get(0)).operate = ServerOperate.GET_ARTICLE_BY_TITTLE;
        try {
            serverUtil.sendInfoList(articles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向客户端发送 某个用户的全部的文章
     */
    public void selectArticleByUid() {
        List articles = articleService.selectArticleByUid(article.getUid());
        ((Article)articles.get(0)).operate = ServerOperate.GET_ARTICLE_BY_UID;
        try {
            serverUtil.sendInfoList(articles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回热度前十的文章
     */
    public void selectTopTenArticle() {
        List articles = articleService.selectTopTenArticle();
        ((Article)articles.get(0)).operate = ServerOperate.GET_ARTICLE_TOP_TEN;
        try {
            serverUtil.sendInfoList(articles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
