package me.belakede.thesis.server.game.response;

import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.JacksonSerializationTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(Enclosed.class)
public class GameEndedNotificationTest {

    public static final class GameEndedNotificationEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {
        public GameEndedNotificationEqualsHashCodeTest(String name) {
            super(name, GameEndedNotification.class, Arrays.asList("winner"));
        }

        @Override
        protected GameEndedNotification createInstance() throws Exception {
            return new GameEndedNotification("admin");
        }

        @Override
        protected GameEndedNotification createNotEqualInstance() throws Exception {
            return new GameEndedNotification("jack");
        }
    }

    public static final class GameEndedNotificationPojoTest extends PojoClassTestCase {
        public GameEndedNotificationPojoTest(String name) {
            super(name, GameEndedNotification.class);
        }
    }

    public static final class GameEndedNotificationJacksonTest extends JacksonSerializationTestCase<Notification> {
        public GameEndedNotificationJacksonTest(String name) {
            super(name);
        }

        @Override
        public Notification expectedObject() {
            return new GameEndedNotification("user");
        }

        @Override
        public String expectedJson() {
            return "{\"type\":\"end\",\"winner\":\"user\"}";
        }
    }

}