package calculator.commands;

import calculator.context.ExecutionContext;

import java.util.EmptyStackException;

public class Minus extends Command {

    @Override
    public void execute(ExecutionContext context, String... params) {

        try {
            value1 = context.getOneValueFromStack();
        } catch (EmptyStackException ex) {
            System.out.println("Стэк пуст!");
        }

        try {
            value2 = context.getOneValueFromStack();
            context.putValueToStack(value1 - value2);
        } catch (EmptyStackException ex) {
            onEmptyStackException(context, value2);
            System.out.println("На стэке всего один элемент");
        } catch (NullPointerException ex) {
            System.out.println("Стэк пуст!");
        }
    }
}
