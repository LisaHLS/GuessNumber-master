package com.tw.practice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    @Mock
    private NumberGenerator mockedGenerator;

    @Mock
    private Printer mockedPrinter;

    @Mock
    private NumberReader mockedReader;

    private final String generatedNumber = "1234";

    @Test
    public void shouldReturn4A0BWhenInputSameNumber() throws Exception {

        setGame(generatedNumber,"1234").start();

        Mockito.verify(mockedPrinter, Mockito.times(1)).print("please input a 4 digit number:");
        Mockito.verify(mockedPrinter, Mockito.times(1)).print("you win");
    }

    @Test
    public void shouldReturn0A0BWhenInputTotalDifferentNumber() throws Exception {

        setGame(generatedNumber,"5678").start();

        Mockito.verify(mockedPrinter, Mockito.times(1)).print("please input a 4 digit number:");
        Mockito.verify(mockedPrinter, Mockito.times(6)).print("0A0B");

    }

    @Test
    public void shouldReturn0A4BWhenInputPositionWrongNumber() throws Exception {

        setGame(generatedNumber,"2341").start();

        Mockito.verify(mockedPrinter, Mockito.times(1)).print("please input a 4 digit number:");
        Mockito.verify(mockedPrinter, Mockito.times(6)).print("0A4B");

    }

    @Test
    public void shouldReturn1A3BWhenInputOneRightThreePositionWrongNumber() throws Exception {

        setGame(generatedNumber,"4213").start();

        Mockito.verify(mockedPrinter, Mockito.times(1)).print("please input a 4 digit number:");
        Mockito.verify(mockedPrinter, Mockito.times(6)).print("1A3B");

    }

    @Test
    public void shouldReturn2A1BWhenInputTwoRightOneWrongOnePositionWrongNumber() throws Exception {

        setGame(generatedNumber,"2734").start();

        Mockito.verify(mockedPrinter, Mockito.times(1)).print("please input a 4 digit number:");
        Mockito.verify(mockedPrinter, Mockito.times(6)).print("2A1B");

    }

    public Game setGame(String generatedNumber, String readNumber) throws Exception{
        Mockito.when(mockedGenerator.generate()).thenReturn(generatedNumber);
        Mockito.when(mockedReader.read()).thenReturn(readNumber);
        return new Game(mockedGenerator, mockedPrinter, mockedReader);
    }
}