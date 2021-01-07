package client.entity;


import data.Operate;

public class Report extends Operate implements java.io.Serializable {
    private String aid;
    private Integer reportNum;

    public Report(String aid,int reportNum){
        this.aid = aid;
        this.reportNum = reportNum;
    }

    public Report(){
    }

    public static Report initReport(){
        return new Report("100002",0);
    }

    public void setAid(String aid){
        this.aid = aid;
    }

    public String getAid(){
        return aid;
    }

    public void setReportNum(int reportNum ){
        this.reportNum = reportNum;
    }
    public Integer getReportNum(){
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
