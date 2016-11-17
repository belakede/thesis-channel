package me.belakede.thesis.server.game.response;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class HeartBeatNotification implements Notification, Serializable {
    private static final long serialVersionUID = -1800984810770650436L;
}
