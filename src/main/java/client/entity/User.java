package client.entity;

import data.Operate;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Date;

/**
 * 用户实体类
 */
public class User extends Operate implements java.io.Serializable{

    private static final long serialVersionUID = 1111006L;

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
    private Date lastlogin;
    private String synopsis;
    private Integer active;
    private Integer mykey;

    public User(String uid, String name, Integer level, String password, Integer gender, Byte[] image,
                Integer fansNum, Integer attentionNum, Integer visitorNum, Integer articleNum, String synopsis,
                Integer active,Integer mykey) {
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
        this.lastlogin = new Date();
        this.synopsis = synopsis;
        this.active = active;
        this.mykey = mykey;
    }
    public User(String uid,String password){
        this.uid = uid;
        this.password = password;
        create = new Date();
    }
    public User(String uid, Integer mykey){
        this.uid = uid;
        this.mykey = mykey;
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
        user.setMyKey(1);
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

    public Date getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Date update) {
        this.lastlogin = update;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Integer getMyKey(){
        return mykey;
    }

    public void setMyKey(Integer mykey){
        this.mykey = mykey;
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
                ", lastlogin=" + lastlogin +
                ", synopsis='" + synopsis + '\'' +
                ", active=" + active +
                ", mykey='" + mykey + '\'' +
                '}';
    }
}
