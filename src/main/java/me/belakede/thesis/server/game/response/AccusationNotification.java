package me.belakede.thesis.server.game.response;

import me.belakede.thesis.game.equipment.Room;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.game.equipment.Weapon;
import me.belakede.thesis.server.Suspicion;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class AccusationNotification extends Suspicion implements Serializable {
    private static final long serialVersionUID = -7253018293755865274L;

    public AccusationNotification() {
        // It's required for an entity
    }

    public AccusationNotification(me.belakede.thesis.game.equipment.Suspicion suspicion) {
        super(suspicion);
    }

    public AccusationNotification(Suspect suspect, Room room, Weapon weapon) {
        super(suspect, room, weapon);
    }
}
