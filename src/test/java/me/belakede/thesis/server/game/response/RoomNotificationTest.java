package me.belakede.thesis.server.game.response;

import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.JacksonSerializationTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Collections;

@RunWith(Enclosed.class)
public class RoomNotificationTest {

    public static final class RoomNotificationEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {
        public RoomNotificationEqualsHashCodeTest(String name) {
            super(name, RoomNotification.class, Collections.singletonList("room"));
        }

        @Override
        protected RoomNotification createInstance() throws Exception {
            return new RoomNotification("room-id-1");
        }

        @Override
        protected RoomNotification createNotEqualInstance() throws Exception {
            return new RoomNotification("room-id-2");
        }
    }

    public static final class RoomNotificationPojoTest extends PojoClassTestCase {
        public RoomNotificationPojoTest(String name) {
            super(name, RoomNotification.class);
        }
    }

    public static final class RoomNotificationJacksonTest extends JacksonSerializationTestCase<Notification> {
        public RoomNotificationJacksonTest(String name) {
            super(name);
        }

        @Override
        public Notification expectedObject() {
            return new RoomNotification("room-id");
        }

        @Override
        public String expectedJson() {
            return "{\"type\":\"room\",\"room\":\"room-id\"}";
        }
    }

}