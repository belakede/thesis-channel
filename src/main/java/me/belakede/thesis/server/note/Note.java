package me.belakede.thesis.server.note;

import me.belakede.thesis.game.equipment.Card;
import me.belakede.thesis.game.equipment.Marker;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class Note implements Serializable {

    private static final long serialVersionUID = -8656500815920815028L;

    @XmlElement
    protected String card;
    @XmlElement
    protected String owner;
    @XmlElement
    protected Marker marker;

    public Note() {
        // It's required for an entity
    }

    public Note(Card card, String owner, Marker marker) {
        this.card = card.name();
        this.owner = owner;
        this.marker = marker;
    }

    public Note(String card, String owner, Marker marker) {
        this.card = card;
        this.owner = owner;
        this.marker = marker;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Note note = (Note) o;

        return (card != null ? card.equals(note.card) : note.card == null)
                && (owner != null ? owner.equals(note.owner) : note.owner == null)
                && (marker == note.marker);
    }

    @Override
    public int hashCode() {
        int result = card != null ? card.hashCode() : 0;
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (marker != null ? marker.hashCode() : 0);
        return result;
    }
}
