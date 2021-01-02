package client.entity;


import java.util.Date;

public class Message {
    private String sendId;
    private String acceptId;
    private String text;
    private Date time;
    private Boolean state;

    public Message(String sendId, String acceptId, String text, Boolean state) {
        this.sendId = sendId;
        this.acceptId = acceptId;
        this.text = text;
        this.state = state;
        this.time = new Date();
    }

    public Message() {
    }

    public String getSendId() {
        return sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public String getAcceptId() {
        return acceptId;
    }

    public void setAcceptId(String acceptId) {
        this.acceptId = acceptId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sendId='" + sendId + '\'' +
                ", acceptId='" + acceptId + '\'' +
                ", text='" + text + '\'' +
                ", time=" + time +
                ", state=" + state +
                '}';
    }
}
