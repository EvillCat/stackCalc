package calculator.commands;

import calculator.context.ExecutionContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlusTest {
    private ExecutionContext context;
    private Plus plus;

    @Before
    public void setUp() {
        context =  new ExecutionContext();
        plus = new Plus();
    }

    @Test
    public void testExecute() {
        context.putValueToStack(3);
        context.putValueToStack(1);
        try {
            plus.execute(context);
        } catch (Command.NotEnoughElementsException e) {
            e.printStackTrace();
        }
        assertEquals(4, context.peek(), 0);
    }
}