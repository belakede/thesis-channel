package me.belakede.thesis.server.game.response;

import me.belakede.thesis.game.equipment.Room;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.JacksonSerializationTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(Enclosed.class)
public class CardNotificationTest {

    public static final class CardNotificationEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {
        public CardNotificationEqualsHashCodeTest(String name) {
            super(name, CardNotification.class, Arrays.asList("card"));
        }

        @Override
        protected CardNotification createInstance() throws Exception {
            return new CardNotification(Room.BALLROOM.name());
        }

        @Override
        protected CardNotification createNotEqualInstance() throws Exception {
            return new CardNotification(true);
        }
    }

    public static final class CardNotificationPojoTest extends PojoClassTestCase {
        public CardNotificationPojoTest(String name) {
            super(name, CardNotification.class);
        }
    }

    public static final class CardNotificationJacksonTestWithCard extends JacksonSerializationTestCase<Notification> {
        public CardNotificationJacksonTestWithCard(String name) {
            super(name);
        }

        @Override
        public Notification expectedObject() {
            return new CardNotification(Suspect.PLUM.name());
        }

        @Override
        public String expectedJson() {
            return "{\"type\":\"card\",\"card\":\"PLUM\",\"shown\":true}";
        }
    }

    public static final class CardNotificationJacksonTestWithoutCard extends JacksonSerializationTestCase<Notification> {

        public CardNotificationJacksonTestWithoutCard(String name) {
            super(name);
        }

        @Override
        public Notification expectedObject() {
            return new CardNotification();
        }

        @Override
        public String expectedJson() {
            return "{\"type\":\"card\",\"card\":null,\"shown\":false}";
        }
    }

}