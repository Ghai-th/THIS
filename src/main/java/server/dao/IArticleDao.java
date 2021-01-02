package server.dao;

import client.entity.Article;

import java.util.List;

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

    /**
     * 修改文章信息
     * @param article 文章对象
     * @return 修改结果
     * 修改文章的更新时间，各种num
     */
    boolean updateArticle(Article article);

    /**
     * 根据aid查询文章
     * @param aid
     * @return
     */
    Article selectArticleByAid(String aid);

    /**
     * 根据分类号查找文章
     * @param cid 分类编号
     * @return 返回所有符号条件的文章的list
     */
    List<Article> selectArticleByCid(String cid);

    /**
     * 根据文章标题模糊查询文章列表
     * @param tittle 文章的标题
     * @return 返回文章列表
     */
    List<Article> selectArticleByTittle(String tittle);

    /**
     * 根据作者id查找文章
     * @param uid 作者id
     * @return 返回文章列表
     */
    List<Article> selectArticleByUid(String uid);

    /**
     * 查询前10的文章
     * @return 文章列表
     */
    List<Article> selectTopTenArticle();

}
