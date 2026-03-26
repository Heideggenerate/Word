package infrastructure.sequencedaccess;

import domain.IEntityGateway;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader implements AutoCloseable, IEntityGateway {

    private final BufferedReader reader;

    public Reader(String path) throws IOException {
        reader = new BufferedReader(new FileReader(path));
        reader.mark(0);
    }

    @Override
    public List<String> readLines(int n) {
        try {
            String line;
            List<String> lines = new ArrayList<>();
            int count = 0;
            while ((line = reader.readLine()) != null && count++ < n)
                lines.add(line);
            return lines;
        } catch (IOException ex) {
            throw new RuntimeException("Ошибка чтения строки", ex);
        }
    }

    @Override
    public void reset() {
        try {
            reader.reset();
        } catch (IOException ex) {
            throw new RuntimeException("Ошибка возврата к началу чтения файла",ex);
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
