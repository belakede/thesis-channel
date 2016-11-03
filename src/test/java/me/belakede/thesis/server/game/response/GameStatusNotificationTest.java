package me.belakede.thesis.server.game.response;

import me.belakede.thesis.game.equipment.BoardType;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.game.equipment.Weapon;
import me.belakede.thesis.junit.ExtendedEqualsHashCodeTestCase;
import me.belakede.thesis.junit.JacksonSerializationTestCase;
import me.belakede.thesis.junit.PojoClassTestCase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.*;

@RunWith(Enclosed.class)
public class GameStatusNotificationTest {

    public static final class GameStatusNotificationEqualsHashCodeTest extends ExtendedEqualsHashCodeTestCase {
        public GameStatusNotificationEqualsHashCodeTest(String name) {
            super(name, GameStatusNotification.class, Arrays.asList("boardStatus", "players"));
        }

        @Override
        protected GameStatusNotification createInstance() throws Exception {
            List<FigurineNotification> positions = new ArrayList<>(5);
            positions.add(new FigurineNotification(Suspect.MUSTARD, new Coordinate(10, 14)));
            positions.add(new FigurineNotification(Suspect.SCARLET, new Coordinate(21, 9)));
            positions.add(new FigurineNotification(Weapon.KNIFE, new Coordinate(25, 26)));
            positions.add(new FigurineNotification(Weapon.ROPE, new Coordinate(1, 9)));
            Map<Suspect, String> players = new HashMap<>(3);
            players.put(Suspect.MUSTARD, "admin");
            players.put(Suspect.WHITE, "testuser1");
            players.put(Suspect.PLUM, "demouser1");
            return new GameStatusNotification(new BoardStatus(BoardType.DEFAULT, positions), players);
        }

        @Override
        protected GameStatusNotification createNotEqualInstance() throws Exception {
            List<FigurineNotification> positions = new ArrayList<>(5);
            positions.add(new FigurineNotification(Suspect.MUSTARD, new Coordinate(10, 14)));
            positions.add(new FigurineNotification(Suspect.SCARLET, new Coordinate(21, 9)));
            positions.add(new FigurineNotification(Weapon.KNIFE, new Coordinate(25, 26)));
            positions.add(new FigurineNotification(Weapon.ROPE, new Coordinate(1, 9)));
            Map<Suspect, String> players = new HashMap<>(3);
            players.put(Suspect.MUSTARD, "admin");
            players.put(Suspect.WHITE, "testuser1");
            players.put(Suspect.PLUM, "demouser1");
            return new GameStatusNotification(new BoardStatus(BoardType.ADVANCED, positions), players);
        }
    }

    public static final class GameStatusNotificationPojoTest extends PojoClassTestCase {
        public GameStatusNotificationPojoTest(String name) {
            super(name, GameStatusNotification.class);
        }
    }

    public static final class GameStatusNotificationJacksonTest extends JacksonSerializationTestCase<Notification> {
        public GameStatusNotificationJacksonTest(String name) {
            super(name);
        }

        @Override
        public Notification expectedObject() {
            List<FigurineNotification> positions = new ArrayList<>(5);
            positions.add(new FigurineNotification(Suspect.MUSTARD, new Coordinate(10, 14)));
            positions.add(new FigurineNotification(Suspect.SCARLET, new Coordinate(21, 9)));
            positions.add(new FigurineNotification(Weapon.KNIFE, new Coordinate(25, 26)));
            positions.add(new FigurineNotification(Weapon.ROPE, new Coordinate(1, 9)));
            Map<Suspect, String> players = new HashMap<>(3);
            players.put(Suspect.MUSTARD, "admin");
            players.put(Suspect.WHITE, "testuser1");
            players.put(Suspect.PLUM, "demouser1");
            return new GameStatusNotification(new BoardStatus(BoardType.ADVANCED, positions), players);
        }

        @Override
        public String expectedJson() {
            return "{\"type\":\"game\",\"boardStatus\":{\"boardType\":\"ADVANCED\",\"positions\":[{\"type\":\"figurine\",\"suspect\":\"MUSTARD\",\"weapon\":null,\"position\":{\"row\":10,\"column\":14}},{\"type\":\"figurine\",\"suspect\":\"SCARLET\",\"weapon\":null,\"position\":{\"row\":21,\"column\":9}},{\"type\":\"figurine\",\"suspect\":null,\"weapon\":\"KNIFE\",\"position\":{\"row\":25,\"column\":26}},{\"type\":\"figurine\",\"suspect\":null,\"weapon\":\"ROPE\",\"position\":{\"row\":1,\"column\":9}}]},\"players\":{\"WHITE\":\"testuser1\",\"MUSTARD\":\"admin\",\"PLUM\":\"demouser1\"}}";
        }

        @Override
        public Collection<String> jsonContains() {
            return Arrays.asList(
                    "\"type\":\"game\"",
                    "\"boardStatus\":{",
                    "\"boardType\":\"ADVANCED\"",
                    "\"positions\":[",
                    "{\"type\":\"figurine\",\"suspect\":\"MUSTARD\",\"weapon\":null,\"position\":{\"row\":10,\"column\":14}}",
                    "{\"type\":\"figurine\",\"suspect\":\"SCARLET\",\"weapon\":null,\"position\":{\"row\":21,\"column\":9}}",
                    "{\"type\":\"figurine\",\"suspect\":null,\"weapon\":\"KNIFE\",\"position\":{\"row\":25,\"column\":26}}",
                    "{\"type\":\"figurine\",\"suspect\":null,\"weapon\":\"ROPE\",\"position\":{\"row\":1,\"column\":9}}",
                    "\"players\":{",
                    "\"WHITE\":\"testuser1\"",
                    "\"MUSTARD\":\"admin\"",
                    "\"PLUM\":\"demouser1\""
            );
        }
    }

}