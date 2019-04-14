package calculator.commands;

import calculator.context.ExecutionContext;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinusTest {
    private ExecutionContext context;
    private Minus minus;

    @Before
    public void setUp() {
        context = new ExecutionContext();
        minus = new Minus();
    }

    @Test
    public void execute() {
        context.putValueToStack(2);
        context.putValueToStack(4);
        minus.execute(context);
        assertEquals(2, context.getOneValueFromStack(), 0);
    }
}