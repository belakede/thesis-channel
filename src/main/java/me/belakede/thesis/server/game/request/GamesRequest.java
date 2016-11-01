package me.belakede.thesis.server.game.request;

import me.belakede.thesis.game.equipment.BoardType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@XmlRootElement
public class GamesRequest implements Serializable {
    private static final long serialVersionUID = 7386986036400206269L;

    @XmlElement(required = true)
    private Set<String> users;
    @XmlElement(required = true)
    private BoardType boardType;

    public GamesRequest() {
        // It's required for an entity
    }

    public GamesRequest(BoardType boardType, List<String> users) {
        this.boardType = boardType;
        this.users = new HashSet<>(users);
    }

    public Set<String> getUsers() {
        return users;
    }

    public void setUsers(Set<String> users) {
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
