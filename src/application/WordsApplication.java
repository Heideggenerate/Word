package application;

import domain.IEntityGetaway;
import domain.counter.IWordsApplication;
import domain.counter.WordRepository;

public class WordsApplication implements IWordsApplication {

    private final IEntityGetaway getaway;
    private final WordRepository repository;

    public WordsApplication(IEntityGetaway getaway, WordRepository repository) {
        this.getaway = getaway;
        this.repository = repository;
    }

    @Override
    public void fill() {
        String line;
        while ((line = getaway.readLine()) != null) {
            String[] words = extractWords(line);
            for (String word : words)
                repository.insert(word, 1);
        }
    }

    private String[] extractWords(String line) {
        return line.split(" ");
    }
}
