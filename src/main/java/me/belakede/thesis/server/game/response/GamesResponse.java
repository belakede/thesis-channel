package me.belakede.thesis.server.game.response;

import me.belakede.thesis.game.equipment.BoardType;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.server.game.Games;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

@XmlRootElement
public class GamesResponse extends Games implements Serializable {
    private static final long serialVersionUID = 1528390809402026155L;

    @XmlElement
    private Long id;

    @XmlElement
    private String roomId;

    @XmlElement
    private LocalDateTime time;

    @XmlElement(required = true)
    private Map<Suspect, String> users;


    public GamesResponse() {
        // It's required for an entity
    }

    public GamesResponse(Long id, BoardType boardType, LocalDateTime time, Map<Suspect, String> users) {
        super(boardType);
        this.id = id;
        this.time = time;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Map<Suspect, String> getUsers() {
        return users;
    }

    public void setUsers(Map<Suspect, String> users) {
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

        GamesResponse that = (GamesResponse) o;

        return (id != null ? id.equals(that.id) : that.id == null)
                && (roomId != null ? roomId.equals(that.roomId) : that.roomId == null)
                && (time != null ? time.equals(that.time) : that.time == null)
                && (users != null ? users.equals(that.users) : that.users == null);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (roomId != null ? roomId.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (users != null ? users.hashCode() : 0);
        return result;
    }
}
