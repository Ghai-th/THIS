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
     * @param aid 用户id
     * @return 返回文章列表
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
     * 查询全部文章中热度排名前limit的文章
     * @param limit 查询条数
     * @return 文章列表
     */
    List<Article> selectTopLimitArticle(int limit);

    /**
     * 查询各个分类下的热度排名前limit的文章
     * @param cid 分类号
     * @param limit 查询条数
     * @return 返回
     */
    List<Article> selectTopLimitArticleByCid(String cid, int limit);

    /**
     * 统计某用户的文章数量
     * @param uid 用户id
     * @return 返回数量
     */
    int selectAllArticleNum(String uid);

    /**
     * 返回用户的部分数据
     */
    List<Article> selectArticlesInfo();

}
