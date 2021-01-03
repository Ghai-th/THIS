package client.entity;

import data.Operate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment extends Operate implements java.io.Serializable{

    private static final long serialVersionUID = 1111003L;

    private String cid;
    private String uid;
    private String aid;
    private String text;
    private Date create;

    public Comment() {
    }

    public Comment(String cid, String uid, String aid, String text) {
        this.cid = cid;
        this.uid = uid;
        this.aid = aid;
        this.text = text;
        this.create = new Date();
    }

    public static Comment initComment() {
        return new Comment("123","456","789","作者写的很棒，受益匪浅");
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public String getCid() {
        return cid;
    }

    public String getUid() {
        return uid;
    }

    public String getAid() {
        return aid;
    }

    public String getText() {
        return text;
    }

    public String getCreate() {
        create = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return date.format(create);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "cid='" + cid + '\'' +
                ", uid='" + uid + '\'' +
                ", aid='" + aid + '\'' +
                ", text='" + text + '\'' +
                ", create=" + create +
                '}';
    }
}
