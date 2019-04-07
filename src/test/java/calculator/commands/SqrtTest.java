package calculator.commands;

import calculator.context.ExecutionContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SqrtTest {
    private ExecutionContext context;
    private Sqrt sqrt;

    @Before
    public void setUp() {
        context = new ExecutionContext();
        sqrt =  new Sqrt();
    }

    @After
    public void tearDown() {
        context = null;
        sqrt = null;
    }

    @Test
    public void execute() {
        context.putValueToStack(9);
        try {
            sqrt.execute(context);
        } catch (Command.NotEnoughElementsException e) {
            e.printStackTrace();
        }
        assertEquals(3, context.peek(), 3);
    }
}