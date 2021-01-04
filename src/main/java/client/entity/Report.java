package client.entity;


import data.Operate;

public class Report extends Operate implements java.io.Serializable {
    private String aid;
    private String reportNum;

    public Report(String aid,String reportNum){
        this.aid = aid;
        this.reportNum = reportNum;
    }

    public Report(){
    }

    public static Report initReport(){
        return new Report("100002","2");
    }

    public void setAid(String aid){
        this.aid = aid;
    }

    public String getAid(){
        return aid;
    }

    public void setReportNum(String reportNum ){
        this.reportNum = reportNum;
    }
    public String getReportNum(){
        return reportNum;
    }

    @Override
    public String toString() {
        return "Report{" +
                "aid='" + aid + '\'' +
                ", reportNum='" + reportNum + '\'' +
                '}';
    }

}
