package me.belakede.thesis.server.auth.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement
public class UsersResponse implements Serializable {

    private static final long serialVersionUID = 2172057914856197128L;

    @XmlElement
    private Set<UserResponse> users;

    public UsersResponse() {
        users = new HashSet<>();
    }

    public UsersResponse(Set<UserResponse> users) {
        this.users = users;
    }

    public Set<UserResponse> getUsers() {
        return users;
    }

    public void setUsers(Set<UserResponse> users) {
        this.users = new HashSet<>(users);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UsersResponse that = (UsersResponse) o;
        return users != null ? users.equals(that.users) : that.users == null;
    }

    @Override
    public int hashCode() {
        return users != null ? users.hashCode() : 0;
    }


}
