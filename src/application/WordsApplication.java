package application;

import domain.EntityGetaway;
import domain.WordRepository;

public class WordsApplication {

    private final EntityGetaway getaway;
    private final WordRepository repository;

    public WordsApplication(EntityGetaway getaway, WordRepository repository) {
        this.getaway = getaway;
        this.repository = repository;
    }

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
