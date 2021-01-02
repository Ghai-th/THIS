package server.dao;

import client.entity.Article;

public interface IArticleDao {
    void addArticle(Article article);
    void deleteArticle(Article article);
    void updateArticle(Article article);
    void selectArticle();
}
