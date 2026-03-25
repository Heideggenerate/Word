package domain.counter;

import java.util.List;
import java.util.Set;

public class WordsCounter {

    private final WordRepository repository;

    public WordsCounter(WordRepository repository) {
        this.repository = repository;
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
