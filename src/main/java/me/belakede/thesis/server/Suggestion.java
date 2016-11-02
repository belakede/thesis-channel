package me.belakede.thesis.server;

import me.belakede.thesis.game.equipment.Room;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.game.equipment.Suspicion;
import me.belakede.thesis.game.equipment.Weapon;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class Suggestion implements Serializable {

    private static final long serialVersionUID = 5910051487909316916L;

    @XmlElement
    protected Suspect suspect;
    @XmlElement
    protected Room room;
    @XmlElement
    protected Weapon weapon;

    public Suggestion() {
        // It's required for an entity
    }

    public Suggestion(Suspicion suspicion) {
        this(suspicion.getSuspect(), suspicion.getRoom(), suspicion.getWeapon());
    }

    public Suggestion(Suspect suspect, Room room, Weapon weapon) {
        this.suspect = suspect;
        this.room = room;
        this.weapon = weapon;
    }

    public Suspect getSuspect() {
        return suspect;
    }

    public void setSuspect(Suspect suspect) {
        this.suspect = suspect;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Suggestion that = (Suggestion) o;

        return suspect == that.suspect && room == that.room && weapon == that.weapon;
    }

    @Override
    public int hashCode() {
        int result = suspect != null ? suspect.hashCode() : 0;
        result = 31 * result + (room != null ? room.hashCode() : 0);
        result = 31 * result + (weapon != null ? weapon.hashCode() : 0);
        return result;
    }
}
