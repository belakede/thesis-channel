package me.belakede.thesis.server.game.request;

import me.belakede.thesis.game.equipment.BoardType;
import me.belakede.thesis.server.game.Games;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@XmlRootElement
public class GamesRequest extends Games implements Serializable {
    private static final long serialVersionUID = 7386986036400206269L;

    private List<String> users;

    public GamesRequest() {
        // It's required for an entity
    }

    public GamesRequest(BoardType boardType, Collection<String> users) {
        super(boardType);
        this.users = new ArrayList<>(users);
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        GamesRequest that = (GamesRequest) o;

        return users != null ? users.equals(that.users) : that.users == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (users != null ? users.hashCode() : 0);
        return result;
    }
}
