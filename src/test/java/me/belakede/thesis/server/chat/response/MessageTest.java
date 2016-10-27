package me.belakede.thesis.server.chat.response;

import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import me.belakede.thesis.time.TimeMachine;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class MessageTest {

    @BeforeClass
    public static void setUp() {
        TimeMachine.useFixedClockAt(LocalDateTime.now());
    }

    @AfterClass
    public static void tearDown() throws Exception {
        TimeMachine.useSystemDefaultZoneClock();
    }

    public static final class MessageResponseEqualsAndHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public MessageResponseEqualsAndHashCodeTest(String name) {
            super(name, Message.class, Arrays.asList("sender", "time", "message"));
        }

        @Override
        protected Message createInstance() throws Exception {
            return new Message("admin", "Hello World!", TimeMachine.now());
        }

        @Override
        protected Message createNotEqualInstance() throws Exception {
            return new Message("user", "Hello World!");
        }
    }

    public static final class MessageResponsePojoTest extends PojoClassTestCase {

        public MessageResponsePojoTest(String name) {
            super(name, Message.class);
        }
    }
}