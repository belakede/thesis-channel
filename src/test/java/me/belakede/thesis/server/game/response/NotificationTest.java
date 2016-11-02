package me.belakede.thesis.server.game.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.belakede.thesis.game.equipment.Room;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.game.equipment.Weapon;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class NotificationTest {

    @Test
    public void testAccusationNotificationSerialization() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Notification accusation = new AccusationNotification(Suspect.GREEN, Room.HALL, Weapon.KNIFE);
        String expectedJson = "{\"type\":\"accusation\",\"suspect\":\"GREEN\",\"room\":\"HALL\",\"weapon\":\"KNIFE\"}";

        String actualJson = toJson(accusation);

        assertThat(actualJson, is(expectedJson));
    }

    @Test
    public void testAccusationNotificationDeserialization() throws Exception {
        String accusation = "{\"type\":\"accusation\",\"suspect\":\"WHITE\",\"room\":\"BATHROOM\",\"weapon\":\"ROPE\"}";
        Notification expectedObject = new AccusationNotification(Suspect.WHITE, Room.BATHROOM, Weapon.ROPE);

        Notification actual = toObject(accusation);

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