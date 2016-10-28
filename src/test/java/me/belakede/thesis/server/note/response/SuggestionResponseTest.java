package me.belakede.thesis.server.note.response;

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
public class SuggestionResponseTest {

    public static final class SuggestionResponseEqualsAndHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public SuggestionResponseEqualsAndHashCodeTest(String name) {
            super(name, SuggestionResponse.class, Arrays.asList("suspect", "room", "weapon"));
        }

        @Override
        protected SuggestionResponse createInstance() throws Exception {
            return new SuggestionResponse(new DefaultSuspicion(Suspect.SCARLET, Room.HALL, Weapon.REVOLVER));
        }

        @Override
        protected SuggestionResponse createNotEqualInstance() throws Exception {
            return new SuggestionResponse(new DefaultSuspicion(Suspect.MUSTARD, Room.BALLROOM, Weapon.REVOLVER));
        }
    }

    public static final class SuggestionResponsePojoTest extends PojoClassTestCase {

        public SuggestionResponsePojoTest(String name) {
            super(name, SuggestionResponse.class);
        }
    }
    
}