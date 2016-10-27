package me.belakede.thesis.server.note.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement
public class NotesResponse implements Serializable {

    private static final long serialVersionUID = -811787534277202219L;

    @XmlElement
    private Set<NoteResponse> notes;

    public NotesResponse() {
        notes = new HashSet<>();
    }

    public NotesResponse(Set<NoteResponse> notes) {
        this.notes = notes;
    }

    public Set<NoteResponse> getNotes() {
        return notes;
    }

    public void setNotes(Set<NoteResponse> notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        NotesResponse that = (NotesResponse) o;

        return notes != null ? notes.equals(that.notes) : that.notes == null;
    }

    @Override
    public int hashCode() {
        return notes != null ? notes.hashCode() : 0;
    }
}
