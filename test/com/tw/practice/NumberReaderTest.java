package com.tw.practice;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class NumberReaderTest {
    private NumberReader reader = new NumberReader();

    private void setInputStream(String input) throws NoSuchFieldException, IllegalAccessException {
        Field scannerField = reader.getClass().getDeclaredField("scanner");
        scannerField.setAccessible(true);
        Scanner scannerWithMockedStream = new Scanner(new ByteArrayInputStream(input.getBytes()));
        scannerField.set(reader, scannerWithMockedStream);
    }

    @Test
    public void shouldReadNumber() throws Exception {
        setInputStream("1234");
        assertEquals("1234", reader.read());
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionForNonNumberInput() throws Exception {
        setInputStream("123d");
        reader.read();
    }
}