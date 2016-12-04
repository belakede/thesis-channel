package me.belakede.thesis.server.game.response;

import me.belakede.thesis.game.equipment.PairOfDice;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class PairOfDiceNotification implements Notification, Serializable {
    private static final long serialVersionUID = -4632478208261689890L;

    @XmlElement
    private int first;
    @XmlElement
    private int second;

    public PairOfDiceNotification() {
        // It's required for an entity
    }

    public PairOfDiceNotification(PairOfDice pairOfDice) {
        this(pairOfDice.getFirst(), pairOfDice.getSecond());
    }

    public PairOfDiceNotification(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PairOfDiceNotification that = (PairOfDiceNotification) o;

        return first == that.first && second == that.second;
    }

    @Override
    public int hashCode() {
        int result = first;
        result = 31 * result + second;
        return result;
    }

}
