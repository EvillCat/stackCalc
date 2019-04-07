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

    @After
    public void tearDown() {
        context = null;
    }

    @Test
    public void putValueToStack() {
        context.putValueToStack(4);
        assertEquals(4,context.getOneValueFromStack(), 4);
    }

    @Test
    public void putDefinedToStack() {
        context.define("a", 3);
        context.putDefinedToStack("a");
        assertEquals(3,context.getOneValueFromStack(), 3);
    }

    @Test
    public void getOneValueFromStack() {
        context.putValueToStack(9);
        assertEquals(9,context.getOneValueFromStack(), 9);
    }

    @Test
    public void getTwoValuesFromStack() {
        context.putValueToStack(8);
        context.putValueToStack(7);
        assertEquals(7,context.getOneValueFromStack(), 7);
        assertEquals(8,context.getOneValueFromStack(), 8);
    }

    @Test
    public void pop() {
        context.putValueToStack(5);
        assertEquals(5, context.pop(), 5);
    }

    @Test
    public void peek() {
        context.putValueToStack(1);
        assertEquals(1, context.peek(), 1);
    }
}