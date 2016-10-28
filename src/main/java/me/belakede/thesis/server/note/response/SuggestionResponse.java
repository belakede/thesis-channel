package me.belakede.thesis.server.note.response;

import me.belakede.thesis.game.equipment.Suspicion;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class SuggestionResponse implements Serializable {

    private static final long serialVersionUID = -1815793765631688612L;

    @XmlElement
    private Suspicion suspicion;

    public SuggestionResponse() {
    }

    public SuggestionResponse(Suspicion suspicion) {
        this.suspicion = suspicion;
    }

    public Suspicion getSuspicion() {
        return suspicion;
    }

    public void setSuspicion(Suspicion suspicion) {
        this.suspicion = suspicion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SuggestionResponse that = (SuggestionResponse) o;

        return suspicion != null ? suspicion.equals(that.suspicion) : that.suspicion == null;
    }

    @Override
    public int hashCode() {
        return suspicion != null ? suspicion.hashCode() : 0;
    }

}
