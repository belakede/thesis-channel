package me.belakede.thesis.server.game.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class PlayerJoinedNotification implements Notification, Serializable {
    private static final long serialVersionUID = -3885951029953437640L;

    @XmlElement
    private String user;

    public PlayerJoinedNotification() {
        // It's required for an entity
    }

    public PlayerJoinedNotification(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PlayerJoinedNotification that = (PlayerJoinedNotification) o;

        return user != null ? user.equals(that.user) : that.user == null;
    }

    @Override
    public int hashCode() {
        return user != null ? user.hashCode() : 0;
    }
}
