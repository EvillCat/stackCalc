package calculator.context;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExecutionContext {

    private Stack<Double> stack;
    private Map<String, Double> definedValues;


    public ExecutionContext() {
        stack = new Stack<>();
        definedValues = new HashMap<>();
    }

    public void putValueToStack(double value) {
        stack.push(value);
    }

    public void define(String alias, double value) {
        if (!definedValues.containsKey(alias)) {
            definedValues.put(alias, value);
        }
    }

    public void putDefinedToStack(String variableName) throws NumberFormatException {
        stack.push(definedValues.get(variableName));
    }

    public double getOneValueFromStack() {
        return stack.pop();
    }

    public double[] getTwoValuesFromStack() throws EmptyStackException {
        return new double[]{stack.pop(), stack.pop()};
    }

    public double pop() {
        return stack.pop();
    }

    public double peek() {
        return stack.peek();
    }


}


