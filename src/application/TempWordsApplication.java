package application;

import domain.IEntityGateway;
import domain.IWordsRepository;
import domain.counter.IWordsApplication;

public class TempWordsApplication implements IWordsApplication {

    private final IEntityGateway getaway;
    private final IWordsRepository repository;

    public TempWordsApplication(IEntityGateway getaway, IWordsRepository repository) {
        this.getaway = getaway;
        this.repository = repository;
    }

    @Override
    public void fill() {
        String line;
        while ((line = getaway.readLine()) != null) {
            String[] wordsWithCount = extractWordsWithCount(line);
            int count = Integer.parseInt(wordsWithCount[1]);

        }
    }

    public void write() {}

    private String[] extractWordsWithCount(String line) {
        return line.split(" ");
    }
}
