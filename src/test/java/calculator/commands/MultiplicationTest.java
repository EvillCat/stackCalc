package calculator.commands;

import calculator.context.ExecutionContext;
import org.junit.After;
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

    @After
    public void tearDown() {
        context = null;
        multiplication = null;
    }

    @Test
    public void execute() {
        context.putValueToStack(2);
        context.putValueToStack(2);
        try {
            multiplication.execute(context);
        } catch (Command.NotEnoughElementsException e) {
            e.printStackTrace();
        }
        assertEquals(4, context.peek(), 4);
    }
}