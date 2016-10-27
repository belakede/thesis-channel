package me.belakede.thesis.adapter;

import me.belakede.thesis.game.equipment.Card;
import me.belakede.thesis.internal.game.util.Cards;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CardXmlAdapter extends XmlAdapter<String, Card> {
    @Override
    public Card unmarshal(String card) throws Exception {
        return Cards.valueOf(card).orElseThrow(() -> new Exception("Couldn't deserialize the specified card: " + card));
    }

    @Override
    public String marshal(Card card) throws Exception {
        return card.name();
    }

}