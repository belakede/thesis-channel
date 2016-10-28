package me.belakede.thesis.server.note;

import me.belakede.thesis.game.equipment.Room;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.game.equipment.Weapon;
import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class SuggestionTest {

    public static final class SuggestionEqualsAndHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public SuggestionEqualsAndHashCodeTest(String name) {
            super(name, Suggestion.class, Arrays.asList("suspect", "room", "weapon"));
        }

        @Override
        protected Suggestion createInstance() throws Exception {
            return new Suggestion(Suspect.PLUM, Room.LIBRARY, Weapon.ROPE);
        }

        @Override
        protected Suggestion createNotEqualInstance() throws Exception {
            return new Suggestion(Suspect.MUSTARD, Room.LIBRARY, Weapon.ROPE);
        }
    }

    public static final class SuggestionPojoTest extends PojoClassTestCase {

        public SuggestionPojoTest(String name) {
            super(name, Suggestion.class);
        }
    }
    
}