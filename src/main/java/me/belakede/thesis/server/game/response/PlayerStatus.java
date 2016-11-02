package me.belakede.thesis.server.game.response;

import me.belakede.thesis.game.equipment.Suspect;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement
public class PlayerStatus implements Serializable {
    private static final long serialVersionUID = 4496164386972802178L;

    @XmlElement
    private Suspect figurine;
    @XmlElement
    private Set<String> cards;
    @XmlElement
    private boolean alive;

    public PlayerStatus() {
        // It's required for an entity
    }

    public PlayerStatus(Suspect figurine, Collection<String> cards) {
        this(figurine, cards, true);
    }

    public PlayerStatus(Suspect figurine, Collection<String> cards, boolean alive) {
        this.figurine = figurine;
        this.cards = new HashSet<>(cards);
        this.alive = alive;
    }

    public Suspect getFigurine() {
        return figurine;
    }

    public void setFigurine(Suspect figurine) {
        this.figurine = figurine;
    }

    public Set<String> getCards() {
        return cards;
    }

    public void setCards(Set<String> cards) {
        this.cards = cards;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PlayerStatus that = (PlayerStatus) o;

        return (alive == that.alive)
                && (figurine == that.figurine)
                && (cards != null ? cards.equals(that.cards) : that.cards == null);
    }

    @Override
    public int hashCode() {
        int result = figurine != null ? figurine.hashCode() : 0;
        result = 31 * result + (cards != null ? cards.hashCode() : 0);
        result = 31 * result + (alive ? 1 : 0);
        return result;
    }
}
