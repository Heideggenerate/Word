package infrastructure;

import domain.IEntityGateway;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader implements AutoCloseable, IEntityGateway {

    private final BufferedReader reader;

    public Reader(String path) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(path));
    }

    @Override
    public String readLine() {
        try {
            return reader.readLine();
        } catch (IOException ex) {
            throw new RuntimeException("Ошибка чтения строки", ex);
        }
    }

    @Override
    public void close() {
        try {
            reader.close();
        } catch (IOException ex) {
            throw new RuntimeException("Ошибка закрытия файла чтения", ex);
        }
    }
}
