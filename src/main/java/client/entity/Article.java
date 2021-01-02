package client.entity;

import java.sql.Blob;
import java.util.Date;

/**
 * 文章实体类
 */
public class Article implements java.io.Serializable{
    private String aid;
    private String uid;
    private String cid;
    private String title;
    private String synopsis;
    private String text;
    private Date create;
    private Date renewal;
    private Integer visitorNum;
    private Integer likeNum;
    private Integer collectNum;
    private Blob image;

    public Article() {
    }

    public static Article initArticle() {
        String aid = "1";
        String uid = "1";
        String cid = "1";
        String tittle = "PHP是世界上最好的语言没有之一";
        String synopsis = "jk";
        String text = "java是世界上最好的语言";
        int visitorNum = 10;
        int likeNum = 10;
        int collect = 10;
        return new Article(aid, uid, cid, tittle, synopsis, text, visitorNum, likeNum, collect,null);
    }

    public Article(String aid, String uid, String cid, String tittle, String synopsis,
                   String text, int visitorNum, int likeNum, int collect, Blob image) {
        this.aid = aid;
        this.uid = uid;
        this.cid = cid;
        this.title = tittle;
        this.synopsis = synopsis;
        this.text = text;
        this.create = new Date();
        this.renewal = new Date();
        this.visitorNum = visitorNum;
        this.likeNum = likeNum;
        this.collectNum = collect;
        this.image = image;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public Date getRenewal() {
        return renewal;
    }

    public void setRenewal(Date renewal) {
        this.renewal = renewal;
    }

    public Integer getVisitorNum() {
        return visitorNum;
    }

    public void setVisitorNum(Integer visitorNum) {
        this.visitorNum = visitorNum;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public Blob getImage() {
        return  image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Article{" +
                "aid='" + aid + '\'' +
                ", uid='" + uid + '\'' +
                ", cid='" + cid + '\'' +
                ", tittle='" + title + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", text='" + text + '\'' +
                ", create=" + create +
                ", update=" + renewal +
                ", visitorNum=" + visitorNum +
                ", likeNum=" + likeNum +
                ", collect=" + collectNum +
                '}';
    }
}
