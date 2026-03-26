package application;

import domain.IEntityGateway;
import domain.IWordsRepository;
import domain.counter.IWordsApplication;
import domain.counter.WordsCounter;

import java.util.List;

public class WordsApplication implements IWordsApplication {

    private final IEntityGateway getaway;
    private final IWordsRepository repository;
    private final WordsCounter wordsCounter;

    public WordsApplication(IEntityGateway getaway, IWordsRepository repository, WordsCounter wordsCounter) {
        this.getaway = getaway;
        this.repository = repository;
        this.wordsCounter = wordsCounter;
    }

    @Override
    public void fill(int n) {
        List<String> lines = getaway.readLines(n);
        for (String line : lines) {
            List<String> words = wordsCounter.correctWords(getWords(line));
            for (String word : words) {
                repository.insert(word, wordCountInsert(word, 1));
            }
        }

    }

    public int wordCountInsert(String word, int count) {
        int sum = 0;
        if (repository.getCount(word) != null)
            sum += repository.getCount(word);
        return sum + count;
    }

    public String[] getWords(String line) {
        return line.split(" ");
    }
}
