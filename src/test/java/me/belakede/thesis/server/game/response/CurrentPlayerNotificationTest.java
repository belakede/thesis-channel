package me.belakede.thesis.server.game.response;

import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Collections;

@RunWith(Enclosed.class)
public class CurrentPlayerNotificationTest {

    public static final class CurrentPlayerNotificationEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public CurrentPlayerNotificationEqualsHashCodeTest(String name) {
            super(name, CurrentPlayerNotification.class, Collections.singletonList("current"));
        }

        @Override
        protected CurrentPlayerNotification createInstance() throws Exception {
            return new CurrentPlayerNotification("admin");
        }

        @Override
        protected CurrentPlayerNotification createNotEqualInstance() throws Exception {
            return new CurrentPlayerNotification("demo");
        }
    }

    public static final class CurrentPlayerNotificationPojoTest extends PojoClassTestCase {

        public CurrentPlayerNotificationPojoTest(String name) {
            super(name, CurrentPlayerNotification.class);
        }
    }

}