package calculator.source;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleSource implements Source {

    private InputStreamReader inputStreamReader;
    private BufferedReader reader;

    public ConsoleSource() {
        inputStreamReader = new InputStreamReader(System.in);
        reader = new BufferedReader(inputStreamReader);
    }

    @Override
    public String getLine() {
        String line = null;
        try {
            line = reader.readLine();
            if (line.equalsIgnoreCase("exit")) {
                line = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}
