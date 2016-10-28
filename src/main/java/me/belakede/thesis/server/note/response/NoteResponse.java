package me.belakede.thesis.server.note.response;

import me.belakede.thesis.game.equipment.Card;
import me.belakede.thesis.game.equipment.Marker;
import me.belakede.thesis.server.note.Note;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NoteResponse extends Note {

    private static final long serialVersionUID = -2734850575924360317L;

    public NoteResponse() {
        // It's necessary for an entity
    }

    public NoteResponse(Card card, String owner, Marker marker) {
        super(card, owner, marker);
    }

    public NoteResponse(String card, String owner, Marker marker) {
        super(card, owner, marker);
    }

}
