package calculator.commands;

import calculator.context.ExecutionContext;

public abstract class Command {

    public abstract void execute(ExecutionContext context, String... params)throws NotEnoughElementsException;

    public class NotEnoughElementsException extends Exception {
        @Override
        public String toString() {
            return "Недостаточно значений для выполнения команды";
        }
    }
}
