package com.tw.practice;

public class Game {
    private static final String WIN_CODE = "4A0B";
    private Printer printer;
    private Number generatedNumber;
    private NumberReader reader;

    private int remainingGuessCount = 6;

    public Game(NumberGenerator numberGenerator, Printer printer, NumberReader reader) {
        this.printer = printer;
        this.reader = reader;
        this.generatedNumber = new Number(numberGenerator.generate());
    }

    public void start() {
        printer.print("please input a 4 digit number:");

        while (remainingGuessCount > 0) {
            try {
                String result = generatedNumber.compare(reader.read());
                if (WIN_CODE.equals(result)) {
                    printer.print("you win");
                    return;
                }

                printer.print(result);
                this.remainingGuessCount--;
            } catch (Exception e) {
                printer.print(e.getMessage());
            }
        }

        printer.print("Game Over");
    }

}
