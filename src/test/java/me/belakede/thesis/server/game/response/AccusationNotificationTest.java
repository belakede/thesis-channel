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
public class AccusationNotificationTest {

    public static final class AccusationNotificationEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public AccusationNotificationEqualsHashCodeTest(String name) {
            super(name, AccusationNotification.class, Arrays.asList("suspect", "room", "weapon"));
        }

        @Override
        protected AccusationNotification createInstance() throws Exception {
            return new AccusationNotification(Suspect.SCARLET, Room.WORKROOM, Weapon.WRENCH);
        }

        @Override
        protected AccusationNotification createNotEqualInstance() throws Exception {
            return new AccusationNotification(Suspect.PEACOCK, Room.LIBRARY, Weapon.CANDLESTICK);
        }
    }

    public static final class AccusationNotificationPojoTest extends PojoClassTestCase {

        public AccusationNotificationPojoTest(String name) {
            super(name, AccusationNotification.class);
        }
    }


}