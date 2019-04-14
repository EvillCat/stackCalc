package calculator.commands;

import calculator.context.ExecutionContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PopTest {

    private ExecutionContext context;
    private Pop pop;

    @Before
    public void setUp() {
         context = new ExecutionContext();
         pop = new Pop();
    }

    @Test
    public void testExecute() {
        context.putValueToStack(9);
        context.putValueToStack(8);
        try {
            pop.execute(context);
        } catch (Command.NotEnoughElementsException e) {
            e.printStackTrace();
        }
        assertEquals(9, context.peek(), 0);
    }
}