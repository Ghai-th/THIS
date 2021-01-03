package client.entity;



import data.Operate;

import java.util.Date;

public class Message extends Operate implements java.io.Serializable{

    private static final long serialVersionUID = 1111004L;

    private String sendId;
    private String acceptId;
    private String text;
    private Date time;
    private String state;

    public Message(String sendId, String acceptId, String text, String state) {
        this.sendId = sendId;
        this.acceptId = acceptId;
        this.text = text;
        this.state = state;
        this.time = new Date();
    }

    public Message(String acceptId){
        this.acceptId = acceptId;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
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
