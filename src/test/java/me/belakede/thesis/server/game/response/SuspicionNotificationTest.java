package me.belakede.thesis.server.game.response;

import me.belakede.thesis.game.equipment.Room;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.game.equipment.Weapon;
import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.JacksonSerializationTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(Enclosed.class)
public class SuspicionNotificationTest {

    public static final class SuspicionNotificationEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {
        public SuspicionNotificationEqualsHashCodeTest(String name) {
            super(name, SuspicionNotification.class, Arrays.asList("suspect", "room", "weapon"));
        }

        @Override
        protected SuspicionNotification createInstance() throws Exception {
            return new SuspicionNotification(Suspect.GREEN, Room.BEDROOM, Weapon.LEAD_PIPE);
        }

        @Override
        protected SuspicionNotification createNotEqualInstance() throws Exception {
            return new SuspicionNotification(Suspect.MUSTARD, Room.KITCHEN, Weapon.KNIFE);
        }
    }

    public static final class SuspicionNotificationPojoTest extends PojoClassTestCase {
        public SuspicionNotificationPojoTest(String name) {
            super(name, SuspicionNotification.class);
        }
    }

    public static final class SuspicionNotificationJacksonTest extends JacksonSerializationTestCase<Notification> {
        public SuspicionNotificationJacksonTest(String name) {
            super(name);
        }

        @Override
        public Notification expectedObject() {
            return new SuspicionNotification(Suspect.WHITE, Room.BATHROOM, Weapon.ROPE);
        }

        @Override
        public String expectedJson() {
            return "{\"type\":\"suspicion\",\"suspect\":\"WHITE\",\"room\":\"BATHROOM\",\"weapon\":\"ROPE\"}";
        }
    }

}