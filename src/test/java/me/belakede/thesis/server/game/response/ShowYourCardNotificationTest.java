package me.belakede.thesis.server.game.response;

import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Collections;

@RunWith(Enclosed.class)
public class ShowYourCardNotificationTest {

    public static final class ShowYourCardNotificationEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public ShowYourCardNotificationEqualsHashCodeTest(String name) {
            super(name, ShowYourCardNotification.class, Collections.singletonList("message"));
        }

        @Override
        protected ShowYourCardNotification createInstance() throws Exception {
            return new ShowYourCardNotification("Hi");
        }

        @Override
        protected ShowYourCardNotification createNotEqualInstance() throws Exception {
            return new ShowYourCardNotification("Hello");
        }
    }

    public static final class ShowYourCardNotificationPojoTest extends PojoClassTestCase {
        public ShowYourCardNotificationPojoTest(String name) {
            super(name, ShowYourCardNotification.class);
        }
    }

}