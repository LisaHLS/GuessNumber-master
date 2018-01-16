package com.tw.practice;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberGeneratorTest {

    private NumberGenerator generator = new NumberGenerator();

    @Test
    public void shouldGenerateStringOfLengthFour() {
        String generatedNumber = generator.generate();
        assertEquals(4, generatedNumber.length());
    }

    @Test
    public void shouldGenerate4Digits() {
        String generatedNumber = generator.generate();
        assertTrue(StringUtils.isNumeric(generatedNumber));
    }

    @Test
    public void shouldGenerateNotRepeat() {
        String generatedNumber = generator.generate();
        for (int i = 0; i < 4; i++) {
            assertFalse(generatedNumber.substring(i + 1, 4).contains(generatedNumber.substring(i, i + 1)));
        }
    }
}