package me.belakede.thesis.server.chat.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDateTime;

@XmlRootElement
public class Message implements Serializable {

    private static final long serialVersionUID = 5238112591052257140L;

    @XmlElement
    private String sender;
    @XmlElement
    private LocalDateTime time;
    @XmlElement
    private String content;

    public Message() {
        // It's required
    }

    public Message(String sender, String content) {
        this.sender = sender;
        this.content = content;
        this.time = LocalDateTime.now();
    }

    public Message(String sender, String content, LocalDateTime time) {
        this.sender = sender;
        this.content = content;
        this.time = time;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Message message = (Message) o;

        return (sender != null ? sender.equals(message.sender) : message.sender == null)
                && (time != null ? time.equals(message.time) : message.time == null)
                && (this.content != null ? this.content.equals(message.content) : message.content == null);
    }

    @Override
    public int hashCode() {
        int result = sender != null ? sender.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

}