package com.tw.practice;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class NumberReader {
    private Scanner scanner = new Scanner(System.in);

    public String read() throws Exception {
        String inputNumber = scanner.next();
        if (StringUtils.isNumeric(inputNumber) && inputNumber.length() == 4) {
            return inputNumber;
        }
        throw new Exception("Invalid Input");
    }
}
