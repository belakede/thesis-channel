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
public class SuggestionTest {

    public static final class SuggestionEqualsAndHashCodeTest extends ExtendedEqualsHashCodeTestCase {
        public SuggestionEqualsAndHashCodeTest(String name) {
            super(name, Suggestion.class, Arrays.asList("suspect", "room", "weapon"));
        }

        @Override
        protected Suggestion createInstance() throws Exception {
            return new Suggestion(Suspect.SCARLET, Room.HALL, Weapon.REVOLVER);
        }

        @Override
        protected Suggestion createNotEqualInstance() throws Exception {
            return new Suggestion(new DefaultSuspicion(Suspect.MUSTARD, Room.BALLROOM, Weapon.REVOLVER));
        }
    }

    public static final class SuggestionPojoTest extends PojoClassTestCase {
        public SuggestionPojoTest(String name) {
            super(name, Suggestion.class);
        }
    }


}