package me.belakede.thesis.server.game.response;

import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(Enclosed.class)
public class CoordinateTest {

    public static final class CoordinateEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public CoordinateEqualsHashCodeTest(String name) {
            super(name, Coordinate.class, Arrays.asList());
        }

        @Override
        protected Coordinate createInstance() throws Exception {
            return new Coordinate(12, 13);
        }

        @Override
        protected Coordinate createNotEqualInstance() throws Exception {
            return new Coordinate(13, 12);
        }
    }

    public static final class CoordinatePojoTest extends PojoClassTestCase {

        public CoordinatePojoTest(String name) {
            super(name, Coordinate.class);
        }
    }

}