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
public class PlayerStatusTest {

    public static final class PlayerStatusEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public PlayerStatusEqualsHashCodeTest(String name) {
            super(name, PlayerStatus.class, Arrays.asList("figurine", "cards"));
        }

        @Override
        protected PlayerStatus createInstance() throws Exception {
            return new PlayerStatus(Suspect.PLUM, Arrays.asList(Suspect.MUSTARD.name(), Weapon.KNIFE.name(), Room.HALL.name()));
        }

        @Override
        protected PlayerStatus createNotEqualInstance() throws Exception {
            return new PlayerStatus(Suspect.SCARLET, Arrays.asList(Suspect.PLUM.name(), Weapon.CANDLESTICK.name()));
        }
    }

    public static final class PlayerStatusPojoTest extends PojoClassTestCase {

        public PlayerStatusPojoTest(String name) {
            super(name, PlayerStatus.class);
        }
    }

}