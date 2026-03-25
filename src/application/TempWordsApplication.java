package application;

import domain.EntityGetaway;
import domain.WordRepository;

public class TempWordsApplication {

    private final EntityGetaway getaway;
    private final WordRepository repository;

    public TempWordsApplication(EntityGetaway getaway, WordRepository repository) {
        this.getaway = getaway;
        this.repository = repository;
    }

    public void fillWords() {
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
