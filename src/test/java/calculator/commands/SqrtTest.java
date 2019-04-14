package calculator.commands;

import calculator.context.ExecutionContext;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SqrtTest {
    private ExecutionContext context;
    private Sqrt sqrt;

    @Before
    public void setUp() {
        context = new ExecutionContext();
        sqrt = new Sqrt();
    }

    @Test
    public void testExecute() {
        context.putValueToStack(9);
        sqrt.execute(context);
        assertEquals(3, context.peek(), 0);
    }
}