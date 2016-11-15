package me.belakede.thesis.server.game.response;

import me.belakede.thesis.game.equipment.BoardType;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import me.belakede.thesis.time.TimeMachine;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(Enclosed.class)
public class GamesResponseTest {

    @BeforeClass
    public static void setUp() throws Exception {
        TimeMachine.useFixedClockAt(LocalDateTime.now());
    }

    @AfterClass
    public static void tearDown() throws Exception {
        TimeMachine.useSystemDefaultZoneClock();
    }

    public static final class GamesResponseEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public GamesResponseEqualsHashCodeTest(String name) {
            super(name, GamesResponse.class, Arrays.asList("id", "users", "time", "boardType"));
        }

        @Override
        protected GamesResponse createInstance() throws Exception {
            Map<Suspect, String> users = new HashMap<>();
            users.put(Suspect.SCARLET, "admin");
            users.put(Suspect.MUSTARD, "demo1");
            users.put(Suspect.GREEN, "demo2");
            return new GamesResponse(1L, BoardType.DEFAULT, TimeMachine.now(), users);
        }

        @Override
        protected GamesResponse createNotEqualInstance() throws Exception {
            Map<Suspect, String> users = new HashMap<>();
            users.put(Suspect.WHITE, "demo2");
            return new GamesResponse(2L, BoardType.ADVANCED, TimeMachine.now(), users);
        }
    }

    public static final class GamesResponsePojoTest extends PojoClassTestCase {

        public GamesResponsePojoTest(String name) {
            super(name, GamesResponse.class);
        }
    }
}