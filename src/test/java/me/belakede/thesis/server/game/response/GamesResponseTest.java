package me.belakede.thesis.server.game.response;

import me.belakede.thesis.game.equipment.BoardType;
import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(Enclosed.class)
public class GamesResponseTest {
    public static final class GamesResponseEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public GamesResponseEqualsHashCodeTest(String name) {
            super(name, GamesResponse.class, Arrays.asList("users", "boardType"));
        }

        @Override
        protected GamesResponse createInstance() throws Exception {
            return new GamesResponse(1L, BoardType.DEFAULT, Arrays.asList("admin", "demo1", "demo2"));
        }

        @Override
        protected GamesResponse createNotEqualInstance() throws Exception {
            return new GamesResponse(2L, BoardType.ADVANCED, Arrays.asList("demo2"));
        }
    }

    public static final class GamesResponsePojoTest extends PojoClassTestCase {

        public GamesResponsePojoTest(String name) {
            super(name, GamesResponse.class);
        }
    }
}