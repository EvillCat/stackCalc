package calculator.commands;

import calculator.context.ExecutionContext;
import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class CommandInvokerTest {

    private CommandInvoker commandInvoker;
    private ExecutionContext context;

    @Before
    public void setUp() {
        context = new ExecutionContext();
        commandInvoker = new CommandInvoker();
    }

    @Test
    public void testIncorrectValuesExecute() {
        context.putValueToStack(4);
        commandInvoker.execute(context, "puch");
    }

    @Test
    public void testDefineCommandExecute() {
        commandInvoker.execute(context, "Define", "a", "4");
        commandInvoker.execute(context, "Push", "a");
        assertEquals(4, context.peek(), 0);
    }

    @Test
    public void testDivisionCommandExecute() {
        context.putValueToStack(2);
        context.putValueToStack(4);
        commandInvoker.execute(context, "Division");
        assertEquals(2, context.peek(), 0);
    }

    @Test
    public void testMultiplicationCommandExecute() {
        context.putValueToStack(2);
        context.putValueToStack(4);
        commandInvoker.execute(context, "Multiplication");
        assertEquals(8, context.peek(), 0);
    }

    @Test
    public void testPlusCommandExecute() {
        context.putValueToStack(2);
        context.putValueToStack(4);
        commandInvoker.execute(context, "Plus");
        assertEquals(6, context.peek(), 0);
    }

    @Test
    public void testMinusCommandExecute() {
        context.putValueToStack(4);
        context.putValueToStack(2);
        commandInvoker.execute(context, "Minus");
        assertEquals(2, context.peek(), 0);
    }

    @Test
    public void testSqrtCommandExecute() {
        context.putValueToStack(9);
        commandInvoker.execute(context, "Sqrt");
        assertEquals(3, context.peek(), 0);
    }

    @Test(expected = EmptyStackException.class)
    public void testPopCommandExecute() {
        context.putValueToStack(2);
        commandInvoker.execute(context, "Pop");
        context.getOneValueFromStack();
    }

    @Test
    public void testPrintCommandExecute() {
        context.putValueToStack(2);
        commandInvoker.execute(context, "Print");
        assertEquals(2, context.peek(), 0);
    }

    @Test
    public void testPushCommandExecute() {
        commandInvoker.execute(context, "Push", "6");
        assertEquals(6, context.peek(), 0);
    }


}