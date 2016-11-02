package me.belakede.thesis.server.game.response;

import me.belakede.thesis.game.equipment.Room;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.game.equipment.Weapon;
import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(Enclosed.class)
public class PlayerOutNotificationTest {

    public static final class PlayerOutNotificationEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public PlayerOutNotificationEqualsHashCodeTest(String name) {
            super(name, PlayerOutNotification.class, Arrays.asList("user", "cards"));
        }

        @Override
        protected PlayerOutNotification createInstance() throws Exception {
            return new PlayerOutNotification("admin", Arrays.asList(Suspect.GREEN.name(), Weapon.LEAD_PIPE.name(), Room.HALL.name()));
        }

        @Override
        protected PlayerOutNotification createNotEqualInstance() throws Exception {
            return new PlayerOutNotification("testuser", Arrays.asList(Suspect.MUSTARD.name(), Room.KITCHEN.name()));
        }
    }

    public static final class PlayerOutNotificationPojoTest extends PojoClassTestCase {

        public PlayerOutNotificationPojoTest(String name) {
            super(name, PlayerOutNotification.class);
        }
    }

}