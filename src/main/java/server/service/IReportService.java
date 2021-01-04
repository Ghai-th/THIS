package server.service;

import client.entity.Report;

import java.util.List;

public interface IReportService {
    /**
     * 添加举报文章
     */

    boolean addReportArticle(Report report);
    /**
     * 根据文章id删除举报文章
     */
    boolean deleteReportArticleByAid(String aid);

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
    List<Report> selectReportArticle();
}

