package me.belakede.thesis.server.note.response;

import me.belakede.thesis.game.equipment.Card;
import me.belakede.thesis.game.equipment.Marker;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class NoteResponse implements Serializable {

    private static final long serialVersionUID = -2734850575924360317L;

    @XmlElement
    private Card card;
    @XmlElement
    private String owner;
    @XmlElement
    private Marker marker;

    public NoteResponse() {
        // It's necessary for an entity
    }

    public NoteResponse(Card card, String owner, Marker marker) {
        this.card = card;
        this.owner = owner;
        this.marker = marker;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
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

        NoteResponse that = (NoteResponse) o;

        return (card != null ? card.equals(that.card) : that.card == null)
                && (owner != null ? owner.equals(that.owner) : that.owner == null)
                && (marker == that.marker);
    }

    @Override
    public int hashCode() {
        int result = card != null ? card.hashCode() : 0;
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (marker != null ? marker.hashCode() : 0);
        return result;
    }
}
