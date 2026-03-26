package application;

import domain.IEntityGateway;
import domain.IWordsRepository;
import domain.counter.IWordsApplication;

import java.util.List;

public class WordsApplication implements IWordsApplication {

    private final IEntityGateway getaway;
    private final IWordsRepository repository;

    public WordsApplication(IEntityGateway getaway, IWordsRepository repository) {
        this.getaway = getaway;
        this.repository = repository;
    }

    @Override
    public boolean fill(int n) {
        List<String> lines = getaway.readLines(n);
        if (lines.isEmpty())
            return false;
        for (String line : lines) {
            String[] words = extractWords(line);
            for (String word : words) {
                repository.insert(word, wordCountInsert(word, 1));
            }
        }
        return true;
    }

    public int wordCountInsert(String word, int count) {
        int sum = 0;
        if (repository.getCount(word) != null)
            sum += repository.getCount(word);
        return sum + count;
    }


    private String[] extractWords(String line) {
        return line.split(" ");
    }
}
