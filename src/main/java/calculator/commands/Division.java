package calculator.commands;

import calculator.context.ExecutionContext;

import java.util.EmptyStackException;

public class Division extends Command {

    @Override
    public void execute(ExecutionContext context, String... params) throws NotEnoughElementsException {

        try {
            value1 = context.getOneValueFromStack();
        } catch (EmptyStackException ex) {
            throw new NotEnoughElementsException();
        }

        try {
            value2 = context.getOneValueFromStack();
            context.putValueToStack(value1 / value2);
        } catch (EmptyStackException ex) {
            onEmptyStackException(context, value2);
            throw new NotEnoughElementsException();
        } catch (NullPointerException ex) {
            throw new NotEnoughElementsException();
        }

    }
}
