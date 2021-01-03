package server.controller;

import client.entity.Article;
import data.Operate;
import server.service.IArticleService;
import server.service.impl.ArticleServiceImpl;
import server.util.ServerUtil;


public class ArticleOperate {

    public Article article;
    private IArticleService articleService = new ArticleServiceImpl();

    public ArticleOperate(Article article) {
        this.article = article;
    }

    public ArticleOperate() {

    }



    public void addArticle() {
        boolean success = false;
        success = articleService.addArticle(article);
        if (!success) {
            ServerUtil.sendOperate(new Operate(ServerOperate.ERROR));
        }
    }

    public void deleteArticle() {

    }




    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
