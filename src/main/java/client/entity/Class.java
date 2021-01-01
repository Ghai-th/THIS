package client.entity;

/**
 * 分类实体类
 */
public class Class {
    private String name;
    private String cid;
    private String synopsis;

    public Class(String name, String cid, String synopsis) {
        this.name = name;
        this.cid = cid;
        this.synopsis = synopsis;
    }

    public Class() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public String toString() {
        return "Class{" +
                "name='" + name + '\'' +
                ", cid='" + cid + '\'' +
                ", synopsis='" + synopsis + '\'' +
                '}';
    }
}
