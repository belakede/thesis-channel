package me.belakede.thesis.server.note;

import me.belakede.thesis.game.equipment.Marker;
import me.belakede.thesis.game.equipment.Room;
import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(Enclosed.class)
public class NoteTest {

    public static final class NoteEqualsAndHashCodeTest extends ExtendedEqualsHashCodeTestCase {
        public NoteEqualsAndHashCodeTest(String name) {
            super(name, Note.class, Arrays.asList("card", "owner", "marker"));
        }

        @Override
        protected Note createInstance() throws Exception {
            return new Note(Room.BEDROOM, "demouser", Marker.QUESTION);
        }

        @Override
        protected Note createNotEqualInstance() throws Exception {
            return new Note("BEDROOM", "demouser", Marker.MAYBE_NOT);
        }
    }

    public static final class NotePojoTest extends PojoClassTestCase {
        public NotePojoTest(String name) {
            super(name, Note.class);
        }
    }

}