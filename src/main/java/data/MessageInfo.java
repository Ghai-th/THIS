package data;

import client.entity.Message;

import javax.xml.crypto.Data;

public class MessageInfo implements java.io.Serializable {
    public Message message;
    public Data data;

    public MessageInfo(Message message, Data data) {
        this.message = message;
        this.data = data;
    }

    public MessageInfo() {
    }
}
