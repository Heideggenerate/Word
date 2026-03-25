package domain.counter;

import infrastructure.repositories.WordsRepository;

import java.util.List;
import java.util.Set;

public class WordsCounter {

    private final WordsRepository repository;
    private final IWordsApplication application;

    public WordsCounter(WordsRepository repository, IWordsApplication application) {
        this.repository = repository;
        this.application = application;
    }

    public void fillWords() {
        application.fill();
    }

    public int getCount(String word) {
        return repository.getCount(word);
    }

    public List<String> getWords(int count) {
        return repository.getWords(count);
    }

    public Set<String> getWordsKeys() {
        return repository.getWordsKeys();
    }

    public Set<Integer> getCountKeys() {
        return repository.getCountKeys();
    }
}
