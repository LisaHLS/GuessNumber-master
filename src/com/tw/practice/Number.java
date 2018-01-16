package com.tw.practice;

public class Number {
    private static final int NUMBER_LENGTH = 4;
    private String value;

    public Number(String value) {
        this.value = value;
    }

    public String compare(String stringToCompare) {
        int a = 0, b = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (value.charAt(i) == stringToCompare.charAt(i)) {
                a++;
            } else if (value.contains(stringToCompare.substring(i, i + 1))) {
                b++;
            }
        }
        return a + "A" + b + "B";
    }
}
