package me.belakede.thesis.server.note.request;

import me.belakede.thesis.game.equipment.Marker;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(Enclosed.class)
public class NoteRequestTest {

    public static final class NoteRequestEqualsAndHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public NoteRequestEqualsAndHashCodeTest(String name) {
            super(name, NoteRequest.class, Arrays.asList("room", "card", "owner", "marker"));
        }

        @Override
        protected NoteRequest createInstance() throws Exception {
            return new NoteRequest("room", Suspect.MUSTARD, "demouser", Marker.NONE);
        }

        @Override
        protected NoteRequest createNotEqualInstance() throws Exception {
            return new NoteRequest("room", Suspect.PLUM, "demouser", Marker.NONE);
        }
    }

    public static final class NoteRequestPojoTest extends PojoClassTestCase {

        public NoteRequestPojoTest(String name) {
            super(name, NoteRequest.class);
        }
    }

}