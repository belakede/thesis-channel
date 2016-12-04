package me.belakede.thesis.server.game.response;

import me.belakede.thesis.game.equipment.Suspect;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Map;

@XmlRootElement
public class GameStatusNotification implements Notification, Serializable {
    private static final long serialVersionUID = 9091401091544230573L;

    @XmlElement
    private BoardStatus boardStatus;
    @XmlElement
    private Map<Suspect, String> players;

    public GameStatusNotification() {
        // It's required for an entity
    }

    public GameStatusNotification(BoardStatus boardStatus, Map<Suspect, String> players) {
        this.boardStatus = boardStatus;
        this.players = players;
    }

    public BoardStatus getBoardStatus() {
        return boardStatus;
    }

    public void setBoardStatus(BoardStatus boardStatus) {
        this.boardStatus = boardStatus;
    }

    public Map<Suspect, String> getPlayers() {
        return players;
    }

    public void setPlayers(Map<Suspect, String> players) {
        this.players = players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GameStatusNotification that = (GameStatusNotification) o;

        return (boardStatus != null ? boardStatus.equals(that.boardStatus) : that.boardStatus == null)
                && (players != null ? players.equals(that.players) : that.players == null);
    }

    @Override
    public int hashCode() {
        int result = boardStatus != null ? boardStatus.hashCode() : 0;
        result = 31 * result + (players != null ? players.hashCode() : 0);
        return result;
    }

}
