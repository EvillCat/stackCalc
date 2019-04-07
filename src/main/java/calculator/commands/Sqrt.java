package calculator.commands;

import calculator.context.ExecutionContext;

import java.util.EmptyStackException;


public class Sqrt extends Command {


    @Override
    public void execute(ExecutionContext context, String... params) throws NotEnoughElementsException {
        try {
            double value = context.getOneValueFromStack();
            context.putValueToStack(Math.sqrt(value));
        } catch (EmptyStackException ex) {
            throw new NotEnoughElementsException();
        }
    }
}
