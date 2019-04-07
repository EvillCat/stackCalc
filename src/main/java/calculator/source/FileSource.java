package calculator.source;

import java.io.*;

public class FileSource implements Source {

    private File file;
    private BufferedReader reader;

    public FileSource(String filepath) {
        file = new File(filepath);
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getLine() {
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}
