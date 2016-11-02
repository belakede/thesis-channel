package me.belakede.thesis.server.game.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class CurrentPlayerNotification implements Notification, Serializable {
    private static final long serialVersionUID = 273668219223262763L;

    @XmlElement
    private String current;

    public CurrentPlayerNotification() {
        // It's required for an entity
    }

    public CurrentPlayerNotification(String current) {
        this.current = current;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CurrentPlayerNotification that = (CurrentPlayerNotification) o;

        return current != null ? current.equals(that.current) : that.current == null;
    }

    @Override
    public int hashCode() {
        return current != null ? current.hashCode() : 0;
    }
}
