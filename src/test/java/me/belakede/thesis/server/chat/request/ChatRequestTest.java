package me.belakede.thesis.server.chat.request;

import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(Enclosed.class)
public class ChatRequestTest {

    public static final class ChatRequestEqualsAndHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public ChatRequestEqualsAndHashCodeTest(String name) {
            super(name, ChatRequest.class, Arrays.asList("room", "message"));
        }

        @Override
        protected ChatRequest createInstance() throws Exception {
            return new ChatRequest("room", "message");
        }

        @Override
        protected ChatRequest createNotEqualInstance() throws Exception {
            return new ChatRequest("room");
        }
    }

    public static final class ChatRequestPojoTest extends PojoClassTestCase {

        public ChatRequestPojoTest(String name) {
            super(name, ChatRequest.class);
        }
    }

}