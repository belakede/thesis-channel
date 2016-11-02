package me.belakede.thesis.server.game.request;

import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.game.equipment.Weapon;
import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(Enclosed.class)
public class ShowRequestTest {

    public static final class ShowRequestEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {
        public ShowRequestEqualsHashCodeTest(String name) {
            super(name, ShowRequest.class, Arrays.asList("card"));
        }

        @Override
        protected ShowRequest createInstance() throws Exception {
            return new ShowRequest(Suspect.MUSTARD.name());
        }

        @Override
        protected ShowRequest createNotEqualInstance() throws Exception {
            return new ShowRequest(Weapon.KNIFE.name());
        }
    }

    public static final class ShowRequestPojoTest extends PojoClassTestCase {
        public ShowRequestPojoTest(String name) {
            super(name, ShowRequest.class);
        }
    }

}