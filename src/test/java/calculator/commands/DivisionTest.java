package calculator.commands;

import calculator.context.ExecutionContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DivisionTest {

    private Division division;
    private ExecutionContext context;

    @Before
    public void setUp() {
        context = new ExecutionContext();
        division = new Division();
    }

    @After
    public void tearDown() {
        context = null;
        division = null;
    }

    @Test
    public void execute() {
        context.putValueToStack(4);
        context.putValueToStack(2);
        try {
            division.execute(context);
        } catch (Command.NotEnoughElementsException e) {
            e.printStackTrace();
        }
        assertEquals(2, context.peek(), 2);
    }
}