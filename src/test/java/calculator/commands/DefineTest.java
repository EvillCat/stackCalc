package calculator.commands;

import calculator.context.ExecutionContext;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DefineTest {
    private Define define;
    private ExecutionContext context;

    @Before
    public void setUp() throws Exception {
        context = new ExecutionContext();
        define = new Define();
    }

    @Test
    public void testExecute() {
        define.execute(context, "Define", "a", "4");
        context.putDefinedToStack("a");
        assertEquals(4, context.peek(), 4);
    }
}