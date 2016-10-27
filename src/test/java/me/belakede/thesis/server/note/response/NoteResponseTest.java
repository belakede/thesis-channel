package me.belakede.thesis.server.note.response;

import me.belakede.thesis.game.equipment.Marker;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.game.equipment.Weapon;
import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(Enclosed.class)
public class NoteResponseTest {

    public static final class NoteResponseEqualsAndHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public NoteResponseEqualsAndHashCodeTest(String name) {
            super(name, NoteResponse.class, Arrays.asList("card", "owner", "marker"));
        }

        @Override
        protected NoteResponse createInstance() throws Exception {
            return new NoteResponse(Suspect.PEACOCK, "demouser", Marker.QUESTION);
        }

        @Override
        protected NoteResponse createNotEqualInstance() throws Exception {
            return new NoteResponse(Weapon.KNIFE, "demouser", Marker.MAYBE);
        }
    }

    public static final class NoteResponsePojoTest extends PojoClassTestCase {

        public NoteResponsePojoTest(String name) {
            super(name, NoteResponse.class);
        }
    }

}