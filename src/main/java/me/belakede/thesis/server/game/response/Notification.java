package me.belakede.thesis.server.game.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import me.belakede.thesis.jackson.NotificationDeserializer;

@JsonDeserialize(using = NotificationDeserializer.class)
public interface Notification {
}
