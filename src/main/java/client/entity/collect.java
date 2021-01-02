package client.entity;

public class collect {
    private String uid;
    private String fansId;

    public collect() {
    }

    public collect(String uid, String fansId) {
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
