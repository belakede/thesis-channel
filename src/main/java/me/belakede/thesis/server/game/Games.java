package me.belakede.thesis.server.game;

import me.belakede.thesis.game.equipment.BoardType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class Games implements Serializable {
    private static final long serialVersionUID = -283366408918520107L;

    @XmlElement(required = true)
    private BoardType boardType;

    public Games() {
        // It's required for an entity
    }

    public Games(BoardType boardType) {
        this.boardType = boardType;
    }

    public BoardType getBoardType() {
        return boardType;
    }

    public void setBoardType(BoardType boardType) {
        this.boardType = boardType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Games games = (Games) o;

        return boardType == games.boardType;

    }

    @Override
    public int hashCode() {
        return boardType != null ? boardType.hashCode() : 0;
    }
}
