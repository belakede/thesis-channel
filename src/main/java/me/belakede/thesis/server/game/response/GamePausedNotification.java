package me.belakede.thesis.server.game.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class GamePausedNotification implements Notification, Serializable {
    private static final long serialVersionUID = 7566695907673683334L;

    @XmlElement
    private String message;

    public GamePausedNotification() {
        // It's required for an entity
    }

    public GamePausedNotification(String message) {
        this.message = message;
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

        GamePausedNotification that = (GamePausedNotification) o;

        return message != null ? message.equals(that.message) : that.message == null;

    }

    @Override
    public int hashCode() {
        return message != null ? message.hashCode() : 0;
    }
}
