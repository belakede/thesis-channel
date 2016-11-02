package me.belakede.thesis.server;

import me.belakede.thesis.game.equipment.Room;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.game.equipment.Weapon;
import me.belakede.thesis.internal.game.equipment.DefaultSuspicion;
import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(Enclosed.class)
public class SuspicionTest {

    public static final class SuspicionEqualsAndHashCodeTest extends ExtendedEqualsHashCodeTestCase {
        public SuspicionEqualsAndHashCodeTest(String name) {
            super(name, Suspicion.class, Arrays.asList("suspect", "room", "weapon"));
        }

        @Override
        protected Suspicion createInstance() throws Exception {
            return new Suspicion(Suspect.SCARLET, Room.HALL, Weapon.REVOLVER);
        }

        @Override
        protected Suspicion createNotEqualInstance() throws Exception {
            return new Suspicion(new DefaultSuspicion(Suspect.MUSTARD, Room.BALLROOM, Weapon.REVOLVER));
        }
    }

    public static final class SuspicionPojoTest extends PojoClassTestCase {
        public SuspicionPojoTest(String name) {
            super(name, Suspicion.class);
        }
    }


}