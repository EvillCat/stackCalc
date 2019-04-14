package calculator.commands;

import calculator.context.ExecutionContext;

public abstract class Command {

    protected double value1;
    protected double value2;

    public abstract void execute(ExecutionContext context, String... params)throws NotEnoughElementsException;

    protected void onEmptyStackException(ExecutionContext context, double value) {
        context.putValueToStack(value);
    }

    public class NotEnoughElementsException extends Exception {
        @Override
        public String toString() {
            return "Недостаточно значений для выполнения команды";
        }
    }
}
