package me.belakede.thesis.server.game.response;

import me.belakede.thesis.game.equipment.BoardType;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.game.equipment.Weapon;
import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(Enclosed.class)
public class BoardNotificationTest {

    public static final class BoardNotificationEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {

        public BoardNotificationEqualsHashCodeTest(String name) {
            super(name, BoardNotification.class, Arrays.asList("boardType", "positions"));
        }

        @Override
        protected BoardNotification createInstance() throws Exception {
            List<FigurineNotification> positions = new ArrayList<>(5);
            positions.add(new FigurineNotification(Suspect.MUSTARD, new Coordinate(10, 14)));
            positions.add(new FigurineNotification(Suspect.SCARLET, new Coordinate(21, 9)));
            positions.add(new FigurineNotification(Weapon.KNIFE, new Coordinate(25, 26)));
            positions.add(new FigurineNotification(Weapon.ROPE, new Coordinate(1, 9)));
            return new BoardNotification(BoardType.DEFAULT, positions);
        }

        @Override
        protected BoardNotification createNotEqualInstance() throws Exception {
            List<FigurineNotification> positions = new ArrayList<>(5);
            positions.add(new FigurineNotification(Suspect.MUSTARD, new Coordinate(10, 14)));
            positions.add(new FigurineNotification(Weapon.KNIFE, new Coordinate(25, 26)));
            positions.add(new FigurineNotification(Weapon.ROPE, new Coordinate(1, 9)));
            positions.add(new FigurineNotification(Weapon.CANDLESTICK, new Coordinate(2, 9)));
            return new BoardNotification(BoardType.DEFAULT, positions);
        }
    }

    public static final class BoardNotificationPojoTest extends PojoClassTestCase {

        public BoardNotificationPojoTest(String name) {
            super(name, BoardNotification.class);
        }
    }

}