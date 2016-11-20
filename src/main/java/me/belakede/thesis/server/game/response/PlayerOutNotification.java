package me.belakede.thesis.server.game.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import me.belakede.thesis.game.equipment.Card;
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
public class PlayerOutNotification implements Notification, Serializable {
    private static final long serialVersionUID = 4104551565692370568L;

    @XmlElement
    private String user;
    @XmlElement
    private Set<String> cards;

    public PlayerOutNotification() {
        // It's required for an entity
    }

    public PlayerOutNotification(String user, Collection<String> cards) {
        this.user = user;
        this.cards = new HashSet<>(cards);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PlayerOutNotification that = (PlayerOutNotification) o;

        return (user != null ? user.equals(that.user) : that.user == null)
                && (cards != null ? cards.equals(that.cards) : that.cards == null);
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (cards != null ? cards.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s kiesett a játékból. Kártyái: %s", user, cards);
    }
}
