package application;

import domain.IEntityGetaway;
import domain.IWordsApplication;
import domain.counter.WordRepository;

public class TempWordsApplication implements IWordsApplication {

    private final IEntityGetaway getaway;
    private final WordRepository repository;

    public TempWordsApplication(IEntityGetaway getaway, WordRepository repository) {
        this.getaway = getaway;
        this.repository = repository;
    }

    @Override
    public void fill() {
        String line;
        while ((line = getaway.readLine()) != null) {
            String[] wordsWithCount = extractWordsWithCount(line);
            int count = Integer.parseInt(wordsWithCount[1]);
            repository.insert(wordsWithCount[0], count);
        }
    }

    private String[] extractWordsWithCount(String line) {
        return line.split(" ");
    }
}
