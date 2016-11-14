package me.belakede.thesis.server.game.request;

import me.belakede.thesis.game.equipment.BoardType;
import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(Enclosed.class)
public class GamesRequestTest {

    public static final class GamesRequestEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public GamesRequestEqualsHashCodeTest(String name) {
            super(name, GamesRequest.class, Arrays.asList("users", "boardType"));
        }

        @Override
        protected GamesRequest createInstance() throws Exception {
            return new GamesRequest(BoardType.DEFAULT, Arrays.asList("admin", "demo1", "demo2"));
        }

        @Override
        protected GamesRequest createNotEqualInstance() throws Exception {
            return new GamesRequest(BoardType.ADVANCED, Arrays.asList("demo2"));
        }
    }

    public static final class GamesRequestPojoTest extends PojoClassTestCase {

        public GamesRequestPojoTest(String name) {
            super(name, GamesRequest.class);
        }
    }

}