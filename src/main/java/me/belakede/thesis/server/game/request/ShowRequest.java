package me.belakede.thesis.server.game.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class ShowRequest implements Serializable {
    private static final long serialVersionUID = -2723455697137358115L;

    @XmlElement
    private String card;

    public ShowRequest() {
        // It's required for an entity
    }

    public ShowRequest(String card) {
        this.card = card;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ShowRequest that = (ShowRequest) o;

        return card != null ? card.equals(that.card) : that.card == null;
    }

    @Override
    public int hashCode() {
        return card != null ? card.hashCode() : 0;
    }
}
