package me.belakede.thesis.server.note.request;

import me.belakede.thesis.game.equipment.Room;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.game.equipment.Suspicion;
import me.belakede.thesis.game.equipment.Weapon;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class SuggestionRequest implements Serializable {

    private static final long serialVersionUID = -4428897375669104919L;

    @XmlElement
    private Suspect suspect;
    @XmlElement
    private Room room;
    @XmlElement
    private Weapon weapon;

    public SuggestionRequest() {
        // It's necessary for an entity
    }

    public SuggestionRequest(Suspicion suspicion) {
        this(suspicion.getSuspect(), suspicion.getRoom(), suspicion.getWeapon());
    }

    public SuggestionRequest(Suspect suspect, Room room1, Weapon weapon) {
        this.suspect = suspect;
        this.room = room1;
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

        SuggestionRequest that = (SuggestionRequest) o;

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
