package calculator.commands;

import calculator.context.ExecutionContext;
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

    @Test
    public void testExecute() {
        context.define("b", 47);
        push.execute(context, "Push", "23");
        push.execute(context, "Push", "b");
        assertEquals(47, context.pop(), 0);
        assertEquals(23, context.pop(), 0);
    }
}