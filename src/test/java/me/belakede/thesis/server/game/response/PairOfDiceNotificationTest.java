package me.belakede.thesis.server.game.response;

import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.JacksonSerializationTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Collections;

@RunWith(Enclosed.class)
public class PairOfDiceNotificationTest {

    public static final class PairOfDiceNotificationEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {
        public PairOfDiceNotificationEqualsHashCodeTest(String name) {
            super(name, PairOfDiceNotification.class, Collections.emptyList());
        }

        @Override
        protected PairOfDiceNotification createInstance() throws Exception {
            return new PairOfDiceNotification(4, 5);
        }

        @Override
        protected PairOfDiceNotification createNotEqualInstance() throws Exception {
            return new PairOfDiceNotification(2, 5);
        }
    }

    public static final class PairOfDiceNotificationPojoTest extends PojoClassTestCase {
        public PairOfDiceNotificationPojoTest(String name) {
            super(name, PairOfDiceNotification.class);
        }
    }

    public static final class PairOfDiceNotificationJacksonTest extends JacksonSerializationTestCase<Notification> {
        public PairOfDiceNotificationJacksonTest(String name) {
            super(name);
        }

        @Override
        public Notification expectedObject() {
            return new PairOfDiceNotification(3, 6);
        }

        @Override
        public String expectedJson() {
            return "{\"type\":\"dice\",\"first\":3,\"second\":6}";
        }
    }

}