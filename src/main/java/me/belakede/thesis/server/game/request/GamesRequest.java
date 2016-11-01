package me.belakede.thesis.server.game.request;

import me.belakede.thesis.game.equipment.BoardType;
import me.belakede.thesis.server.game.Games;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

@XmlRootElement
public class GamesRequest extends Games implements Serializable {
    private static final long serialVersionUID = 7386986036400206269L;

    public GamesRequest() {
        // It's required for an entity
    }

    public GamesRequest(BoardType boardType, List<String> users) {
        this.boardType = boardType;
        this.users = new HashSet<>(users);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GamesRequest that = (GamesRequest) o;

        return (users != null ? users.equals(that.users) : that.users == null)
                && boardType == that.boardType;
    }

    @Override
    public int hashCode() {
        int result = users != null ? users.hashCode() : 0;
        result = 31 * result + (boardType != null ? boardType.hashCode() : 0);
        return result;
    }
}
