package model;

public class Chatlist {
    String id;
    Long timestamp;

    public Chatlist(){}

    public Chatlist(String id) {
        this.id=id;
    }

    public Chatlist(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
