package me.belakede.thesis.server.game.response;

import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.JacksonSerializationTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(Enclosed.class)
public class PlayerJoinedNotificationTest {

    public static final class PlayerJoinedNotificationEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {
        public PlayerJoinedNotificationEqualsHashCodeTest(String name) {
            super(name, PlayerJoinedNotification.class, Arrays.asList("user"));
        }

        @Override
        protected PlayerJoinedNotification createInstance() throws Exception {
            return new PlayerJoinedNotification("demo");
        }

        @Override
        protected PlayerJoinedNotification createNotEqualInstance() throws Exception {
            return new PlayerJoinedNotification("test");
        }
    }

    public static final class PlayerJoinedNotificationPojoTest extends PojoClassTestCase {
        public PlayerJoinedNotificationPojoTest(String name) {
            super(name, PlayerJoinedNotification.class);
        }
    }

    public static final class PlayerJoinedNotificationJacksonTest extends JacksonSerializationTestCase<Notification> {
        public PlayerJoinedNotificationJacksonTest(String name) {
            super(name);
        }

        @Override
        public Notification expectedObject() {
            return new PlayerJoinedNotification("Hello");
        }

        @Override
        public String expectedJson() {
            return "{\"type\":\"join\",\"user\":\"Hello\"}";
        }
    }

}