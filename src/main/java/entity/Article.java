package entity;

import java.util.Date;

/**
 * 文章实体类
 */
public class Article {
    private String aid;
    private String uid;
    private String cid;
    private String title;
    private String synopsis;
    private String text;
    private Date create;
    private Date update;
    private Integer visitorNum;
    private Integer likeNum;
    private Integer collectNum;
    private Byte[] image;


    public Article() {
    }

    public static Article initArticle() {
        String aid = "1";
        String uid = "1";
        String cid = "1";
        String tittle = "PHP是世界上最好的语言没有之一";
        String synopsis = "jk";
        String text = "#include <stdio.h> int  main(){ int num; printf(\"please input a num\\n\");scanf(\"\",&num); while(num>10){";
        int visitorNum = 10;
        int likeNum = 10;
        int collect = 10;
        return new Article(aid, uid, cid, tittle, synopsis, text, visitorNum, likeNum, collect,null);
    }

    public Article(String aid, String uid, String cid, String tittle, String synopsis,
                   String text, int visitorNum, int likeNum, int collect, Byte[] image) {
        this.aid = aid;
        this.uid = uid;
        this.cid = cid;
        this.title = tittle;
        this.synopsis = synopsis;
        this.text = text;
        this.create = new Date();
        this.update = new Date();
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

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public int getVisitorNum() {
        return visitorNum;
    }

    public void setVisitorNum(int visitorNum) {
        this.visitorNum = visitorNum;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public int getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(int collectNum) {
        this.collectNum = collectNum;
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
                ", update=" + update +
                ", visitorNum=" + visitorNum +
                ", likeNum=" + likeNum +
                ", collect=" + collectNum +
                '}';
    }
}
