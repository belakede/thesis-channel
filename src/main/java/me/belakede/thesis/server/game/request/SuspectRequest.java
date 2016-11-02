package me.belakede.thesis.server.game.request;

import me.belakede.thesis.game.equipment.Room;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.game.equipment.Weapon;
import me.belakede.thesis.server.Suspicion;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class SuspectRequest extends Suspicion implements Serializable {
    private static final long serialVersionUID = 5875524183481559435L;

    public SuspectRequest() {
        // It's required for an entity
    }

    public SuspectRequest(me.belakede.thesis.game.equipment.Suspicion suspicion) {
        super(suspicion);
    }

    public SuspectRequest(Suspect suspect, Room room, Weapon weapon) {
        super(suspect, room, weapon);
    }

}
