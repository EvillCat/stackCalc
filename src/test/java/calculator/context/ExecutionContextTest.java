package calculator.context;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExecutionContextTest {
    private ExecutionContext context;

    @Before
    public void setUp() {
        context = new ExecutionContext();
    }

    @Test
    public void testPutValueToStack() {
        context.putValueToStack(4);
        assertEquals(4, context.getOneValueFromStack(), 0);
    }

    @Test
    public void testPutDefinedToStack() {
        context.define("a", 3);
        context.putDefinedToStack("a");
        assertEquals(3, context.getOneValueFromStack(), 0);
    }

    @Test
    public void testGetOneValueFromStack() {
        context.putValueToStack(9);
        assertEquals(9, context.getOneValueFromStack(), 0);
    }

    @Test
    public void testPop() {
        context.putValueToStack(5);
        assertEquals(5, context.pop(), 0);
    }

    @Test
    public void testPeek() {
        context.putValueToStack(1);
        assertEquals(1, context.peek(), 0);
        context.getOneValueFromStack();
    }
}