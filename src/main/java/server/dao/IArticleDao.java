package server.dao;

import client.entity.Article;

public interface IArticleDao {

    /**
     * 文章对象加入数据库
     * @param article 文章
     * @return 返回结果
     */
    boolean addArticle(Article article);

    /**
     * 根据id删除文章
     * @param aid id
     * @return 返回删除结果
     */
    boolean deleteArticle(String aid);



}
