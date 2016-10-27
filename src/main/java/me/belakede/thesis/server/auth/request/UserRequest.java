package me.belakede.thesis.server.auth.request;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class UserRequest implements Serializable {

    private static final long serialVersionUID = 1116956581383586046L;

    @XmlElement(required = true)
    private String username;
    @XmlElement
    private String password;

    public UserRequest() {
        // It's required
    }

    public UserRequest(String username) {
        this.username = username;
    }

    public UserRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserRequest that = (UserRequest) o;

        return (username != null ? username.equals(that.username) : that.username == null) && (password != null ? password.equals(that.password) : that.password == null);
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

}
