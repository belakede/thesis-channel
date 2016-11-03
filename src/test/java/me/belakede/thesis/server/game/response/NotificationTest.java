package me.belakede.thesis.server.game.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.belakede.thesis.game.equipment.Room;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.game.equipment.Weapon;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.assertThat;

public class NotificationTest {

    @Test
    public void testCurrentPlayerNotificationSerialization() throws Exception {
        Notification player = new CurrentPlayerNotification("admin");
        String expectedJson = "{\"type\":\"player\",\"current\":\"admin\"}";

        String actualJson = toJson(player);

        assertThat(actualJson, is(expectedJson));
    }

    @Test
    public void testCurrentPlayerNotificationDeserialization() throws Exception {
        String player = "{\"type\":\"player\",\"current\":\"testuser\"}";
        Notification expectedObject = new CurrentPlayerNotification("testuser");

        Notification actual = toObject(player);

        assertThat(actual, is(expectedObject));
    }

    @Test
    public void testFigurineNotificationSerialization() throws Exception {
        Notification figurine = new FigurineNotification(Suspect.WHITE, new Coordinate(1, 10));
        String expectedJson = "{\"type\":\"figurine\",\"suspect\":\"WHITE\",\"weapon\":null,\"position\":{\"row\":1,\"column\":10}}";

        String actualJson = toJson(figurine);

        assertThat(actualJson, is(expectedJson));
    }

    @Test
    public void testFigurineNotificationDeserialization() throws Exception {
        String figurine = "{\"type\":\"figurine\",\"suspect\":null,\"weapon\":\"REVOLVER\",\"position\":{\"row\":28,\"column\":10}}";
        Notification expectedObject = new FigurineNotification(Weapon.REVOLVER, new Coordinate(28, 10));

        Notification actual = toObject(figurine);

        assertThat(actual, is(expectedObject));
    }

    @Test
    public void testPairOfDiceNotificationSerialization() throws Exception {
        Notification dice = new PairOfDiceNotification(3, 6);
        String expectedJson = "{\"type\":\"dice\",\"first\":3,\"second\":6}";

        String actualJson = toJson(dice);

        assertThat(actualJson, is(expectedJson));
    }

    @Test
    public void testPairOfDiceNotificationDeserialization() throws Exception {
        String dice = "{\"type\":\"dice\",\"first\":4,\"second\":5}";
        Notification expectedObject = new PairOfDiceNotification(4, 5);

        Notification actual = toObject(dice);

        assertThat(actual, is(expectedObject));
    }

    @Test
    public void testShowYourCardNotificationSerialization() throws Exception {
        Notification show = new ShowYourCardNotification("hello");
        String expectedJson = "{\"type\":\"show\",\"message\":\"hello\"}";

        String actualJson = toJson(show);

        assertThat(actualJson, is(expectedJson));
    }

    @Test
    public void testShowYourCardNotificationDeserialization() throws Exception {
        String show = "{\"type\":\"show\",\"message\":null}";
        Notification expectedObject = new ShowYourCardNotification();

        Notification actual = toObject(show);

        assertThat(actual, is(expectedObject));
    }

    @Test
    public void testSuspicionNotificationSerialization() throws Exception {
        Notification suspicion = new SuspicionNotification(Suspect.GREEN, Room.HALL, Weapon.KNIFE);
        String expectedJson = "{\"type\":\"suspicion\",\"suspect\":\"GREEN\",\"room\":\"HALL\",\"weapon\":\"KNIFE\"}";

        String actualJson = toJson(suspicion);

        assertThat(actualJson, is(expectedJson));
    }

    @Test
    public void testSuspicionNotificationDeserialization() throws Exception {
        String suspicion = "{\"type\":\"suspicion\",\"suspect\":\"WHITE\",\"room\":\"BATHROOM\",\"weapon\":\"ROPE\"}";
        Notification expectedObject = new SuspicionNotification(Suspect.WHITE, Room.BATHROOM, Weapon.ROPE);

        Notification actual = toObject(suspicion);

        assertThat(actual, is(expectedObject));
    }

    @Test
    public void testPlayerOutNotificationSerialization() throws Exception {
        Notification wrong = new PlayerOutNotification("testuser1", Arrays.asList("HALL", "KNIFE"));
        String expectedJson = "{\"type\":\"wrong\",\"user\":\"testuser1\",\"cards\":[\"HALL\",\"KNIFE\"]}";
        String otherExpectedJson = "{\"type\":\"wrong\",\"user\":\"testuser1\",\"cards\":[\"KNIFE\",\"HALL\"]}";

        String actualJson = toJson(wrong);

        assertThat(actualJson, isOneOf(expectedJson, otherExpectedJson));
    }

    @Test
    public void testPlayerOutNotificationDeserialization() throws Exception {
        String wrong = "{\"type\":\"wrong\",\"user\":\"admin\",\"cards\":[\"WHITE\",\"BATHROOM\",\"ROPE\"]}";
        Notification expectedObject = new PlayerOutNotification("admin", Arrays.asList(Suspect.WHITE.name(), Room.BATHROOM.name(), Weapon.ROPE.name()));

        Notification actual = toObject(wrong);

        assertThat(actual, is(expectedObject));
    }

    private String toJson(Notification notification) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(notification);
    }

    private Notification toObject(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, Notification.class);
    }

}