package me.belakede.thesis.server.game.response;

import me.belakede.thesis.game.equipment.BoardType;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.game.equipment.Weapon;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Map;

@XmlRootElement
public class BoardNotification implements Serializable {
    private static final long serialVersionUID = 7184283344433343450L;

    @XmlElement
    private BoardType boardType;
    @XmlElement
    private Map<Suspect, Coordinate> suspectPositions;
    @XmlElement
    private Map<Weapon, Coordinate> weaponPositions;

    public BoardNotification() {
        // It's required for an entity
    }

    public BoardNotification(BoardType boardType, Map<Suspect, Coordinate> suspectPositions, Map<Weapon, Coordinate> weaponPositions) {
        this.boardType = boardType;
        this.suspectPositions = suspectPositions;
        this.weaponPositions = weaponPositions;
    }

    public BoardType getBoardType() {
        return boardType;
    }

    public void setBoardType(BoardType boardType) {
        this.boardType = boardType;
    }

    public Map<Suspect, Coordinate> getSuspectPositions() {
        return suspectPositions;
    }

    public void setSuspectPositions(Map<Suspect, Coordinate> suspectPositions) {
        this.suspectPositions = suspectPositions;
    }

    public Map<Weapon, Coordinate> getWeaponPositions() {
        return weaponPositions;
    }

    public void setWeaponPositions(Map<Weapon, Coordinate> weaponPositions) {
        this.weaponPositions = weaponPositions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoardNotification that = (BoardNotification) o;

        return (boardType == that.boardType)
                && (suspectPositions != null ? suspectPositions.equals(that.suspectPositions) : that.suspectPositions == null)
                && (weaponPositions != null ? weaponPositions.equals(that.weaponPositions) : that.weaponPositions == null);
    }

    @Override
    public int hashCode() {
        int result = boardType != null ? boardType.hashCode() : 0;
        result = 31 * result + (suspectPositions != null ? suspectPositions.hashCode() : 0);
        result = 31 * result + (weaponPositions != null ? weaponPositions.hashCode() : 0);
        return result;
    }
}
