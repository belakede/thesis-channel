package me.belakede.thesis.server.game.response;

import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Collections;

@RunWith(Enclosed.class)
public class PairOfDiceStatusTest {

    public static final class PairOfDiceStatusEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public PairOfDiceStatusEqualsHashCodeTest(String name) {
            super(name, PairOfDiceStatus.class, Collections.emptyList());
        }

        @Override
        protected PairOfDiceStatus createInstance() throws Exception {
            return new PairOfDiceStatus(4, 5);
        }

        @Override
        protected PairOfDiceStatus createNotEqualInstance() throws Exception {
            return new PairOfDiceStatus(2, 5);
        }
    }

    public static final class PairOfDiceStatusPojoTest extends PojoClassTestCase {

        public PairOfDiceStatusPojoTest(String name) {
            super(name, PairOfDiceStatus.class);
        }
    }

}