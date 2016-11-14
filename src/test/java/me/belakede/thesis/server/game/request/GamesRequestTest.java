package me.belakede.thesis.server.game.request;

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
public class GamesRequestTest {

    public static final class GamesRequestEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public GamesRequestEqualsHashCodeTest(String name) {
            super(name, GamesRequest.class, Arrays.asList("users", "boardType"));
        }

        @Override
        protected GamesRequest createInstance() throws Exception {
            Map<Suspect, String> users = new HashMap<>();
            users.put(Suspect.SCARLET, "admin");
            users.put(Suspect.MUSTARD, "demo1");
            users.put(Suspect.GREEN, "demo2");
            return new GamesRequest(BoardType.DEFAULT, users);
        }

        @Override
        protected GamesRequest createNotEqualInstance() throws Exception {
            Map<Suspect, String> users = new HashMap<>();
            users.put(Suspect.WHITE, "demo2");
            return new GamesRequest(BoardType.ADVANCED, users);
        }
    }

    public static final class GamesRequestPojoTest extends PojoClassTestCase {

        public GamesRequestPojoTest(String name) {
            super(name, GamesRequest.class);
        }
    }

}