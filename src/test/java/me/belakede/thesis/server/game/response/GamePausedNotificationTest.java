package me.belakede.thesis.server.game.response;

import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.JacksonSerializationTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(Enclosed.class)
public class GamePausedNotificationTest {

    public static final class GamePausedNotificationEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {
        public GamePausedNotificationEqualsHashCodeTest(String name) {
            super(name, GameEndedNotification.class, Arrays.asList("message"));
        }

        @Override
        protected GamePausedNotification createInstance() throws Exception {
            return new GamePausedNotification("jack leaved the game");
        }

        @Override
        protected GamePausedNotification createNotEqualInstance() throws Exception {
            return new GamePausedNotification("admin leaved the game");
        }
    }

    public static final class GamePausedNotificationPojoTest extends PojoClassTestCase {
        public GamePausedNotificationPojoTest(String name) {
            super(name, GameEndedNotification.class);
        }
    }

    public static final class GamePausedNotificationJacksonTest extends JacksonSerializationTestCase<Notification> {
        public GamePausedNotificationJacksonTest(String name) {
            super(name);
        }

        @Override
        public Notification expectedObject() {
            return new GamePausedNotification("admin leaved the game");
        }

        @Override
        public String expectedJson() {
            return "{\"type\":\"pause\",\"message\":\"admin leaved the game\"}";
        }
    }

}