package me.belakede.thesis.server.note.response;

import me.belakede.thesis.game.equipment.Room;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.game.equipment.Suspicion;
import me.belakede.thesis.game.equipment.Weapon;
import me.belakede.thesis.server.Suggestion;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SuggestionResponse extends Suggestion {

    private static final long serialVersionUID = -1815793765631688612L;

    public SuggestionResponse() {
        // It's necessary for an entity
    }

    public SuggestionResponse(Suspicion suspicion) {
        super(suspicion);
    }

    public SuggestionResponse(Suspect suspect, Room room, Weapon weapon) {
        super(suspect, room, weapon);
    }

}
