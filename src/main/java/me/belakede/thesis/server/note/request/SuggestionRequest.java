package me.belakede.thesis.server.note.request;

import me.belakede.thesis.game.equipment.Room;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.game.equipment.Weapon;
import me.belakede.thesis.server.Suspicion;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SuggestionRequest extends Suspicion {

    private static final long serialVersionUID = -4428897375669104919L;

    public SuggestionRequest() {
        // It's necessary for an entity
    }

    public SuggestionRequest(me.belakede.thesis.game.equipment.Suspicion suspicion) {
        super(suspicion);
    }

    public SuggestionRequest(Suspect suspect, Room room, Weapon weapon) {
        super(suspect, room, weapon);
    }

}
