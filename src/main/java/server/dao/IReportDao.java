package server.dao;

import client.entity.Class;
import client.entity.Report;

import java.util.List;

public interface IReportDao {

    /**
     * 添加举报文章
     */
    void addReportArticle(Report report);
    /**
     * 根据文章id删除举报文章
     */
    void deleteReportArticleByAid(String aid);
    /**
     * 修改举报文章的次数
     */
    void updateReportArticle(Report report);
    /**
     * 根据文章id查找被举报文章
     */
    Report selectReportArticleByAid(String aid);
    /**
     * 查找所有被举报文章
     */
    List selectReportArticle();
}
