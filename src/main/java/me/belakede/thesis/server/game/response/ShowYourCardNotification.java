package me.belakede.thesis.server.game.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@JsonDeserialize(as = Notification.class)
public class ShowYourCardNotification implements Notification, Serializable {
    private static final long serialVersionUID = 2281939501392619758L;

    @XmlElement
    private String message;

    public ShowYourCardNotification() {
    }

    public ShowYourCardNotification(String message) {
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

        ShowYourCardNotification that = (ShowYourCardNotification) o;

        return message != null ? message.equals(that.message) : that.message == null;
    }

    @Override
    public int hashCode() {
        return message != null ? message.hashCode() : 0;
    }
}
