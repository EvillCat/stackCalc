package calculator.commands;

import calculator.context.ExecutionContext;

import java.util.EmptyStackException;

public class Sqrt extends Command {

    @Override
    public void execute(ExecutionContext context, String... params) {
        try {
            double value = context.getOneValueFromStack();
            context.putValueToStack(Math.sqrt(value));
        } catch (EmptyStackException ex) {
            System.out.println("Стэк пуст!");
        }
    }
}
