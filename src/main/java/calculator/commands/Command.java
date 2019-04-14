package calculator.commands;

import calculator.context.ExecutionContext;

public abstract class Command {

    double value1;
    double value2;

    public abstract void execute(ExecutionContext context, String... params);

    void onEmptyStackException(ExecutionContext context, double value) {
        context.putValueToStack(value);
    }

}
