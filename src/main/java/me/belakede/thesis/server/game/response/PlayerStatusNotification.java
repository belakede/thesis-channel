package me.belakede.thesis.server.game.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import me.belakede.thesis.game.equipment.Card;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.internal.game.util.Cards;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@XmlRootElement
public class PlayerStatusNotification implements Notification, Serializable {
    private static final long serialVersionUID = 4496164386972802178L;

    @XmlElement
    private Suspect figurine;
    @XmlElement
    private Set<String> cards;
    @XmlElement
    private boolean alive;
    @XmlElement
    private Set<String> alreadyWaiting;

    public PlayerStatusNotification() {
        // It's required for an entity
    }

    public PlayerStatusNotification(Suspect figurine, Collection<String> cards) {
        this(figurine, cards, true);
    }

    public PlayerStatusNotification(Suspect figurine, Collection<String> cards, boolean alive) {
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

    @JsonIgnore
    public Set<Card> getCardSet() {
        return cards.stream()
                .map(Cards::valueOf)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Set<String> getAlreadyWaiting() {
        return alreadyWaiting;
    }

    public void setAlreadyWaiting(Set<String> alreadyWaiting) {
        this.alreadyWaiting = alreadyWaiting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PlayerStatusNotification that = (PlayerStatusNotification) o;

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
