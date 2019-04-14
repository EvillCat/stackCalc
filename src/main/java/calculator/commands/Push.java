package calculator.commands;

import calculator.context.ExecutionContext;

public class Push extends Command {
    @Override
    public void execute(ExecutionContext context, String... params) {

        if (params.length != 2) {
            System.out.println("Недостаточно значений для выполнения команды");
        } else {
            try {
                context.putValueToStack(Double.valueOf(params[1]));
            } catch (NumberFormatException ex) {
                context.putDefinedToStack(params[1]);
            }
        }
    }
}
