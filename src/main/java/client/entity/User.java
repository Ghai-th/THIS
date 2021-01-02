package client.entity;

import java.util.Arrays;
import java.util.Date;

/**
 * 用户实体类
 */
public class User {
    private String uid;
    private String name;
    private Integer level;
    private String password;
    private Integer gender;
    private Byte[] image;
    private Integer fansNum;
    private Integer attentionNum;
    private Integer visitorNum;
    private Integer articleNum;
    private Date create;
    private Date update;
    private String synopsis;
    private Integer active;

    public User(String uid, String name, Integer level, String password, Integer gender, Byte[] image,
                Integer fansNum, Integer attentionNum, Integer visitorNum, Integer articleNum, String synopsis, Integer active) {
        this.uid = uid;
        this.name = name;
        this.level = level;
        this.password = password;
        this.gender = gender;
        this.image = image;
        this.fansNum = fansNum;
        this.attentionNum = attentionNum;
        this.visitorNum = visitorNum;
        this.articleNum = articleNum;
        this.create = new Date();
        this.update = new Date();
        this.synopsis = synopsis;
        this.active = active;
    }

    public User() {
    }

    public static void initUser(User user) {
        user.setArticleNum(1);
        user.setAttentionNum(1);
        user.setFansNum(1);
        user.setGender(1);
        user.setImage(null);
        user.setLevel(1);
        user.setName("monkey");
        user.setSynopsis("ohhh");
        user.setUid("1001");
        user.setPassword("123");
        user.setVisitorNum(1);
        user.setActive(1);
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Integer getFansNum() {
        return fansNum;
    }

    public void setFansNum(Integer fansNum) {
        this.fansNum = fansNum;
    }

    public Integer getAttentionNum() {
        return attentionNum;
    }

    public void setAttentionNum(Integer attentionNum) {
        this.attentionNum = attentionNum;
    }

    public Integer getVisitorNum() {
        return visitorNum;
    }

    public void setVisitorNum(Integer visitorNum) {
        this.visitorNum = visitorNum;
    }

    public Integer getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(Integer articleNum) {
        this.articleNum = articleNum;
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

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", image=" + Arrays.toString(image) +
                ", fansNum=" + fansNum +
                ", attentionNum=" + attentionNum +
                ", visitorNum=" + visitorNum +
                ", articleNum=" + articleNum +
                ", create=" + create +
                ", update=" + update +
                ", synopsis='" + synopsis + '\'' +
                '}';
    }
}
