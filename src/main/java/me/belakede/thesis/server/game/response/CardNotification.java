package me.belakede.thesis.server.game.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import me.belakede.thesis.game.equipment.Card;
import me.belakede.thesis.internal.game.util.Cards;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Optional;

@XmlRootElement
public class CardNotification implements Notification, Serializable {
    private static final long serialVersionUID = 8539454504018659788L;

    @XmlElement
    private String card;
    @XmlElement
    private boolean shown;

    public CardNotification() {
        // It's required for an entity
    }

    public CardNotification(String card) {
        this.card = card;
        this.shown = true;
    }

    public CardNotification(boolean shown) {
        this.shown = shown;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public boolean isShown() {
        return shown;
    }

    public void setShown(boolean shown) {
        this.shown = shown;
    }

    @JsonIgnore
    public Optional<Card> getCardValue() {
        return Cards.valueOf(card);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CardNotification that = (CardNotification) o;

        return (shown == that.shown)
                && (card != null ? card.equals(that.card) : that.card == null);
    }

    @Override
    public int hashCode() {
        int result = card != null ? card.hashCode() : 0;
        result = 31 * result + (shown ? 1 : 0);
        return result;
    }

}
