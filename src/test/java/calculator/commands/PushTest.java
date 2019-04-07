package calculator.commands;

import calculator.context.ExecutionContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PushTest {
    private ExecutionContext context;
    private Push push;

    @Before
    public void setUp() {
        context = new ExecutionContext();
        push = new Push();
    }

    @After
    public void tearDown() {
        context = null;
        push = null;
    }

    @Test
    public void execute() {
        context.define("b", 47);
        try {
            push.execute(context, "Push", "23");
            push.execute(context, "Push", "b");
        } catch (Command.NotEnoughElementsException e) {
            e.printStackTrace();
        }
        assertEquals(47, context.pop(), 47);
        assertEquals(23, context.pop(), 23);
    }
}