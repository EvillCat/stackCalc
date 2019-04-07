package calculator.commands;

import calculator.context.ExecutionContext;

import java.util.EmptyStackException;


public class Plus extends Command {

    @Override
    public void execute(ExecutionContext context, String... params) throws NotEnoughElementsException {
        double[] values = null;
        try {
            values = context.getTwoValuesFromStack();
            context.putValueToStack(values[0] + values[1]);
        } catch (EmptyStackException ex) {
            try{
                if (values.length > 0) {
                    for (Double value : values) {
                        context.putValueToStack(value);
                    }
                }
            } catch (NullPointerException e) {

            }
            throw new NotEnoughElementsException();
        }
    }
}
