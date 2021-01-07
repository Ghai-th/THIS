package server.service.impl;

import client.entity.Report;
import server.dao.IReportDao;
import server.dao.impl.ReportDaoImpl;
import server.service.IReportService;

import java.sql.SQLException;
import java.util.List;

public class ReportServiceImpl implements IReportService {
    IReportDao reportDao = new ReportDaoImpl();

    /**
     *添加举报文章
     */
    @Override
    public boolean addReportArticle(Report report) {
       //若该文章第一次被举报，则插入表中，若已经被举报，举报次数+1
        try {
            reportDao.addReportArticle(report);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }
    /**
     *根据文章id删除举报文章
     */
    @Override
    public boolean deleteReportArticleByAid(String aid) {
        //若该文章被举报，则删除；若未被举报，则返回false
        try {
            reportDao.deleteReportArticleByAid(aid);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     *修改举报文章的次数
     */
    @Override
    public void updateReportArticle(Report report) {
        reportDao.updateReportArticle(report);
    }

    /**
     *根据文章id查找被举报文章
     */
    @Override
    public Report selectReportArticleByAid(String aid) {
        return  reportDao.selectReportArticleByAid(aid);
    }

    /**
     *查找所有被举报文章
     */
    @Override
    public List<Report> selectReportArticle() {
        List<Report> reportList = reportDao.selectReportArticle();
        return reportList;
    }
}
