package calculator.commands;

import calculator.context.ExecutionContext;

import java.util.EmptyStackException;

public class Pop extends Command {

    @Override
    public void execute(ExecutionContext context, String... params) {

        try {
            System.out.println("Число снято со стэка: " + context.pop());
        } catch (EmptyStackException ex) {
            System.out.println("Стэк пуст");
        }
    }
}
