package client.entity;

import data.Operate;

public class Attention extends Operate implements java.io.Serializable{

    private static final long serialVersionUID = 1111001L;

    private String uid;
    private String fansId;

    public Attention() {
    }

    public Attention(String uid, String fansId) {
        this.uid = uid;
        this.fansId = fansId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFansId() {
        return fansId;
    }

    public void setFansId(String fansId) {
        this.fansId = fansId;
    }

    @Override
    public String toString() {
        return "collect{" +
                "uid='" + uid + '\'' +
                ", fansId='" + fansId + '\'' +
                '}';
    }
}
