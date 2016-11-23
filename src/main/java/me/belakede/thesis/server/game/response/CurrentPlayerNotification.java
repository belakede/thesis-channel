package me.belakede.thesis.server.game.response;

import javafx.fxml.FXML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class CurrentPlayerNotification implements Notification, Serializable {
    private static final long serialVersionUID = 273668219223262763L;

    @XmlElement
    private String current;
    @FXML
    private String next;

    public CurrentPlayerNotification() {
        // It's required for an entity
    }

    public CurrentPlayerNotification(String current, String next) {
        this.current = current;
        this.next = next;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
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

        return (current != null ? current.equals(that.current) : that.current == null)
                && (next != null ? next.equals(that.next) : that.next == null);
    }

    @Override
    public int hashCode() {
        int result = current != null ? current.hashCode() : 0;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s köre kezdődik, %s felkészül", current, next);
    }
}
