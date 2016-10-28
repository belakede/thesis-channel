package me.belakede.thesis.server.note.request;

import me.belakede.thesis.game.equipment.Suspicion;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class SuggestionRequest implements Serializable {

    private static final long serialVersionUID = -4428897375669104919L;

    @XmlElement(required = true)
    private String room;
    @XmlElement
    private Suspicion suspicion;

    public SuggestionRequest() {
        // It's necessary for an entity
    }

    public SuggestionRequest(String room) {
        this.room = room;
    }

    public SuggestionRequest(String room, Suspicion suspicion) {
        this.room = room;
        this.suspicion = suspicion;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Suspicion getSuspicion() {
        return suspicion;
    }

    public void setSuspicion(Suspicion suspicion) {
        this.suspicion = suspicion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SuggestionRequest that = (SuggestionRequest) o;

        return (room != null ? room.equals(that.room) : that.room == null)
                && (suspicion != null ? suspicion.equals(that.suspicion) : that.suspicion == null);
    }

    @Override
    public int hashCode() {
        int result = room != null ? room.hashCode() : 0;
        result = 31 * result + (suspicion != null ? suspicion.hashCode() : 0);
        return result;
    }
}
