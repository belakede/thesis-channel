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
import java.util.Collection;

@RunWith(Enclosed.class)
public class PlayerStatusNotificationTest {

    public static final class PlayerStatusNotificationEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {
        public PlayerStatusNotificationEqualsHashCodeTest(String name) {
            super(name, PlayerStatusNotification.class, Arrays.asList("figurine", "cards"));
        }

        @Override
        protected PlayerStatusNotification createInstance() throws Exception {
            return new PlayerStatusNotification(Suspect.PLUM, Arrays.asList(Suspect.MUSTARD.name(), Weapon.KNIFE.name(), Room.HALL.name()));
        }

        @Override
        protected PlayerStatusNotification createNotEqualInstance() throws Exception {
            return new PlayerStatusNotification(Suspect.SCARLET, Arrays.asList(Suspect.PLUM.name(), Weapon.CANDLESTICK.name()));
        }
    }

    public static final class PlayerStatusNotificationPojoTest extends PojoClassTestCase {
        public PlayerStatusNotificationPojoTest(String name) {
            super(name, PlayerStatusNotification.class);
        }
    }

    public static final class PlayerStatusNotificationJacksonTest extends JacksonSerializationTestCase<Notification> {
        public PlayerStatusNotificationJacksonTest(String name) {
            super(name);
        }

        @Override
        public Notification expectedObject() {
            return new PlayerStatusNotification(Suspect.PLUM, Arrays.asList(Suspect.MUSTARD.name(), Weapon.KNIFE.name(), Room.HALL.name()));
        }

        @Override
        public String expectedJson() {
            return "{\"type\":\"player_status\",\"figurine\":\"PLUM\",\"cards\":[\"KNIFE\",\"HALL\",\"MUSTARD\"],\"alive\":true}";
        }

        @Override
        public Collection<String> jsonContains() {
            return Arrays.asList(
                    "\"type\":\"player_status\"",
                    "\"figurine\":\"PLUM\"",
                    "\"cards\":[",
                    "\"KNIFE\"",
                    "\"HALL\"",
                    "\"MUSTARD\"",
                    "\"alive\":true"
            );
        }
    }

}