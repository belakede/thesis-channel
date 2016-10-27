package me.belakede.thesis.server.chat.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class ChatRequest implements Serializable {

    private static final long serialVersionUID = -928862881619557611L;

    @XmlElement(required = true)
    private String room;
    @XmlElement
    private String message;

    public ChatRequest() {
    }

    public ChatRequest(String room) {
        this.room = room;
    }

    public ChatRequest(String room, String message) {
        this.room = room;
        this.message = message;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ChatRequest that = (ChatRequest) o;

        return (room != null ? room.equals(that.room) : that.room == null)
                && (message != null ? message.equals(that.message) : that.message == null);
    }

    @Override
    public int hashCode() {
        int result = room != null ? room.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }
}
