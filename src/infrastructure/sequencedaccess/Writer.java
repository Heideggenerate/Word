package infrastructure.sequencedaccess;

import domain.InputGateway;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer implements AutoCloseable, InputGateway {

    private final BufferedWriter writer;

    public Writer(String path) throws IOException {
        this.writer = new BufferedWriter(new FileWriter(path, false));
    }

    public void write(String line) {
        try {
            writer.write(line);
            writer.newLine();
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
