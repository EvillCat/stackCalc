package calculator.commands;

import calculator.context.ExecutionContext;

public class Define extends Command {
    @Override
    public void execute(ExecutionContext context, String... params) throws NotEnoughElementsException,
                                                                           NumberFormatException {
        if (params.length < 3) {
            System.out.println("Неверное использование команды define");
            System.out.println("define \"имя переменной\" \"значение\" ");
            System.out.println("Пример: define a 4");
        } else {
            double value = Double.valueOf(params[2]);
            context.define(params[1], value);
        }
    }
}
