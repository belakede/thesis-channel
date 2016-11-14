package me.belakede.thesis.server.game;

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
public class GamesTest {

    public static final class GamesEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public GamesEqualsHashCodeTest(String name) {
            super(name, Games.class, Arrays.asList("boardType", "users"));
        }

        @Override
        protected Games createInstance() throws Exception {
            Map<Suspect, String> users = new HashMap<>();
            users.put(Suspect.SCARLET, "admin");
            users.put(Suspect.MUSTARD, "demo1");
            users.put(Suspect.GREEN, "demo2");
            return new Games(BoardType.DEFAULT, users);
        }

        @Override
        protected Games createNotEqualInstance() throws Exception {
            Map<Suspect, String> users = new HashMap<>();
            users.put(Suspect.WHITE, "demo2");
            return new Games(BoardType.ADVANCED, users);
        }
    }

    public static final class GamesPojoTest extends PojoClassTestCase {

        public GamesPojoTest(String name) {
            super(name, Games.class);
        }
    }

}