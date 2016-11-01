package me.belakede.thesis.server.game;

import me.belakede.thesis.game.equipment.BoardType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement
public class Games implements Serializable {
    private static final long serialVersionUID = -283366408918520107L;

    @XmlElement(required = true)
    protected Set<String> users;

    @XmlElement(required = true)
    protected BoardType boardType;

    public Games() {
        // It's required for an entity
    }

    public Games(BoardType boardType, Collection<String> users) {
        this.users = new HashSet<>(users);
        this.boardType = boardType;
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
