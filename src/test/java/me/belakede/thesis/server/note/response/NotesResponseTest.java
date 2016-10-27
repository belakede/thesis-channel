package me.belakede.thesis.server.note.response;

import me.belakede.thesis.game.equipment.Marker;
import me.belakede.thesis.game.equipment.Room;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.game.equipment.Weapon;
import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RunWith(Enclosed.class)
public class NotesResponseTest {

    public static final class NotesResponseEqualsAndHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public NotesResponseEqualsAndHashCodeTest(String name) {
            super(name, NotesResponse.class, Arrays.asList("notes"));
        }

        @Override
        protected NotesResponse createInstance() throws Exception {
            Set<NoteResponse> notes = new HashSet<>(Arrays.asList(
                    new NoteResponse(Suspect.PEACOCK, "demouser", Marker.QUESTION),
                    new NoteResponse(Room.BATHROOM, "demouser", Marker.YES),
                    new NoteResponse(Weapon.WRENCH, "admin", Marker.MAYBE_NOT)));
            return new NotesResponse(notes);
        }

        @Override
        protected NotesResponse createNotEqualInstance() throws Exception {
            Set<NoteResponse> notes = new HashSet<>(Arrays.asList(
                    new NoteResponse(Suspect.MUSTARD, "demouser", Marker.QUESTION),
                    new NoteResponse(Room.BATHROOM, "demouser", Marker.YES),
                    new NoteResponse(Weapon.WRENCH, "admin", Marker.MAYBE_NOT)));
            return new NotesResponse(notes);
        }
    }

    public static final class NotesResponsePojoTest extends PojoClassTestCase {

        public NotesResponsePojoTest(String name) {
            super(name, NotesResponse.class);
        }
    }

}