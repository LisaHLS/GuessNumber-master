package com.tw.practice;

import org.junit.Test;

import static org.junit.Assert.*;
public class NumberTest {

    private Number number = new Number("1234");

    @Test
    public void shouldReturn4A0BWhenTotalSame() {

        assertEquals("4A0B", number.compare("1234"));
    }

    @Test
    public void shouldReturn0A0BWhenTotalDifferent() {

        assertEquals("0A0B", number.compare("5678"));
    }

    @Test
    public void shouldReturn0A4BWhenOnlyNumberRight() {
        assertEquals("0A4B", number.compare("2341"));
    }

    @Test
    public void shouldReturn1A3BWhenOneRightThreePositionWrong() {

        assertEquals("1A3B", number.compare("1342"));
    }

    @Test
    public void shouldReturn2A1BWhenTwoRightOnePositionWrongOneWrong() {

        assertEquals("2A1B", number.compare("1253"));
    }
}
