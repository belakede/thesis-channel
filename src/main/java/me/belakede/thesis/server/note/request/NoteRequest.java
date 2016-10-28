package me.belakede.thesis.server.note.request;


import me.belakede.thesis.game.equipment.Card;
import me.belakede.thesis.game.equipment.Marker;
import me.belakede.thesis.server.note.Note;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NoteRequest extends Note {

    private static final long serialVersionUID = 5125113855361171708L;

    @XmlElement(required = true)
    private String room;

    public NoteRequest() {
        // It's required for an entity
    }

    public NoteRequest(String room) {
        this.room = room;
    }

    public NoteRequest(String room, Card card, String owner, Marker marker) {
        this(room, card.name(), owner, marker);
    }

    public NoteRequest(String room, String card, String owner, Marker marker) {
        this.room = room;
        this.card = card;
        this.owner = owner;
        this.marker = marker;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        NoteRequest that = (NoteRequest) o;

        return (room != null ? room.equals(that.room) : that.room == null)
                && (card != null ? card.equals(that.card) : that.card == null)
                && (owner != null ? owner.equals(that.owner) : that.owner == null)
                && (marker == that.marker);
    }

    @Override
    public int hashCode() {
        int result = room != null ? room.hashCode() : 0;
        result = 31 * result + (card != null ? card.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (marker != null ? marker.hashCode() : 0);
        return result;
    }
}
