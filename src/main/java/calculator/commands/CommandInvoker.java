package calculator.commands;

import calculator.context.ExecutionContext;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandInvoker {

    public void execute(ExecutionContext context, String... params) {
        Object commandInstance = null;
        try {
            Class commandClass = Class.forName("calculator.commands." + params[0]);
            Constructor constructor = commandClass.getConstructor();
            commandInstance = constructor.newInstance();
        } catch (ClassNotFoundException
                | NoSuchMethodException
                | IllegalAccessException
                | InstantiationException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
        try {
            if (commandInstance != null) {
                ((Command) commandInstance).execute(context, params);
            }
        } catch (ClassCastException | NullPointerException | Command.NotEnoughElementsException ex) {
            ex.printStackTrace();
        }

    }
}
