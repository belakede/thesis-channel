package me.belakede.thesis.server.game.response;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AccusationNotification.class, name = "accusation"),
        @JsonSubTypes.Type(value = CardNotification.class, name = "card"),
        @JsonSubTypes.Type(value = CurrentPlayerNotification.class, name = "player"),
        @JsonSubTypes.Type(value = FigurineNotification.class, name = "figurine"),
        @JsonSubTypes.Type(value = GameEndedNotification.class, name = "end"),
        @JsonSubTypes.Type(value = GamePausedNotification.class, name = "pause"),
        @JsonSubTypes.Type(value = GameStatusNotification.class, name = "game"),
        @JsonSubTypes.Type(value = PairOfDiceNotification.class, name = "dice"),
        @JsonSubTypes.Type(value = PlayerJoinedNotification.class, name = "join"),
        @JsonSubTypes.Type(value = PlayerOutNotification.class, name = "wrong"),
        @JsonSubTypes.Type(value = PlayerStatusNotification.class, name = "player_status"),
        @JsonSubTypes.Type(value = RoomNotification.class, name = "room"),
        @JsonSubTypes.Type(value = ShowYourCardNotification.class, name = "show"),
        @JsonSubTypes.Type(value = SuspicionNotification.class, name = "suspicion")
})
public interface Notification {
}
