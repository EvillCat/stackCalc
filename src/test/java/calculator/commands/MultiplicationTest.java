package calculator.commands;

import calculator.context.ExecutionContext;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplicationTest {
    private ExecutionContext context;
    private Multiplication multiplication;

    @Before
    public void setUp() {
        context = new ExecutionContext();
        multiplication = new Multiplication();
    }

    @Test
    public void testExecute() {
        context.putValueToStack(2);
        context.putValueToStack(2);
        multiplication.execute(context);
        assertEquals(4, context.peek(), 0);
    }
}