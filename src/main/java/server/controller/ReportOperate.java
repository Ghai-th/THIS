package server.controller;

import client.entity.Report;
import data.Operate;
import server.service.IReportService;
import server.service.impl.ReportServiceImpl;
import server.util.ServerUtil;
import java.io.IOException;
import java.util.List;

public class ReportOperate {
    public Report report;
    public ServerUtil serverUtil;
    public IReportService reportService;

    public ReportOperate(){
    }

    public ReportOperate(ReportOperate reportOperate,ServerUtil serverUtil){
        reportService = new ReportServiceImpl();
        this.report= report;
        this.serverUtil = serverUtil;
        executeReportOperate();
    }
    /**
     * 执行操作
     */
    public void executeReportOperate(){
        switch (report.operate){
            case ServerOperate.ADD_REPORT_ARTICLE:
                addReportArticle();
                break;
            case ServerOperate.DELETE_REPORT_ARTICLE_BY_AID:
                deleteReportArticleByAid();
                break;
            case ServerOperate.UPDATE_REPORT_ARTICLE:
                updateReportArticle();
                break;
            case ServerOperate.SELECT_REPORT_ARTICLE_BY_AID:
                selectReportArticleByAid();
                break;
            case ServerOperate.SELECT_REPORT_ARTICLE:
                selectReportArticle();
                break;
        }
    }

    /**
     * 增加举报文章
     */
    public void addReportArticle(){
        boolean success = false;
        success = reportService.addReportArticle(report);
        if (!success){
            try {
                serverUtil.sendOperate(new Operate(ServerOperate.ERROR));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据文章id删除举报次数
     */
    public void deleteReportArticleByAid(){
        boolean success = false;
        success = reportService.deleteReportArticleByAid(report.getAid());
        if (!success){
            try{
                serverUtil.sendOperate(new Operate(ServerOperate.ERROR));
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据文章id修改举报文章举报次数
     */
    public void updateReportArticle(){
        report = reportService.selectReportArticleByAid(report.getAid());
        report.setReportNum(report.getReportNum() + 1);
        reportService.updateReportArticle(report);
        report.operate = ServerOperate.UPDATE_REPORT_ARTICLE;

    }

    /**
     * 根据文章id查找被举报文章
     */
    public void selectReportArticleByAid(){
        report = reportService.selectReportArticleByAid(report.getAid());
        report.operate = ServerOperate.ADD_REPORT_ARTICLE;
        try{
            serverUtil.sendInfo(report,Report.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查找所有被举报的文章
     */
    public void selectReportArticle(){
        List reports = reportService.selectReportArticle();
        ((Report)reports.get(0)).operate = ServerOperate.DELETE_REPORT_ARTICLE_BY_AID;
        try{
            serverUtil.sendInfoList(reports);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
