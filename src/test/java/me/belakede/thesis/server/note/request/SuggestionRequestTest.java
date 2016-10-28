package me.belakede.thesis.server.note.request;

import me.belakede.thesis.game.equipment.Room;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.game.equipment.Weapon;
import me.belakede.thesis.internal.game.equipment.DefaultSuspicion;
import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class SuggestionRequestTest {

    public static final class SuggestionRequestEqualsAndHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public SuggestionRequestEqualsAndHashCodeTest(String name) {
            super(name, SuggestionRequest.class, Arrays.asList("room", "suggestion"));
        }

        @Override
        protected SuggestionRequest createInstance() throws Exception {
            return new SuggestionRequest("room", new DefaultSuspicion(Suspect.PLUM, Room.LIBRARY, Weapon.ROPE));
        }

        @Override
        protected SuggestionRequest createNotEqualInstance() throws Exception {
            return new SuggestionRequest("room", new DefaultSuspicion(Suspect.MUSTARD, Room.LIBRARY, Weapon.ROPE));
        }
    }

    public static final class SuggestionRequestPojoTest extends PojoClassTestCase {

        public SuggestionRequestPojoTest(String name) {
            super(name, SuggestionRequest.class);
        }
    }
    
}