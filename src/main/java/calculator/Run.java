package calculator;

import calculator.processor.CommandProcessor;

public class Run {

    public static void main(String[] args) {

        String filepath;
        try {
            filepath = args[0];
        } catch (ArrayIndexOutOfBoundsException ex) {
            filepath = null;
        }

        CommandProcessor commandProcessor = new CommandProcessor(filepath);
        commandProcessor.readCommands();
    }
}
