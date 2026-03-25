package application;

import domain.IEntityGateway;
import domain.IWordsRepository;
import domain.counter.IWordsApplication;

import java.util.List;

public class TempWordsApplication implements IWordsApplication {

    private final IEntityGateway getaway;
    private final IWordsRepository repository;

    public TempWordsApplication(IEntityGateway getaway, IWordsRepository repository) {
        this.getaway = getaway;
        this.repository = repository;
    }

    @Override
    public void fill() {
        List<String> lines = getaway.readLines();
        for (String line : lines) {
            String[] wordsWithCount = extractWordsWithCount(line);
            int count = Integer.parseInt(wordsWithCount[1]);

        }
    }

    public void write() {}

    private String[] extractWordsWithCount(String line) {
        return line.split(" ");
    }
}
