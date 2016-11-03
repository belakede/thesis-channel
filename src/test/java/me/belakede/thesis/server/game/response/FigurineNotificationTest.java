package me.belakede.thesis.server.game.response;

import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.game.equipment.Weapon;
import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.JacksonSerializationTestCase;
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

    public static final class FigurineNotificationJacksonTestWithSuspect extends JacksonSerializationTestCase<Notification> {
        public FigurineNotificationJacksonTestWithSuspect(String name) {
            super(name);
        }

        @Override
        public Notification expectedObject() {
            return new FigurineNotification(Suspect.WHITE, new Coordinate(1, 10));
        }

        @Override
        public String expectedJson() {
            return "{\"type\":\"figurine\",\"suspect\":\"WHITE\",\"weapon\":null,\"position\":{\"row\":1,\"column\":10}}";
        }
    }

    public static final class FigurineNotificationJacksonTestWithWeapon extends JacksonSerializationTestCase<Notification> {
        public FigurineNotificationJacksonTestWithWeapon(String name) {
            super(name);
        }

        @Override
        public Notification expectedObject() {
            return new FigurineNotification(Weapon.KNIFE, new Coordinate(10, 10));
        }

        @Override
        public String expectedJson() {
            return "{\"type\":\"figurine\",\"suspect\":null,\"weapon\":\"KNIFE\",\"position\":{\"row\":10,\"column\":10}}";
        }
    }

}