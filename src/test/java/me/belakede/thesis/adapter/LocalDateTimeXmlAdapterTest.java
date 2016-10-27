package me.belakede.thesis.adapter;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class LocalDateTimeXmlAdapterTest {

    private LocalDateTimeXmlAdapter testSubject;

    @Before
    public void setUp() throws Exception {
        testSubject = new LocalDateTimeXmlAdapter();
    }

    @Test
    public void testMarshalShouldReturnWithTheLocalDateTimeAsString() throws Exception {
        LocalDateTime now = LocalDateTime.now();
        String expected = now.toString();
        String actual = testSubject.marshal(now);
        assertThat(actual, is(expected));
    }

    @Test
    public void testUnmarshalShouldReturnWithTheLocalDateTime() throws Exception {
        LocalDateTime expected = LocalDateTime.now().minusDays(2);
        LocalDateTime actual = testSubject.unmarshal(expected.toString());
        assertThat(actual, is(expected));
    }

}