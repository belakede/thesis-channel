package me.belakede.thesis.server.game.request;

import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(Enclosed.class)
public class MoveRequestTest {

    public static final class MoveRequestEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public MoveRequestEqualsHashCodeTest(String name) {
            super(name, MoveRequest.class, Arrays.asList());
        }

        @Override
        protected MoveRequest createInstance() throws Exception {
            return new MoveRequest(13, 22);
        }

        @Override
        protected MoveRequest createNotEqualInstance() throws Exception {
            return new MoveRequest(22, 13);
        }
    }

    public static final class MoveRequestPojoTest extends PojoClassTestCase {

        public MoveRequestPojoTest(String name) {
            super(name, MoveRequest.class);
        }
    }

}