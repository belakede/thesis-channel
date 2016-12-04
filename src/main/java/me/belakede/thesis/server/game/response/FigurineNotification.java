package me.belakede.thesis.server.game.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import me.belakede.thesis.game.equipment.Figurine;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.game.equipment.Weapon;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Optional;

@XmlRootElement
public class FigurineNotification implements Notification, Serializable {
    private static final long serialVersionUID = 5093964245423152907L;

    @XmlElement
    private Suspect suspect;
    @XmlElement
    private Weapon weapon;
    @XmlElement
    private Coordinate position;

    public FigurineNotification() {
        // It's required for an entity
    }

    public FigurineNotification(String figurine, Coordinate position) {
        try {
            this.suspect = Suspect.valueOf(figurine);
        } catch (Exception ex) {
            this.weapon = Weapon.valueOf(figurine);
        }
        this.position = position;
    }

    public FigurineNotification(Suspect suspect, Coordinate position) {
        this.suspect = suspect;
        this.position = position;
    }

    public FigurineNotification(Weapon weapon, Coordinate position) {
        this.weapon = weapon;
        this.position = position;
    }

    public Suspect getSuspect() {
        return suspect;
    }

    public void setSuspect(Suspect suspect) {
        this.suspect = suspect;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    @JsonIgnore
    public Figurine getFigurine() {
        return Optional.<Figurine>ofNullable(suspect).orElse(weapon);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FigurineNotification that = (FigurineNotification) o;

        return (suspect != null ? suspect.equals(that.suspect) : that.suspect == null)
                && (weapon != null ? weapon.equals(that.weapon) : that.weapon == null)
                && (position != null ? position.equals(that.position) : that.position == null);
    }

    @Override
    public int hashCode() {
        int result = suspect != null ? suspect.hashCode() : 0;
        result = 31 * result + (weapon != null ? weapon.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }

}
