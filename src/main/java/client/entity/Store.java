package client.entity;

import java.util.Date;

public class Store implements java.io.Serializable{
    private String uid;
    private String aid;
    private Date time;

    public Store() {
    }

    public Store(String uid, String aid) {
        this.uid = uid;
        this.aid = aid;
        this.time = new Date();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "store{" +
                "uid='" + uid + '\'' +
                ", aid='" + aid + '\'' +
                ", time=" + time +
                '}';
    }
}
