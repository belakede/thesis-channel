package me.belakede.thesis.server.game;

import me.belakede.thesis.game.equipment.BoardType;
import me.belakede.thesis.game.equipment.Suspect;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement
public class Games implements Serializable {
    private static final long serialVersionUID = -283366408918520107L;

    @XmlElement(required = true)
    private Map<Suspect, String> users;

    @XmlElement(required = true)
    private BoardType boardType;

    public Games() {
        // It's required for an entity
    }

    public Games(BoardType boardType, Map<Suspect, String> users) {
        this.users = new HashMap<>(users);
        this.boardType = boardType;
    }

    public Map<Suspect, String> getUsers() {
        return users;
    }

    public void setUsers(Map<Suspect, String> users) {
        this.users = users;
    }

    public BoardType getBoardType() {
        return boardType;
    }

    public void setBoardType(BoardType boardType) {
        this.boardType = boardType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Games games = (Games) o;

        return (users != null ? users.equals(games.users) : games.users == null)
                && boardType == games.boardType;
    }

    @Override
    public int hashCode() {
        int result = users != null ? users.hashCode() : 0;
        result = 31 * result + (boardType != null ? boardType.hashCode() : 0);
        return result;
    }
}
