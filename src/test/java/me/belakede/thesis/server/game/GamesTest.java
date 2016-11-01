package me.belakede.thesis.server.game;

import me.belakede.thesis.game.equipment.BoardType;
import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(Enclosed.class)
public class GamesTest {

    public static final class GamesEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public GamesEqualsHashCodeTest(String name) {
            super(name, Games.class, Arrays.asList("boardType", "users"));
        }

        @Override
        protected Games createInstance() throws Exception {
            return new Games(BoardType.DEFAULT, Arrays.asList("admin", "demo1", "demo2"));
        }

        @Override
        protected Games createNotEqualInstance() throws Exception {
            return new Games(BoardType.ADVANCED, Arrays.asList("demo1", "demo2"));
        }
    }

    public static final class GamesPojoTest extends PojoClassTestCase {

        public GamesPojoTest(String name) {
            super(name, Games.class);
        }
    }

}