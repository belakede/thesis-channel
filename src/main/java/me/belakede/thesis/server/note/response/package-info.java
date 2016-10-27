@XmlJavaTypeAdapters({
        @XmlJavaTypeAdapter(type = Card.class, value = CardXmlAdapter.class)
})
package me.belakede.thesis.server.note.response;

import me.belakede.thesis.adapter.CardXmlAdapter;
import me.belakede.thesis.game.equipment.Card;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;