package me.belakede.thesis.server.game.response;

import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.game.equipment.Weapon;
import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Collections;

@RunWith(Enclosed.class)
public class FigurineNotificationTest {

    public static final class FigurineNotificationEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {
        public FigurineNotificationEqualsHashCodeTest(String name) {
            super(name, FigurineNotification.class, Collections.emptyList());
        }

        @Override
        protected FigurineNotification createInstance() throws Exception {
            return new FigurineNotification(Suspect.MUSTARD, new Coordinate(12, 22));
        }

        @Override
        protected FigurineNotification createNotEqualInstance() throws Exception {
            return new FigurineNotification(Weapon.CANDLESTICK, new Coordinate(32, 1));
        }
    }

    public static final class FigurineNotificationPojoTest extends PojoClassTestCase {
        public FigurineNotificationPojoTest(String name) {
            super(name, FigurineNotification.class);
        }
    }

}