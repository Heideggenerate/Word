package infrastructure;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

public class Writer implements AutoCloseable {

    private final BufferedWriter writer;

    public Writer(String path) throws IOException {
        this.writer = new BufferedWriter(new FileWriter(path));
    }

    public void write(String line) {
        try {
            writer.write(line);
        } catch (IOException ex) {
            throw new RuntimeException("Ошибка записи строки", ex);
        }
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException ex) {
            throw new RuntimeException("Ошибка закрытия записывающего файла", ex);
        }
    }
}
