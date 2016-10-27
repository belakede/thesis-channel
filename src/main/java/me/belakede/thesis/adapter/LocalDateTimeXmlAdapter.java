package me.belakede.thesis.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;

public class LocalDateTimeXmlAdapter extends XmlAdapter<String, LocalDateTime> {

    @Override
    public String marshal(LocalDateTime localDateTime) throws Exception {
        return localDateTime.toString();
    }

    @Override
    public LocalDateTime unmarshal(String dateTime) throws Exception {
        return LocalDateTime.parse(dateTime);
    }
}