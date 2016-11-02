package me.belakede.thesis.server.game.response;

import me.belakede.thesis.game.equipment.BoardType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement
public class BoardNotification implements Serializable {
    private static final long serialVersionUID = 7184283344433343450L;

    @XmlElement
    private BoardType boardType;
    @XmlElement
    private List<FigurineNotification> positions;

    public BoardNotification() {
        // It's required for an entity
    }

    public BoardNotification(BoardType boardType, List<FigurineNotification> positions) {
        this.boardType = boardType;
        this.positions = positions;
    }

    public BoardType getBoardType() {
        return boardType;
    }

    public void setBoardType(BoardType boardType) {
        this.boardType = boardType;
    }

    public List<FigurineNotification> getPositions() {
        return positions;
    }

    public void setPositions(List<FigurineNotification> positions) {
        this.positions = positions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoardNotification that = (BoardNotification) o;

        return (boardType == that.boardType)
                && (positions != null ? positions.equals(that.positions) : that.positions == null);
    }

    @Override
    public int hashCode() {
        int result = boardType != null ? boardType.hashCode() : 0;
        result = 31 * result + (positions != null ? positions.hashCode() : 0);
        return result;
    }
}
