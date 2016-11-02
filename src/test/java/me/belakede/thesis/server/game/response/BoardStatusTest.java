package me.belakede.thesis.server.game.response;

import me.belakede.thesis.game.equipment.BoardType;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.game.equipment.Weapon;
import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(Enclosed.class)
public class BoardStatusTest {

    public static final class BoardStatusEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public BoardStatusEqualsHashCodeTest(String name) {
            super(name, BoardStatus.class, Arrays.asList("boardType", "positions"));
        }

        @Override
        protected BoardStatus createInstance() throws Exception {
            Map<Suspect, Coordinate> suspectPositions = new HashMap<>(2);
            suspectPositions.put(Suspect.MUSTARD, new Coordinate(10, 14));
            suspectPositions.put(Suspect.SCARLET, new Coordinate(21, 9));
            Map<Weapon, Coordinate> weaponPositions = new HashMap<>(2);
            weaponPositions.put(Weapon.KNIFE, new Coordinate(25, 26));
            weaponPositions.put(Weapon.ROPE, new Coordinate(1, 9));
            return new BoardStatus(BoardType.DEFAULT, suspectPositions, weaponPositions);
        }

        @Override
        protected BoardStatus createNotEqualInstance() throws Exception {
            Map<Suspect, Coordinate> suspectPositions = new HashMap<>(1);
            suspectPositions.put(Suspect.MUSTARD, new Coordinate(10, 14));
            Map<Weapon, Coordinate> weaponPositions = new HashMap<>(2);
            weaponPositions.put(Weapon.KNIFE, new Coordinate(25, 26));
            weaponPositions.put(Weapon.ROPE, new Coordinate(1, 9));
            weaponPositions.put(Weapon.CANDLESTICK, new Coordinate(2, 9));
            return new BoardStatus(BoardType.DEFAULT, suspectPositions, weaponPositions);
        }
    }

    public static final class BoardStatusPojoTest extends PojoClassTestCase {

        public BoardStatusPojoTest(String name) {
            super(name, BoardStatus.class);
        }
    }

}