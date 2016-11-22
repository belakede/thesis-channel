package me.belakede.thesis.server.game.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class GameEndedNotification implements Notification, Serializable {
    private static final long serialVersionUID = -5081744921448488783L;

    @XmlElement
    private String winner;

    public GameEndedNotification() {
        // It's required for an entity
    }

    public GameEndedNotification(String winner) {
        this.winner = winner;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GameEndedNotification that = (GameEndedNotification) o;

        return winner != null ? winner.equals(that.winner) : that.winner == null;
    }

    @Override
    public int hashCode() {
        return winner != null ? winner.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "A játék véget ért. " + winner + " a győztes.";
    }
}
