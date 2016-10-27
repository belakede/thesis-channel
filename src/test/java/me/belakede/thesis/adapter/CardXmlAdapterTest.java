package me.belakede.thesis.adapter;

import me.belakede.thesis.game.equipment.Card;
import me.belakede.thesis.game.equipment.Room;
import me.belakede.thesis.game.equipment.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class CardXmlAdapterTest {

    private CardXmlAdapter testSubject;

    @Before
    public void setUp() throws Exception {
        testSubject = new CardXmlAdapter();
    }

    @Test
    public void testMarshalShouldReturnWithTheCardAsString() throws Exception {
        String actual = testSubject.marshal(Room.DINING_ROOM);
        assertThat(actual, is(Room.DINING_ROOM.name()));
    }

    @Test
    public void testUnmarshalShouldReturnWithTheLocalDateTime() throws Exception {
        Card actual = testSubject.unmarshal(Weapon.ROPE.name());
        assertThat(actual, is(Weapon.ROPE));
    }

    @Test(expected = Exception.class)
    public void testUnmarshalShouldThrownExceptionWhenCardNotFound() throws Exception {
        Card actual = testSubject.unmarshal("undefined card");
    }

}