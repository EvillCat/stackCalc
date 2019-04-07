package calculator.commands;

import calculator.context.ExecutionContext;

public class Push extends Command {
    @Override
    public void execute(ExecutionContext context, String... params) throws NotEnoughElementsException{
        if (params.length == 0) {
            throw new NotEnoughElementsException();
        } else {
            try{
                context.putValueToStack(Double.valueOf(params[1]));
            } catch (NumberFormatException ex) {
                context.putDefinedToStack(params[1]);
            }
        }
    }
}
