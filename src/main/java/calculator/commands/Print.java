package calculator.commands;

import calculator.context.ExecutionContext;

import java.util.EmptyStackException;


public class Print extends Command {
    @Override
    public void execute(ExecutionContext context, String... params) throws NotEnoughElementsException {
        try {
            System.out.println(context.peek());
        } catch (EmptyStackException | NullPointerException ex) {
            System.out.println("Стэк пуст");
        }
    }
}
