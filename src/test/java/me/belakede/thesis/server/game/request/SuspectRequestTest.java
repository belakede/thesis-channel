package me.belakede.thesis.server.game.request;

import me.belakede.thesis.game.equipment.Room;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.game.equipment.Weapon;
import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(Enclosed.class)
public class SuspectRequestTest {

    public static final class SuspectRequestEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public SuspectRequestEqualsHashCodeTest(String name) {
            super(name, SuspectRequest.class, Arrays.asList("suspect", "room", "weapon"));
        }

        @Override
        protected SuspectRequest createInstance() throws Exception {
            return new SuspectRequest(Suspect.MUSTARD, Room.BILLIARD_ROOM, Weapon.ROPE);
        }

        @Override
        protected SuspectRequest createNotEqualInstance() throws Exception {
            return new SuspectRequest(Suspect.WHITE, Room.WORKROOM, Weapon.LEAD_PIPE);
        }
    }

    public static final class SuspectRequestPojoTest extends PojoClassTestCase {

        public SuspectRequestPojoTest(String name) {
            super(name, SuspectRequest.class);
        }
    }

}