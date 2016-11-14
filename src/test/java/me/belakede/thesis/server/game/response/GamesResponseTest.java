package me.belakede.thesis.server.game.response;

import me.belakede.thesis.game.equipment.BoardType;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(Enclosed.class)
public class GamesResponseTest {
    public static final class GamesResponseEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public GamesResponseEqualsHashCodeTest(String name) {
            super(name, GamesResponse.class, Arrays.asList("id", "users", "boardType"));
        }

        @Override
        protected GamesResponse createInstance() throws Exception {
            Map<Suspect, String> users = new HashMap<>();
            users.put(Suspect.SCARLET, "admin");
            users.put(Suspect.MUSTARD, "demo1");
            users.put(Suspect.GREEN, "demo2");
            return new GamesResponse(1L, BoardType.DEFAULT, users);
        }

        @Override
        protected GamesResponse createNotEqualInstance() throws Exception {
            Map<Suspect, String> users = new HashMap<>();
            users.put(Suspect.WHITE, "demo2");
            return new GamesResponse(2L, BoardType.ADVANCED, users);
        }
    }

    public static final class GamesResponsePojoTest extends PojoClassTestCase {

        public GamesResponsePojoTest(String name) {
            super(name, GamesResponse.class);
        }
    }
}