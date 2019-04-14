package calculator.processor;

import calculator.context.ExecutionContext;
import calculator.commands.Command;
import calculator.commands.CommandInvoker;
import calculator.commands.CommandsConstants;
import calculator.source.ConsoleSource;
import calculator.source.FileSource;
import calculator.source.Source;

import java.util.HashMap;
import java.util.Map;

public class CommandProcessor {

    private ExecutionContext context;
    private CommandInvoker commandInvoker;
    private Map<String, String> commands;
    private Source source;

    public CommandProcessor(String filepath) {
        commands = new HashMap<>();
        commands.put("/", CommandsConstants.DIVISION);
        commands.put("+", CommandsConstants.PLUS);
        commands.put("-", CommandsConstants.MINUS);
        commands.put("*", CommandsConstants.MULTIPLICATION);
        commands.put("define", CommandsConstants.DEFINE);
        commands.put("pop", CommandsConstants.POP);
        commands.put("push", CommandsConstants.PUSH);
        commands.put("sqrt", CommandsConstants.SQRT);
        commands.put("print", CommandsConstants.PRINT);

        commandInvoker = new CommandInvoker();
        context = new ExecutionContext();

        if (filepath != null) {
            source = new FileSource(filepath);
        } else {
            source = new ConsoleSource();
        }
    }

    private void checkOnCommand(String str) {
        String[] params;
        str = str.trim();
        str = str.toLowerCase();
        params = str.split(" ");
        if (commands.containsKey(params[0])) {
            params[0] = commands.get(params[0]);

            commandInvoker.execute(context, params);

        } else if (!params[0].equals("#")) {
            System.out.println("Неверная команда");
        }
    }

    public void readCommands() {
        String line;
        while ((line = source.getLine()) != null) {
            checkOnCommand(line);
        }
    }

}
