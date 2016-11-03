package me.belakede.thesis.server.game.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class RoomNotification implements Notification, Serializable {
    private static final long serialVersionUID = -1931975148578791526L;

    @XmlElement
    private String room;

    public RoomNotification() {
        // It's required for an entity
    }

    public RoomNotification(String room) {
        this.room = room;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RoomNotification that = (RoomNotification) o;

        return room != null ? room.equals(that.room) : that.room == null;
    }

    @Override
    public int hashCode() {
        return room != null ? room.hashCode() : 0;
    }
}
