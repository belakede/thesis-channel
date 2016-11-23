package me.belakede.thesis.server.game.response;

import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.JacksonSerializationTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import me.belakede.thesis.server.game.domain.Action;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(Enclosed.class)
public class CurrentPlayerNotificationTest {

    public static final class CurrentPlayerNotificationEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {
        public CurrentPlayerNotificationEqualsHashCodeTest(String name) {
            super(name, CurrentPlayerNotification.class, Arrays.asList("current", "next"));
        }

        @Override
        protected CurrentPlayerNotification createInstance() throws Exception {
            return new CurrentPlayerNotification("admin", "demo");
        }

        @Override
        protected CurrentPlayerNotification createNotEqualInstance() throws Exception {
            return new CurrentPlayerNotification("demo", "admin");
        }
    }

    public static final class CurrentPlayerNotificationPojoTest extends PojoClassTestCase {
        public CurrentPlayerNotificationPojoTest(String name) {
            super(name, CurrentPlayerNotification.class);
        }
    }

    public static final class CurrentPlayerJacksonTest extends JacksonSerializationTestCase<Notification> {
        public CurrentPlayerJacksonTest(String name) {
            super(name);
        }

        @Override
        public Notification expectedObject() {
            return new CurrentPlayerNotification("testuser", "demouser", Action.MOVE);
        }

        @Override
        public String expectedJson() {
            return "{\"type\":\"player\",\"current\":\"testuser\",\"next\":\"demouser\",\"action\":\"MOVE\"}";
        }
    }
}