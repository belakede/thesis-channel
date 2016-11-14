package me.belakede.thesis.server.game.request;

import me.belakede.thesis.game.equipment.BoardType;
import me.belakede.thesis.game.equipment.Suspect;
import me.belakede.thesis.server.game.Games;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Map;

@XmlRootElement
public class GamesRequest extends Games implements Serializable {
    private static final long serialVersionUID = 7386986036400206269L;

    public GamesRequest() {
        // It's required for an entity
    }

    public GamesRequest(BoardType boardType, Map<Suspect, String> users) {
        super(boardType, users);
    }

}
