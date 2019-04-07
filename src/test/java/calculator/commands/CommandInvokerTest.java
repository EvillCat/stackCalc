package calculator.commands;

import calculator.context.ExecutionContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CommandInvokerTest {

    private CommandInvoker commandInvoker;
    private ExecutionContext context;

    @Before
    public void setUp() throws Exception {
        context = new ExecutionContext();
        commandInvoker = new CommandInvoker();
    }

    @After
    public void tearDown() throws Exception {
        commandInvoker = null;
        context = null;
    }

    @Test
    public void execute() {
        context.putValueToStack(4);
        try {
            commandInvoker.execute(context, "Sqrt");
        } catch (Command.NotEnoughElementsException e) {
            e.printStackTrace();
        }
    }
}