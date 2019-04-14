package calculator.commands;

import calculator.context.ExecutionContext;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DivisionTest {

    private Division division;
    private ExecutionContext context;

    @Before
    public void setUp() {
        context = new ExecutionContext();
        division = new Division();
    }

    @Test
    public void testExecute() {
        context.putValueToStack(4);
        context.putValueToStack(2);
        division.execute(context);
        assertEquals(2, context.peek(), 0);
    }
}