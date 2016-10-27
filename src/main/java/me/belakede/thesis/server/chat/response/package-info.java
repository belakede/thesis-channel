@XmlJavaTypeAdapters({
        @XmlJavaTypeAdapter(type=LocalDateTime.class, value=LocalDateTimeXmlAdapter.class)
})
package me.belakede.thesis.server.chat.response;

    import me.belakede.thesis.adapter.LocalDateTimeXmlAdapter;

    import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
    import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
    import java.time.LocalDateTime;