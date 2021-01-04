package server.controller;

import server.service.IReportService;
import server.service.impl.ReportServiceImpl;
import server.util.ServerUtil;

public class ReportOperate {
    public ReportOperate reportOperate;
    public ServerUtil serverUtil;
    public IReportService reportService;

    public ReportOperate(){
    }

    public ReportOperate(ReportOperate reportOperate,ServerUtil serverUtil){
        reportService = new ReportServiceImpl();
        this.reportOperate= reportOperate;
        this.serverUtil = serverUtil;

    }
}
