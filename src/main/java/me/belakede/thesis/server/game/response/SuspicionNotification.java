package me.belakede.thesis.server.game.response;

import me.belakede.thesis.game.equipment.Room;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.game.equipment.Weapon;
import me.belakede.thesis.server.Suspicion;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class SuspicionNotification extends Suspicion implements Notification, Serializable {
    private static final long serialVersionUID = -530663703588895110L;

    public SuspicionNotification() {
        // It's required for an entity
    }

    public SuspicionNotification(me.belakede.thesis.game.equipment.Suspicion suspicion) {
        super(suspicion);
    }

    public SuspicionNotification(Suspect suspect, Room room, Weapon weapon) {
        super(suspect, room, weapon);
    }

    @Override
    public String toString() {
        return "Ganyusítás. Gyanusított: " + suspect + ", tetthely: " + room + ", gyilkos fegyver: " + weapon + ".";
    }
}
